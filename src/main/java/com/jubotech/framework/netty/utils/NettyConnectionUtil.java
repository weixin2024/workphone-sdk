package com.jubotech.framework.netty.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.proxy.ProxyUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.WeChatOfflineNotice.WeChatOfflineNoticeMessage;
import io.netty.channel.ChannelHandlerContext;

public class NettyConnectionUtil {
	
	private static final Logger log = LoggerFactory.getLogger(NettyConnectionUtil.class);  
	
	//////////////////////////////////////// 以下用来存通道///////////////////////////////////////////
	/**
	 * key 为deviceid 
	 * value 为channel 用于存贮通道
	 */
	public static Map<String, ChannelHandlerContext> deviceid_nettyChannel = new ConcurrentHashMap<String, ChannelHandlerContext>();

	//////////////////////////////////////////// 以下用来绑定通道////////////////////////////////////////////
	/**
	 * key userId 微信唯一id 或者 pc端账号名 
	 * value ChannelHandlerContext
	 */
	public static Map<String, ChannelHandlerContext> userId_nettyChannel = new ConcurrentHashMap<String, ChannelHandlerContext>();

	 
	/**
	 * 存储通道
	 * 
	 * @param cx
	 * @param deviceid
	 */
	public static synchronized void saveDeviceChannel(ChannelHandlerContext cx, String deviceid) {
		ChannelHandlerContext cc = getNettyChannelByDeviceid(deviceid);
		if (null != cc) {
			deviceid_nettyChannel.remove(deviceid);
		}
		deviceid_nettyChannel.put(deviceid, cx);
	}

	 
	/**
	 * 通过deviceid获取通道
	 * 
	 * @return
	 */
	public static synchronized ChannelHandlerContext getNettyChannelByDeviceid(String deviceid) {
		ChannelHandlerContext ctx = deviceid_nettyChannel.get(deviceid);
		if (null != ctx) {
			return ctx;
		} else {
			return null;
		}
	}

	/**
	 * 删除通道
	 */
	public static synchronized void removeChannel(ChannelHandlerContext cx) {
		// 清除设备通道
		try {
			String nettyid = getNettyId(cx);
			if (!StringUtils.isEmpty(nettyid)) {
				String deviceid = getDeviceidByNettyid(nettyid);
				WxAccountService wechatservice = ProxyUtil.getBean("wxAccountService",
						WxAccountService.class);
				if (null != deviceid && !"".equals(deviceid)) {
					deviceid_nettyChannel.remove(deviceid);
					if (null != wechatservice) {
						// 手机端下线
						WxAccountInfo wechat = wechatservice.findWeChatAccountInfoByDeviceid(deviceid);
						if (null != wechat) {// 手机设备断线，微信也下线
							wechat.setIsonline(1);
							wechatservice.updateOnlineLogined(wechat);
							// 下线通知pc端
							//sendDeviceOffLineMsgToPc(wechat.getAccountid(), wechat.getWechatid(), deviceid);
						}
					}
				}

				// 清除微信通道
				String userid = getUserIdByNettyId(nettyid);
				if (!StringUtils.isEmpty(userid)) {
					userId_nettyChannel.remove(userid);
				}

				// pc端断线，logined与acccountid状态修改
				AccountService accountService = ProxyUtil.getBean("accountService", AccountService.class);
				if (null != accountService) {
					AccountInfo acc = accountService.findAccountInfoByAccount(userid);
					if (null != acc) {
						List<WxAccountInfo> list = wechatservice.findWeChatAccountInfo(null, acc.getId());
						if (null != list && list.size() > 0) {
							for (int i = 0; i < list.size(); i++) {
								WxAccountInfo wai = list.get(i);
								wai.setIslogined(1);
								wechatservice.updateLogined(wai);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 客户端退出时调用，清理数据
	 * 
	 * @param ctx
	 */
	public static synchronized void exit(ChannelHandlerContext ctx) {
		try {
			log.info("当前netty通道连接数"+deviceid_nettyChannel.size()+"   有效通道连接数"+userId_nettyChannel.size());
			removeChannel(ctx);
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 注册真实用户，客户端以imei为准、pc端以账号用户名为准
	 * 
	 * @param userId
	 * @param cx
	 */
	public static synchronized void registerUserid(String userId, ChannelHandlerContext cx) {
		log.info("当前netty通道连接数"+deviceid_nettyChannel.size()+"   有效通道连接数"+userId_nettyChannel.size());
		ChannelHandlerContext chc = userId_nettyChannel.get(userId);
		if (null != chc) {
			userId_nettyChannel.remove(userId);
		}
		userId_nettyChannel.put(userId, cx);
	}
	
	
	/**
	 * 通过userId获取nettyId
	 * @param nettyid
	 * @return
	 */
	public static synchronized String  getUserIdByNettyId(String nettyid){
		return getKey(userId_nettyChannel, nettyid);
	}
	
	/**
	 * 通过nettyid获取deviceid
	 * 
	 * @param nettyid
	 * @return
	 */
	public static synchronized String getDeviceidByNettyid(String nettyId) {
		return getKey(deviceid_nettyChannel, nettyId);
	}
	
	public static synchronized ChannelHandlerContext getClientChannelHandlerContextByUserId(String userId) {
		ChannelHandlerContext chc = userId_nettyChannel.get(userId);
		if (null != chc) {
			return chc;
		} else {
			return null;
		}
	}

	public static synchronized String getNettyId(ChannelHandlerContext cx) {
		return cx.channel().id().asShortText();
	}
	
	
	/**
	 * 根据map的value获取map的key  
	 * @param map
	 * @param value
	 * @return
	 */
    private static synchronized String getKey(Map<String, ChannelHandlerContext> map,String value){  
        String key = null;  
        for (Map.Entry<String, ChannelHandlerContext> entry : map.entrySet()) {  
            if(value.equals(getNettyId(entry.getValue()))){  
                key=entry.getKey();  
            }  
        }  
        return key;  
    } 

	@SuppressWarnings("unused")
	private static synchronized void sendDeviceOffLineMsgToPc(Integer accountId, String wechatId, String deviceid) {
		try {
			AccountService accountService = ProxyUtil.getBean("accountService", AccountService.class);
			AccountInfo accInfo = accountService.findAccountInfoByid(accountId);
			if (null != accInfo) {
				// 转发给pc端
				ChannelHandlerContext chx = NettyConnectionUtil
						.getClientChannelHandlerContextByUserId(accInfo.getAccount());
				if (null != chx) {

					WeChatOfflineNoticeMessage req = WeChatOfflineNoticeMessage.newBuilder().setWeChatId(wechatId)
							.setIMEI(deviceid).build();

					MessageUtil.sendJsonMsg(chx, EnumMsgType.WeChatOfflineNotice, NettyConnectionUtil.getNettyId(chx),
							null, req);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
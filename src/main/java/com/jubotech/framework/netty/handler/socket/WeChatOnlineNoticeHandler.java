package com.jubotech.framework.netty.handler.socket;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;
import com.jubotech.framework.util.EmojiFilter;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatOnlineNotice.WeChatOnlineNoticeMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class WeChatOnlineNoticeHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxAccountService weChatAccountService;
	 
	@Autowired
	private AsyncTaskService asyncTaskService;
	 
	/** 
	 * 微信上线通知 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	WeChatOnlineNoticeMessage req = vo.getContent().unpack(WeChatOnlineNoticeMessage.class);
        	log.debug(JsonFormat.printer().print(req));
        	//1、校验用户信息
        	if(null != req){
	        	//2、存储微信全局id 与通道
	        	NettyConnectionUtil.registerUserid(req.getWeChatId(),ctx);
	        	  
	    		WxAccountInfo  accountInfo =  weChatAccountService.findWeChatAccountInfoByDeviceid(req.getIMEI());
        		if(null != accountInfo){
    				//做个保护，如果当前微信号在其他设备上登陆过，就把之前那条记录删除
    				if(!StringUtils.isBlank(req.getWeChatId()) && !StringUtils.isBlank(req.getIMEI())){
    					List<WxAccountInfo> list= weChatAccountService.findWeChatAccountInfoByWeChatIdNotEqualsDeviceid(req.getWeChatId(), req.getIMEI());
            			if(null != list && list.size()>0){
            				for(int i=0;i<list.size();i++){
            					WxAccountInfo info = list.get(i);
            					weChatAccountService.delete(info.getId());
            				}
            			} 
    				}
        			//设置新的参数
        			setAccountInfo(req, accountInfo);
        			 
        			//改为上线状态
        			accountInfo.setIsonline(0);//上线
    				weChatAccountService.updateOnline(accountInfo);
    				//3、告诉客户端消息已收到
            		MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
            		
        		}
        		
        		if(null != accountInfo){
    				asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.WeChatOnlineNotice, req);
    				//触发推送微信通讯录
//    				TriggerFriendPushTaskMessage.Builder bd = TriggerFriendPushTaskMessage.newBuilder();
//    				bd.setWeChatId(req.getWeChatId());
//    				TriggerFriendPushTaskMessage  resp = bd.build();
//    				MessageUtil.sendMsg(ctx, EnumMsgType.TriggerFriendPushTask, vo.getAccessToken(), null, resp);
        		}
        		 
        	} 
         
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), e.getMessage());
        }
    }
	private void setAccountInfo(WeChatOnlineNoticeMessage req, WxAccountInfo accountInfo) {
		String nickName = EmojiFilter.filterEmoji(req.getWeChatNick());//过滤emoji
		accountInfo.setWechatid(req.getWeChatId());
		accountInfo.setWechatno(req.getWeChatNo());
		accountInfo.setWechatnick(nickName);
		accountInfo.setGender(req.getGenderValue());
		accountInfo.setCountry(req.getCountry());
		accountInfo.setCity(req.getCity());
		accountInfo.setAvatar(req.getAvatar());
		accountInfo.setProvince(req.getProvince());
		weChatAccountService.update(accountInfo);
	}
}
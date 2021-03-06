package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;

import Jubo.JuLiao.IM.Wx.Proto.AccountLogoutNotice.AccountLogoutNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class AccountLogoutNoticeWebsocketHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxAccountService weChatAccountService;
	 
	/** 
	 * pc客户端退出通知
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	AccountLogoutNoticeMessage.Builder bd = AccountLogoutNoticeMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
    		AccountLogoutNoticeMessage req = bd.build();
        	//AccountLogoutNoticeMessage req = vo.getContent().unpack(AccountLogoutNoticeMessage.class);
        	//1、校验用户信息
        	if(null != req){
        		Integer id = (int) req.getUnionId();
        		List<WxAccountInfo> list =  weChatAccountService.findWeChatAccountInfo(null, id);
        		if(null != list && list.size()>0){
	        		for(int i=0;i<list.size();i++){
	        			WxAccountInfo info = list.get(i);
	        			if(null != info.getIslogined() && null != info.getAccountid() && 0 == info.getIslogined() && info.getAccountid() == id){
	        				info.setIslogined(1);//状态改成未登录
		        			//info.setAccountid(null);//账号置空
		        			weChatAccountService.updateLogined(info);
	        			}
	        		}	
        		}
        	} 
        	
        	//2、刷新缓存
			weChatAccountService.refreshCache();
        	
        	//3、告诉客户端消息已收到
    		MessageUtil.sendJsonMsg(ctx, EnumMsgType.DeviceExitNotice, vo.getAccessToken(), vo.getId(), null);
            //关闭连接
    		NettyConnectionUtil.exit(ctx);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
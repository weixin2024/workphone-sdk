package com.jubotech.framework.netty.handler.socket;
 
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.FriendTalkNotice.FriendTalkNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class FriendTalkNoticeHandler {
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxAccountService weChatAccountService;
	@Autowired
	private AsyncTaskService asyncTaskService; 
 
	/**
	 * 微信好友发来聊天消息
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
		try {
			FriendTalkNoticeMessage req = vo.getContent().unpack(FriendTalkNoticeMessage.class);
			log.debug(JsonFormat.printer().print(req));
			
			log.debug(LocalDateTime.now()+" 微信好友发来聊天消息  对应的线程名: "+Thread.currentThread().getName());
			  
            //拦截消息
			asyncTaskService.msgAopTask(ctx,req,vo.getAccessToken(), vo.getId());
			//消息转发到pc端
			asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.FriendTalkNotice, req);
			 
        	// 告诉客户端消息已收到
        	MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
        	
        	WxAccountInfo account = weChatAccountService.findWeChatAccountInfoByWeChatId(req.getWeChatId());
			//消息记录数据库
			if (null != account){
				asyncTaskService.saveMessage(account, req);
		    }
			 
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), e.getMessage());
		}
	}
	

	 
}
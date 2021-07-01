package com.jubotech.framework.netty.handler.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import Jubo.JuLiao.IM.Wx.Proto.TriggerFriendPushTask.TriggerFriendPushTaskMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class TriggerFriendPushTaskWebsocketHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AsyncTaskService asyncTaskService;
	/**
	 * 触发手机推送好友列表任务---pc端经过服务端转发给手机端
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	TriggerFriendPushTaskMessage.Builder bd = TriggerFriendPushTaskMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
    		TriggerFriendPushTaskMessage req = bd.build();
        	//TriggerFriendPushTaskMessage req = vo.getContent().unpack(TriggerFriendPushTaskMessage.class);
        	
        	//将消息转发送给手机客户端
        	asyncTaskService.msgSend2Phone(ctx, req.getWeChatId(), EnumMsgType.TriggerFriendPushTask, vo, req);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
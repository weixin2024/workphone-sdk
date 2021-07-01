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

import Jubo.JuLiao.IM.Wx.Proto.AddFriendFromPhonebookTask.AddFriendFromPhonebookTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class AddFriendFromPhonebookTaskWebsocketHandler{
	@Autowired
	private AsyncTaskService asyncTaskService;
	
	private  final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 通讯录加好友 ---pc端经过服务端转发给手机端
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	AddFriendFromPhonebookTaskMessage.Builder bd = AddFriendFromPhonebookTaskMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
        	AddFriendFromPhonebookTaskMessage req = bd.build();
        	//将消息转发送给手机客户端
        	asyncTaskService.msgSend2Phone(ctx, req.getWeChatId(), EnumMsgType.AddFriendFromPhonebookTask, vo, req);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
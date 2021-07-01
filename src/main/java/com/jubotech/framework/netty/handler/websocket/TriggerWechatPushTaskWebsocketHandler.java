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
import Jubo.JuLiao.IM.Wx.Proto.TriggerWechatPushTask.TriggerWechatPushTaskMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class TriggerWechatPushTaskWebsocketHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AsyncTaskService asyncTaskService;
	/**
	 * 触发微信上线通知，用于更新微信账号的信息
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	TriggerWechatPushTaskMessage.Builder bd = TriggerWechatPushTaskMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
        	TriggerWechatPushTaskMessage req = bd.build();
        	 
        	asyncTaskService.msgSend2Phone(ctx, req.getWeChatId(), EnumMsgType.TriggerWechatPushTask, vo, req);
        	
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
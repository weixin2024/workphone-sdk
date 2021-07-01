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

import Jubo.JuLiao.IM.Wx.Proto.TalkToFriendTask.TalkToFriendTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class TalkToFriendTaskWebsocketHandler {
	@Autowired
	private AsyncTaskService asyncTaskService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 服务端、客服客户端发给设备的指令类消息
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.debug(contentJsonStr);
			TalkToFriendTaskMessage.Builder bd = TalkToFriendTaskMessage.newBuilder();
			JsonFormat.parser().merge(contentJsonStr, bd);
			TalkToFriendTaskMessage req = bd.build();
			// 消息记录数据库
			asyncTaskService.savePcMessage(req);
			// 将消息转发送给手机客户端
			asyncTaskService.msgSend2Phone(ctx, req.getWeChatId(), EnumMsgType.TalkToFriendTask, vo, req);

		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

}
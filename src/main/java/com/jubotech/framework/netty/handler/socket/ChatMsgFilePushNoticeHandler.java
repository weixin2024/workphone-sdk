package com.jubotech.framework.netty.handler.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.ChatMsgFilePushNotice.ChatMsgFilePushNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class ChatMsgFilePushNoticeHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	 
	@Autowired
	private AsyncTaskService asyncTaskService;
	
	/**
	 * 聊天消息的图片，视频，文件推送
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	ChatMsgFilePushNoticeMessage req = vo.getContent().unpack(ChatMsgFilePushNoticeMessage.class);
        	log.debug(JsonFormat.printer().print(req));
			 
			asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.ChatMsgFilePushNotice, req);
			
			asyncTaskService.updateFileMsgContent(req.getWeChatId(), req.getUrl(), req.getMsgSvrId());
			 
			// 告诉客户端消息已收到
			MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
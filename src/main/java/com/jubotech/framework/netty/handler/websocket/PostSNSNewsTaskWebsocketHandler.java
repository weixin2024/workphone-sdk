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

import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class PostSNSNewsTaskWebsocketHandler{
	@Autowired
	private AsyncTaskService asyncTaskService;
	
	private  final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 发送朋友圈任务
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */

    @Async
    public  void handleMsg(ChannelHandlerContext ctx,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	PostSNSNewsTaskMessage.Builder bd = PostSNSNewsTaskMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
    		PostSNSNewsTaskMessage req = bd.build();
        	//PostSNSNewsTaskMessage req = vo.getContent().unpack(PostSNSNewsTaskMessage.class);
        	  
        	asyncTaskService.msgSend2Phone(ctx, req.getWeChatId(), EnumMsgType.PostSNSNewsTask, vo, req);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
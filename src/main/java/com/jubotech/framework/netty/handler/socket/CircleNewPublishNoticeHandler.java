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

import Jubo.JuLiao.IM.Wx.Proto.CircleNewPublishNotice.CircleNewPublishNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class CircleNewPublishNoticeHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AsyncTaskService asyncTaskService;
	/**
	 * 手机上发送了朋友圈通知
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	//log.info(JsonFormat.printer().print(vo.getContent()));
        	CircleNewPublishNoticeMessage req = vo.getContent().unpack(CircleNewPublishNoticeMessage.class);
        	log.debug(JsonFormat.printer().print(req));
			// 把消息转发给pc端
			asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.CircleNewPublishNotice, req);
			 
			// 告诉客户端消息已收到
			MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), Constant.ERROR_MSG_DECODFAIL);
        }
    }
	 
}
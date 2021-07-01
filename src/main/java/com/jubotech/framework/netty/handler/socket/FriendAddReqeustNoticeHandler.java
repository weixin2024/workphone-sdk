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

import Jubo.JuLiao.IM.Wx.Proto.FriendAddReqeustNotice.FriendAddReqeustNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;
@Service
public class FriendAddReqeustNoticeHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AsyncTaskService asyncTaskService;
	/**
	 * 个人号好友请求通知---手机端经过服务端转发给pc端
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	FriendAddReqeustNoticeMessage req = vo.getContent().unpack(FriendAddReqeustNoticeMessage.class);
        	log.debug(JsonFormat.printer().print(req));
			
			// 检查是否自动通过
			asyncTaskService.msgAopTaskFriendAdd(ctx, req,vo.getAccessToken(), vo.getId());
			// 把消息转发给pc端
			asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.FriendAddReqeustNotice, req);
			
			/*
			else{//如果pc端没在线，先帮忙自动通过了再说
				AcceptFriendAddRequestTaskMessage.Builder  bd = AcceptFriendAddRequestTaskMessage.newBuilder();
				bd.setWeChatId(req.getWeChatId());
				bd.setFriendId(req.getFriendId());
				bd.setFriendNick(req.getFriendNick());
				bd.setOperationValue(1);//默认接受请求
				AcceptFriendAddRequestTaskMessage resp = bd.build();
				MessageUtil.sendMsg(ctx, EnumMsgType.AcceptFriendAddRequestTask, vo.getAccessToken(), vo.getId(), resp);
			}	
			*/
			// 告诉客户端消息已收到
			MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
        } catch (Exception e) {
        	MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), Constant.ERROR_MSG_DECODFAIL);
            e.printStackTrace();
        }
    }
}
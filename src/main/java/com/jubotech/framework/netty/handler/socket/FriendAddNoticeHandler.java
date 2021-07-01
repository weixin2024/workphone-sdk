package com.jubotech.framework.netty.handler.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jubotech.framework.netty.async.AsyncTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.FriendAddNotice.FriendAddNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

 
@Service
public class FriendAddNoticeHandler{
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AsyncTaskService asyncTaskService;
 
	/**
	 * 个人号新增好友通知消息---手机端经过服务端转发给pc端
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	FriendAddNoticeMessage req = vo.getContent().unpack(FriendAddNoticeMessage.class);
        	 
    		//把消息转发给pc端
    		asyncTaskService.msgSend2pc(req.getWeChatId(), EnumMsgType.FriendAddNotice, req);
    		
    		//保存新增好友
    		asyncTaskService.saveFriendAddContactinfo(req);
    		
    		//告诉客户端消息已收到
    		MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
    		  
			 
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), Constant.ERROR_MSG_DECODFAIL);
        }
    }
     
}
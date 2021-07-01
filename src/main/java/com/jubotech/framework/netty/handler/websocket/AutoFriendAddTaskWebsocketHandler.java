package com.jubotech.framework.netty.handler.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.FriendAddTaskSetting;
import com.jubotech.business.web.service.FriendAddTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class AutoFriendAddTaskWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FriendAddTaskService  friendAddTaskService;
	 
	/** 
	 * 自动添加好友
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	FriendAddTaskSetting  req =  JSON.parseObject(contentJsonStr,FriendAddTaskSetting.class);
        	if(null != req){
        		String resp ="fail";
        		 
        		resp = friendAddTaskService.savePcTask(req);
        		 
        		//3、告诉PC客户端消息已收到
        		MessageUtil.sendCustomJsonMsg(ctx, "AutoFriendAddTaskResp", resp);
        		
        	} 
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
     
    
}
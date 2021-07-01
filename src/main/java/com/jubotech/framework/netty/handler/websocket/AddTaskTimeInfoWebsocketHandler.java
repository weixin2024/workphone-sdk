package com.jubotech.framework.netty.handler.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.TaskTimeService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class AddTaskTimeInfoWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	  
	@Autowired
	private AccountService  accountService;
	
	@Autowired
	private TaskTimeService  taskTimeService;
	 
	/** 
	 * 添加定时任务
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	TaskTimeInfo  req =  JSON.parseObject(contentJsonStr,TaskTimeInfo.class);
        	if(null != req){
        		Integer accountid = req.getAccountid();
        		String resp ="fail";
        		AccountInfo  info = accountService.findAccountInfoByid(accountid);
        		if(null != info){
        			req.setCid(info.getCid());
        			req.setDid(info.getDid());
        			resp = taskTimeService.savePcTask(req);
        		}
        		//3、告诉PC客户端消息已收到
        		MessageUtil.sendCustomJsonMsg(ctx, "AddTaskTimeInfoResp", resp);
        		
        	} 
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
     
    
}
package com.jubotech.framework.netty.handler.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.SysAutoSetting;
import com.jubotech.business.web.service.SysAutoSettingService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class AutoTaskUpdateWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	 	
	@Autowired
	private SysAutoSettingService  sysAutoSettingService;
	/** 
	 * 自动任务更新
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	SysAutoSetting  req =  JSON.parseObject(contentJsonStr,SysAutoSetting.class);
        	SysAutoSetting info= sysAutoSettingService.insert(req);
        	if(null != info){
        		String json = JSON.toJSONString(info);
        		MessageUtil.sendCustomJsonMsg(ctx, "AutoTaskUpdateResp", json);
        	}else{
        		MessageUtil.sendCustomJsonMsg(ctx, "AutoTaskUpdateResp", "fail");
        	}
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
    
}
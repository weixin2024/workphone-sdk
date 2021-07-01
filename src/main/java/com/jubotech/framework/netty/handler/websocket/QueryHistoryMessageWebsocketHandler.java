package com.jubotech.framework.netty.handler.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.WxMessageInfo;
import com.jubotech.business.web.domain.req.WeChatMessageVo;
import com.jubotech.business.web.service.WxMessageService;
import com.jubotech.framework.domain.base.PageBean;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class QueryHistoryMessageWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	 	 
	@Autowired
	private WxMessageService  weChatMessageService;
	/** 
	 * 获取微信好友对话历史消息
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	WeChatMessageVo  req =  JSON.parseObject(contentJsonStr,WeChatMessageVo.class);
        	if(null != req){
        		PageBean<WxMessageInfo> list = weChatMessageService.queryWeChatMessageInfo(req);
    			String json = null ;
    			if(null != list && null != list.getResultList() && list.getResultList().size()>0){
    			     json = JSON.toJSONString(list);
    			}
        		//3、告诉PC客户端消息已收到
    			MessageUtil.sendCustomJsonMsg(ctx, "QueryHistoryMessageResp", json);
        	}else{
    			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam,Constant.ERROR_MSG_PARAMERROR);
    		}
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
    
}
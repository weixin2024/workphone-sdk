package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.WxContactInfo;
import com.jubotech.business.web.service.WxContactService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetWechatFriendListWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxContactService weChatContactService;
	/** 
	 * 获取微信好友列表
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	WxContactInfo  req =  JSON.parseObject(contentJsonStr,WxContactInfo.class);
        	if(null != req){
    			List<WxContactInfo> list = weChatContactService.findContactinfoByWeChatId(req.getCid(), req.getWechatid());
    			String json = null ;
    			if(null != list && list.size()>0){
    			     json = JSON.toJSONString(list);
    			}
        		//3、告诉PC客户端消息已收到
    			MessageUtil.sendCustomJsonMsg(ctx, "GetWechatFriendListResp", json);
        	}else{
    			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam,Constant.ERROR_MSG_PARAMERROR);
    		}
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
    
}
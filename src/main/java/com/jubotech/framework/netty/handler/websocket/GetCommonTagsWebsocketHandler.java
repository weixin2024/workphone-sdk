package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.CommontagInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.CommontagService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetCommonTagsWebsocketHandler{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CommontagService  commontagService;
	 
	/** 
	 * 获取公共的标签
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx ,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	CommontagInfo  req =  JSON.parseObject(contentJsonStr,CommontagInfo.class);
        	if(null != req){
        		Integer id = (int) req.getId();
        		String name = req.getName();
				if (!StringUtils.isEmpty(name) && name.equals("pc")) {// 获取公共的标签
	        		AccountInfo  account = accountService.findAccountInfoByid(id);
	        		if(null != account){
	        			sendJson(ctx, commontagService, account.getCid(), account.getDid());
	        		}else{
	        			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam,Constant.ERROR_MSG_PARAMERROR);
	        		}
				} 	
        	} 
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
    private static void  sendJson(ChannelHandlerContext ctx,CommontagService  commontagService,Integer cid,Integer did){
    	List<CommontagInfo> list = commontagService.getAllCommontagInfoByCidDid(cid, did);
		String json = null ;
		if(null != list && list.size()>0){
		     json = JSON.toJSONString(list);
		}
		//3、告诉PC客户端消息已收到
		MessageUtil.sendCustomJsonMsg(ctx, "GetCommonTagsResp", json);
    }
    
    
}
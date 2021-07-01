package com.jubotech.framework.netty.handler.websocket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.service.WxAccountService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatLoginNotice.WeChatLoginNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatLoginNotice.WeChatLoginNoticeMessage.WeChatLoginMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatLoginNoticeResp.WeChatLoginNoticeRespMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class WeChatLoginNoticeWebsocketHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private WxAccountService weChatAccountService;
	 
	/** 
	 * pc客户端选择微信号登陆/登出通知
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx,TransportMessage vo, String contentJsonStr) {
        try {
        	log.debug(contentJsonStr);
        	WeChatLoginNoticeMessage.Builder bd = WeChatLoginNoticeMessage.newBuilder();
        	JsonFormat.parser().merge(contentJsonStr, bd);
    		WeChatLoginNoticeMessage req = bd.build();
    		List<String>  wechats = new ArrayList<String>();
        	//1、校验用户信息
        	if(null != req){
        		Integer id = (int) req.getUnionId();
        		
        		List<WxAccountInfo> list1 =  weChatAccountService.findWeChatAccountInfo(null, id);
        		if(null != list1 && list1.size()>0){
	        		for(int i=0;i<list1.size();i++){
	        			WxAccountInfo info = list1.get(i);
	        			if((null == info.getIslogined() || 0 == info.getIslogined()) && info.getAccountid() == id){
	        				info.setIslogined(1);//状态改成未登录
		        			//info.setAccountid(null);//账号置空
		        			weChatAccountService.updateLogined(info);
	        			}
	        		}	
        		}
        		
        		
        		List<WeChatLoginMessage> list =  req.getWeChatsList();
        		if(null != list && list.size()>0){
	        		for(int i=0;i<list.size();i++){
	        			WeChatLoginMessage info = list.get(i);
	        			Integer login = 1;
	        			if(info.getIsLogin()){
	        				wechats.add(info.getWeChatId());
	        				login = 0;
	        			}
	        			WxAccountInfo  wechat = weChatAccountService.findWeChatAccountInfoByWeChatId(info.getWeChatId());
	        			if(login == 0 && 1 == wechat.getIslogined()){
	        				wechat.setIslogined(login);
	        				wechat.setAccountid(id);
	        				weChatAccountService.updateLogined(wechat);
	        			}
	        		}	
        		}
        	} 
        	
        	//2、刷新缓存
			weChatAccountService.refreshCache();
        	
        	WeChatLoginNoticeRespMessage.Builder wrbuilder = WeChatLoginNoticeRespMessage.newBuilder();
        	wrbuilder.addAllWeChats(wechats);
        	WeChatLoginNoticeRespMessage resp = wrbuilder.build();
        	//3、告诉客户端消息已收到
    		MessageUtil.sendJsonMsg(ctx, EnumMsgType.WeChatLoginNoticeResp, vo.getAccessToken(), vo.getId(), resp);
         
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
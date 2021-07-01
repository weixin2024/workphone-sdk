package com.jubotech.framework.netty.handler.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jubotech.framework.config.EhcacheService;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;
@Service
public class HeartBeatReqWebsocketHandler{
	@Autowired
	private EhcacheService ehcacheService;
	 
	/**
	 * websocket 心跳接口
	 * @param ctx
	 * @param req
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx,TransportMessage vo, String contentJsonStr) {
    	if(!NettyConnectionUtil.getNettyId(ctx).equals(vo.getAccessToken())){
    		MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.NoRight, "token过期");
    		NettyConnectionUtil.exit(ctx);
    	}else{
	    	//只要发了心跳就清空缓存
    	    String  nettyId = NettyConnectionUtil.getNettyId(ctx);
			Cache  cache = ehcacheService.getCache();
			if(null != cache){
				cache.put(nettyId, 0);
			}
    		MessageUtil.sendJsonMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
    	}
    	
    }
}
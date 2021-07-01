package com.jubotech.framework.netty.handler.socket;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import com.googlecode.protobuf.format.JsonFormat;
import com.jubotech.framework.config.EhcacheService;
import com.jubotech.framework.netty.utils.MessageUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;
import com.jubotech.framework.util.DateUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;
@Service
public class HeartBeatReqHandler{
	Logger logger = LoggerFactory.getLogger(getClass());
  
	@Autowired
	private EhcacheService ehcacheService;
	/**
	 * 心跳接口---通用心跳接口
	 * @param ctx
	 * @param req
	 */
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage req) {
    	String  nettyId = NettyConnectionUtil.getNettyId(ctx);
    	if(!nettyId.equals(req.getAccessToken())){
    		logger.error(DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_2)+" 心跳发现token异常然后断开  ");
    		NettyConnectionUtil.exit(ctx);
    	}else{
    		logger.debug("心跳token : "+req.getAccessToken());
    		checkChannel(ctx,req);
    		
    		//只要发了心跳就清空缓存
    		Cache  cache = ehcacheService.getCache();
    		if(null != cache){
    			cache.put(nettyId, 0);
    		}
    		
    	}
    	//记录日志
		String json = JsonFormat.printToString(req);  
    	logger.info("心跳===="+json);  
    }
    
    private void checkChannel(ChannelHandlerContext ctx, TransportMessage req){
    	String  nettyId = NettyConnectionUtil.getNettyId(ctx);
    	String deviceid = NettyConnectionUtil.getDeviceidByNettyid(nettyId);
    	if(StringUtils.isBlank(deviceid)){
    		NettyConnectionUtil.exit(ctx);
    	}else{
    		System.out.println(deviceid);
        	ChannelHandlerContext  chx = NettyConnectionUtil.getNettyChannelByDeviceid(deviceid);
    		if(null == chx){
    			NettyConnectionUtil.exit(ctx);
        	}else{
        		MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, req.getAccessToken(), req.getId(), null);
        	}
    	}
    	
    }
}
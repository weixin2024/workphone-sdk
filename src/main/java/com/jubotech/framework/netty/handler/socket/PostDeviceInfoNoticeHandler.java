package com.jubotech.framework.netty.handler.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.PostDeviceInfoNotice.PostDeviceInfoNoticeMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumMsgType;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class PostDeviceInfoNoticeHandler{
	private  final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 手机端推送当前安装版本
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
    public  void handleMsg(ChannelHandlerContext ctx, TransportMessage vo) {
        try {
        	PostDeviceInfoNoticeMessage req = vo.getContent().unpack(PostDeviceInfoNoticeMessage.class);
        	log.debug(JsonFormat.printer().print(req));
			
        	/*
        	//写个伪代码判断一下
        	List<DeviceAppInfoMessage> devList = req.getAppInfosList();
        	if(null != devList && devList.size()>0){
        		for(int i=0;i<devList.size();i++){
        			DeviceAppInfoMessage dev = devList.get(i);
        			if(null != dev && dev.getPackageName().equals("com.jubo.customsystem")){
        				if(dev.getVerNumber()<3000){
        					UpgradeDeviceAppNoticeMessage.Builder bd = UpgradeDeviceAppNoticeMessage.newBuilder();
        					
        					DeviceAppUpgradeMessage.Builder devbd= DeviceAppUpgradeMessage.newBuilder();
        					devbd.setPackageName("com.jubo.customsystem");
        					devbd.setPackageUrl("http://12.11.22.44:8080/xxx.apk");
        					devbd.setVerNumber(3100);
        					devbd.setVersion("bata-3.100");
        					DeviceAppUpgradeMessage devmsg = devbd.build();
        					
        					bd.addAppInfos(devmsg);
        					UpgradeDeviceAppNoticeMessage resp = bd.build();
        					
        					MessageUtil.sendMsg(ctx, EnumMsgType.UpgradeDeviceAppNotice, vo.getAccessToken(), vo.getId(), resp);
        					break;
        				}
        				
        			}
        		}
        	}
        	*/
			
			// 告诉客户端消息已收到
			MessageUtil.sendMsg(ctx, EnumMsgType.MsgReceivedAck, vo.getAccessToken(), vo.getId(), null);
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtil.sendErrMsg(ctx, EnumErrorCode.InvalidParam,vo.getId(), Constant.ERROR_MSG_DECODFAIL);
        }
    }
}
package com.jubotech.framework.netty.handler;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

public interface JsonMessageHandler {
	void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr);
}

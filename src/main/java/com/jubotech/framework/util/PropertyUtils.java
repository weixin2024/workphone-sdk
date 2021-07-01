package com.jubotech.framework.util;

import org.springframework.core.env.Environment;

public class PropertyUtils {
	// 全局上传网络地址
	public static String getUploadUrl(Environment env) {
		return env.getProperty("com.jubotech.upload.url");
	}

	// 获取socket netty端口
	public static Integer getNettySocketPort(Environment env) {
		return Integer.valueOf(env.getProperty("com.jubotech.netty.socket.port"));
	}

	// 获取websocket netty端口
	public static Integer getNettyWebsocketPort(Environment env) {
		return Integer.valueOf(env.getProperty("com.jubotech.netty.websocket.port"));
	}
}

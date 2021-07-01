package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

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
public class AutoTaskDetailListWebsocketHandler {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SysAutoSettingService sysAutoSettingService;

	/**
	 * 获取自动任务详情列表
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.debug(contentJsonStr);
			SysAutoSetting req = JSON.parseObject(contentJsonStr, SysAutoSetting.class);
			if (null != req) {
				List<SysAutoSetting> info = sysAutoSettingService.getAllSysAutoSettingByCid(req.getCid());
				if (null != info && info.size()>0) {
					String json = JSON.toJSONString(info);
					MessageUtil.sendCustomJsonMsg(ctx, "AutoTaskDetailListResp", json);
				} else {
					MessageUtil.sendCustomJsonMsg(ctx, "AutoTaskDetailListResp", "{}");
				}
			} else {
				MessageUtil.sendCustomJsonMsg(ctx, "AutoTaskDetailListResp", "{}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

}
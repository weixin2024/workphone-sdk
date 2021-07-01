package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.business.web.service.TaskTimeService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.handler.JsonMessageHandler;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetTaskInfoListWebsocketHandler implements JsonMessageHandler{
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaskTimeService taskTimeService;

	/**
	 * 获取定时任务列表
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.info(contentJsonStr);
			TaskTimeInfo req = JSON.parseObject(contentJsonStr, TaskTimeInfo.class);
			if (null != req) {
				Integer accountid = req.getAccountid();
				List<TaskTimeInfo> list = null;
				if (null != accountid && accountid > 0) {
					list = taskTimeService.queryTaskTimeInfoByAccountId(req);
				}
				String json = null;
				if (null != list && list.size() > 0) {
					json = JSON.toJSONString(list);
				}
				MessageUtil.sendCustomJsonMsg(ctx, "GetTaskInfoListResp", json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

}
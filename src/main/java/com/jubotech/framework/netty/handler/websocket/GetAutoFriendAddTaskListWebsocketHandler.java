package com.jubotech.framework.netty.handler.websocket;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.FriendAddTask;
import com.jubotech.business.web.service.FriendAddTaskService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.handler.JsonMessageHandler;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetAutoFriendAddTaskListWebsocketHandler implements JsonMessageHandler{
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private FriendAddTaskService friendAddTaskService;

	/**
	 * 获取自动添加好友任务列表
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.info(contentJsonStr);
			FriendAddTask req = JSON.parseObject(contentJsonStr, FriendAddTask.class);
			if (null != req) {
				Integer accountid = req.getAccountid();
				List<FriendAddTask> list = null;
				if (null != accountid && accountid > 0) {
					list = friendAddTaskService.queryFriendAddTaskByAccountId(req);
				}
				String json = null;
				if (null != list && list.size() > 0) {
					json = JSON.toJSONString(list);
				}
				MessageUtil.sendCustomJsonMsg(ctx, "GetAutoFriendAddTaskListResp", json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

}
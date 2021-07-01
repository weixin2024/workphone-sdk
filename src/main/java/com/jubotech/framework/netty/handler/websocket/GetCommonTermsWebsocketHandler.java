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
import com.jubotech.business.web.domain.CommontermInfo;
import com.jubotech.business.web.service.AccountService;
import com.jubotech.business.web.service.CommontermService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetCommonTermsWebsocketHandler {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;

	@Autowired
	private CommontermService commontermService;
 
	/**
	 * 获取公共的术语
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	@Async
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.debug(contentJsonStr);
			CommontermInfo req = JSON.parseObject(contentJsonStr, CommontermInfo.class);
			// 1、校验用户信息
			if (null != req) {
				Integer id = (int) req.getId();
				String name = req.getName();
				if (!StringUtils.isEmpty(name) && name.equals("pc")) {// pc端获取公共术语
					AccountInfo account = accountService.findAccountInfoByid(id);
					if (null != account) {
						sendJson(ctx, commontermService, account.getCid(), account.getDid());
					} else {
						MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_PARAMERROR);
					}
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

	private static void sendJson(ChannelHandlerContext ctx, CommontermService commontermService, Integer cid,Integer did) {
		List<CommontermInfo> list = commontermService.getAllCommontermInfoByCidDid(cid, did);
		String json = null;
		if (null != list && list.size() > 0) {
			json = JSON.toJSONString(list);
		}
		// 3、告诉PC客户端消息已收到
		MessageUtil.sendCustomJsonMsg(ctx, "GetCommonTermsResp", json);
	}
}
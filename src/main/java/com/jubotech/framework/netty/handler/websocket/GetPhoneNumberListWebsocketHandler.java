package com.jubotech.framework.netty.handler.websocket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jubotech.business.web.domain.PhoneNumberInfo;
import com.jubotech.business.web.domain.req.PhoneNumberVo;
import com.jubotech.business.web.service.PhoneNumberService;
import com.jubotech.framework.netty.common.Constant;
import com.jubotech.framework.netty.handler.JsonMessageHandler;
import com.jubotech.framework.netty.utils.MessageUtil;

import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumErrorCode;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.TransportMessage;
import io.netty.channel.ChannelHandlerContext;

@Service
public class GetPhoneNumberListWebsocketHandler implements JsonMessageHandler{
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PhoneNumberService phoneNumberService;

	/**
	 * 获取电话号码列表
	 * 
	 * @author wechatno:tangjinjinwx
	 * @param ctx
	 * @param vo
	 */
	public void handleMsg(ChannelHandlerContext ctx, TransportMessage vo, String contentJsonStr) {
		try {
			log.info(contentJsonStr);
			PhoneNumberVo req = JSON.parseObject(contentJsonStr, PhoneNumberVo.class);
			if (null != req) {
				List<PhoneNumberInfo> list = phoneNumberService.queryPhoneNumberInfos(req);
				Integer totalSize = phoneNumberService.queryPhoneNumberInfosCount(req);
				
				//微信未绑定(添加失败的)
				req.setTask_result(1);
				req.setState(0);
				Integer addFailSize = phoneNumberService.queryPhoneNumberInfosCount(req);
				 
				req.setTask_result(-1);
				req.setState(1);
				Integer notUseSize = phoneNumberService.queryPhoneNumberInfosCount(req);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("list", list);
				map.put("totalSize", totalSize);
				map.put("addFailSize", addFailSize);
				map.put("notUseSize", notUseSize);
				
				String json = null;
				if (null != list && list.size() > 0) {
					json = JSON.toJSONString(map);
				}
				MessageUtil.sendCustomJsonMsg(ctx, "GetPhoneNumberListResp", json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.sendJsonErrMsg(ctx, EnumErrorCode.InvalidParam, Constant.ERROR_MSG_DECODFAIL);
		}
	}

}
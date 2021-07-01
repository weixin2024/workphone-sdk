package com.jubotech.framework.netty.common;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.jubotech.business.web.domain.WxAccountInfo;

public class Constant {
	public static final String ERROR_MSG_ILLEGALDEVICE = "非法设备";
	public static final String ERROR_MSG_DECODFAIL = "解码失败";
	public static final String ERROR_MSG_VERIFYWAY = "认证方式不支持";
	public static final String ERROR_MSG_LOGINFAIL = "账号密码错误";
	public static final String ERROR_MSG_NOTONLINE = "对方不在线";
	public static final String ERROR_MSG_PARAMERROR = "参数传入错误";
	public static final String ERROR_MSG_LOGINNORIGHT = "登陆账号无权限";
	public static final String ERROR_MSG_ELSEWHERELOGINN = "账号已在别处登陆";
	public static final String ERROR_MSG_DATABASENOTBIND = "数据库未绑定";
	
	//用于缓存在线的pc端
	public static List<WxAccountInfo> accountInfoList=null;

	public static String createErrorMsg(String weChatId, String errorMsg) {
		String msg = ERROR_MSG_NOTONLINE;
		if (!StringUtils.isEmpty(weChatId) && !StringUtils.isEmpty(errorMsg)) {
			JSONObject obj = new JSONObject();
			obj.put("weChatId", weChatId);
			obj.put("errorMsg", errorMsg);
			msg = obj.toJSONString();
		}
		return msg;
	}
	
	
}

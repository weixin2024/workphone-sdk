package com.jubotech.framework.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
	public static boolean isJson(String str) {
		try {
			JSONObject.parseObject(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

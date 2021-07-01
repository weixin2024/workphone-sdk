package com.jubotech.business.web.domain;

import java.io.Serializable;

public class WechatConfig implements  Serializable{
	private static final long serialVersionUID = 1L;
	private String wechatid;// 微信号
	private Integer add_count;//添加数量
	public String getWechatid() {
		return wechatid;
	}
	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}
	public Integer getAdd_count() {
		return add_count;
	}
	public void setAdd_count(Integer add_count) {
		this.add_count = add_count;
	}
	 

}

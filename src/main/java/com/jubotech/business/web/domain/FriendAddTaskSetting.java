package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.List;

public class FriendAddTaskSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer accountid;
	private String execute_time;//执行时间
	private Integer between_time;//间隔时间
	private Integer sayhellosize;//打招呼次数
	private List<String> phones;//电话号码集合
	private List<WechatConfig> config;//每个微信号加的数量
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public String getExecute_time() {
		return execute_time;
	}
	public void setExecute_time(String execute_time) {
		this.execute_time = execute_time;
	}
	public Integer getBetween_time() {
		return between_time;
	}
	public void setBetween_time(Integer between_time) {
		this.between_time = between_time;
	}
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<WechatConfig> getConfig() {
		return config;
	}
	public void setConfig(List<WechatConfig> config) {
		this.config = config;
	}
	public Integer getSayhellosize() {
		return sayhellosize;
	}
	public void setSayhellosize(Integer sayhellosize) {
		this.sayhellosize = sayhellosize;
	}
	
	 
}

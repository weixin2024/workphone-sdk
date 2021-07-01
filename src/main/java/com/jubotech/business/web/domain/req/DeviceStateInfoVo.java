package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

public class DeviceStateInfoVo extends Page {
	private Integer isonline;
	private Integer islogined;
	private String wechatid;
	private String deviceid;
	private Integer cid;
	private Integer did;
	private Integer accountid;

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

	public Integer getIsonline() {
		return isonline;
	}

	public void setIsonline(Integer isonline) {
		this.isonline = isonline;
	}

	public Integer getIslogined() {
		return islogined;
	}

	public void setIslogined(Integer islogined) {
		this.islogined = islogined;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

}

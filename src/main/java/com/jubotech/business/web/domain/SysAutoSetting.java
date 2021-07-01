package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class SysAutoSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cid;
	private Integer auto_type;
	private String wechatId;
	private Integer state;
	private Date create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getAuto_type() {
		return auto_type;
	}

	public void setAuto_type(Integer auto_type) {
		this.auto_type = auto_type;
	}
 
	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}

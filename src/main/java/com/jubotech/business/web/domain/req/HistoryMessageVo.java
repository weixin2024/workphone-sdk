package com.jubotech.business.web.domain.req;

import java.io.Serializable;

import com.jubotech.framework.domain.base.Page;

public class HistoryMessageVo extends Page implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid;// 所属客户id
	private String wechatId;
	private String startTime;
	 

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
 
}

package com.jubotech.business.web.domain.req;

import java.io.Serializable;

public class PhoneNumberVo implements Serializable {
	private static final long serialVersionUID = 1L;
	  
	private String wechatid;// 微信号
	private String phonenumber;// 电话号码
	private Integer state;
	private Integer task_result;
	private String begin_time;
	private String end_time;
	 
	// pc端定时传参///////////////////
	private Integer pageSize = 20;// 每页多少条
	private Integer pageNo = 1;// 当前第几页
	
	
	
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getWechatid() {
		return wechatid;
	}
	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Integer getTask_result() {
		return task_result;
	}
	public void setTask_result(Integer task_result) {
		this.task_result = task_result;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	 
}

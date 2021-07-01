package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class PhoneNumberInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer tid;
	private Integer state;
	private String wechatid;// 微信号
	private String phonenumber;// 内容
	private Integer task_result;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getTask_result() {
		return task_result;
	}
	public void setTask_result(Integer task_result) {
		this.task_result = task_result;
	}
  
}

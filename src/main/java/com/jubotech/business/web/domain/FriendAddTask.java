package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class FriendAddTask implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer accountid;
	private Integer cid;
	private Integer state;// 状态1开启中0已完成
	private String execute_time;// 执行时间
	private Integer between_time;//间隔时间
	private String wechatid;// 微信号
	private String message;// 内容
	private Date createTime;
	private Integer totalsize;
	private Integer doingsize;
	private Integer successsize;
	private Integer sayhellosize;//打招呼次数
	 
	// pc端定时传参///////////////////
	private Integer pageSize = 20;// 每页多少条
	private Integer pageNo = 1;// 当前第几页
	

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

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getExecute_time() {
		return execute_time;
	}

	public void setExecute_time(String execute_time) {
		this.execute_time = execute_time;
	}

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Integer getBetween_time() {
		return between_time;
	}

	public void setBetween_time(Integer between_time) {
		this.between_time = between_time;
	}

	public Integer getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(Integer totalsize) {
		this.totalsize = totalsize;
	}

	public Integer getDoingsize() {
		return doingsize;
	}

	public void setDoingsize(Integer doingsize) {
		this.doingsize = doingsize;
	}

	public Integer getSuccesssize() {
		return successsize;
	}

	public void setSuccesssize(Integer successsize) {
		this.successsize = successsize;
	}

	public Integer getSayhellosize() {
		return sayhellosize;
	}

	public void setSayhellosize(Integer sayhellosize) {
		this.sayhellosize = sayhellosize;
	}

}

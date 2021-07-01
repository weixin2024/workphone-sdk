package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class FriendAddTaskDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer tid;
	private Integer state;// 状态1开启中0已完成
	private String execute_time;
	private String json_content;// 内容
	private String wechatid;// 微信号
	private String phonenumber;
	private Date create_time;

	// pc端定时传参///////////////////
	private Integer pageSize = 20;// 每页多少条
	private Integer pageNo = 1;// 当前第几页

	public Integer getId() {
		return id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getJson_content() {
		return json_content;
	}

	public void setJson_content(String json_content) {
		this.json_content = json_content;
	}

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getExecute_time() {
		return execute_time;
	}

	public void setExecute_time(String execute_time) {
		this.execute_time = execute_time;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}

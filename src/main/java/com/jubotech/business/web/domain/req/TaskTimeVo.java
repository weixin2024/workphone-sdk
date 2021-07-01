package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

public class TaskTimeVo extends Page {
	private Integer accountid;
	private Integer cid;
	private Integer did;
	private Integer tasktype;// 任务类型1群发消息2发朋友圈
	private Integer state;// 状态1开启中0已完成

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

	public Integer getTasktype() {
		return tasktype;
	}

	public void setTasktype(Integer tasktype) {
		this.tasktype = tasktype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

}

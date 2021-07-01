package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

public class DepartmentVo extends Page {
	private Integer pid;
	private Integer cid;
	private String name;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

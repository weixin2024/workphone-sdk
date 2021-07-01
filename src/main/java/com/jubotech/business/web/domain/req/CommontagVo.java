package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

/**
 * 公共标签
 * 
 * @author lenovo
 *
 */
public class CommontagVo extends Page {
	private Integer cid;
	private Integer did;
	private String name;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}

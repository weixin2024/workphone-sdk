package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

/**
 * 公共术语
 * 
 * @author lenovo
 *
 */
public class CommontermVo extends Page {
	private Integer cid;
	private Integer did;
	private String name;
	private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}

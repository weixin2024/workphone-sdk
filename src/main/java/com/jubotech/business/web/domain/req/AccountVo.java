package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

public class AccountVo extends Page {

	private Integer type;
	private Integer cid;
	private Integer did;
	private String account;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

}

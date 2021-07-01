package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共标签分类
 * 
 * @author lenovo
 *
 */
public class CommontermType implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cid;
	private Integer did;
	private String name;
	private Date create_time;
	////////////////////////
	private String dname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}

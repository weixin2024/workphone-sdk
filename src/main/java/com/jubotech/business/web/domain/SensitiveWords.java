package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共标签
 * 
 * @author lenovo
 *
 */
public class SensitiveWords implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cid;
	private String words;
	private String tips;
	private Date create_time;

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

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}

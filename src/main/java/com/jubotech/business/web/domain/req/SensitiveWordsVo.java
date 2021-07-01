package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

/**
 * 敏感词
 * 
 * @author lenovo
 *
 */
public class SensitiveWordsVo extends Page {
	private Integer cid;
	private String words;

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

}

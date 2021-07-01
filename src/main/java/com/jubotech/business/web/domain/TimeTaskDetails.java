package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class TimeTaskDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer tid;
	private String execute_time;//子任务执行时间
	private Integer state;
	private String json_content;// json数据
	private String results;// 手机端返回内容存储为json
	private Date create_time;

	public Integer getId() {
		return id;
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

	public String getJson_content() {
		return json_content;
	}

	public void setJson_content(String json_content) {
		this.json_content = json_content;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getExecute_time() {
		return execute_time;
	}

	public void setExecute_time(String execute_time) {
		this.execute_time = execute_time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}

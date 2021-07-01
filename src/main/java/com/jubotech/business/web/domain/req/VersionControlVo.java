package com.jubotech.business.web.domain.req;

import java.io.Serializable;

import com.jubotech.framework.domain.base.Page;

public class VersionControlVo extends Page implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private Integer cid;
	private Integer flag;
	private String version;
	private Integer vernumber;
	private String packagename;
	
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getVernumber() {
		return vernumber;
	}
	public void setVernumber(Integer vernumber) {
		this.vernumber = vernumber;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	 
 
}

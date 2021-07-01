package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class VersionControl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cid;
	private String version;
	private Integer vernumber;
	private String packagename;
	private String packageurl;
	private Integer flag;
	private Date create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPackageurl() {
		return packageurl;
	}

	public void setPackageurl(String packageurl) {
		this.packageurl = packageurl;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
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

}

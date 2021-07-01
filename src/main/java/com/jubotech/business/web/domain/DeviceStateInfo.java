package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class DeviceStateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String wechatid;
	private String wechatno;
	private String wechatnick;
	private Integer isonline;
	private Integer islogined;
	private Integer cid;
	private String cname;
	private String deviceid;//设备id（一般为imei）
	private Integer accountid;// 所属操作员账号id，为空则未分配
	private String accountname;//操作员昵称
	private Date login_time;
	private Date create_time;
	//////////////整合参数////////////////////
	private Integer did; 
	private String  dname;//所属部门名称
	private String devnickname;// 设备名称
	private String brand;// 手机品牌
	private String module;// 手机型号
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

	public String getWechatno() {
		return wechatno;
	}

	public void setWechatno(String wechatno) {
		this.wechatno = wechatno;
	}

	public Integer getIsonline() {
		return isonline;
	}

	public void setIsonline(Integer isonline) {
		this.isonline = isonline;
	}

	public Integer getIslogined() {
		return islogined;
	}

	public void setIslogined(Integer islogined) {
		this.islogined = islogined;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getWechatnick() {
		return wechatnick;
	}

	public void setWechatnick(String wechatnick) {
		this.wechatnick = wechatnick;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDevnickname() {
		return devnickname;
	}

	public void setDevnickname(String devnickname) {
		this.devnickname = devnickname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}

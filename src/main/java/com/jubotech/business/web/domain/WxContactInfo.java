package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class WxContactInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//
	private Integer cid;// 所属客户id
	private String wechatid;
	private String friendid;
	private String friend_wechatno;
	private String nickname;
	private String remark;
	private Integer gender;
	private String avatar;
	private String country;
	private String province;
	private String city;
	private Integer type;//0通讯录 1群聊
	private Date modify_time;
	private Date create_time;

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

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	public String getFriend_wechatno() {
		return friend_wechatno;
	}

	public void setFriend_wechatno(String friend_wechatno) {
		this.friend_wechatno = friend_wechatno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
 
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}

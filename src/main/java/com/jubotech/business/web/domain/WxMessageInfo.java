package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class WxMessageInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;//
	private Integer cid;// 所属客户id
	private String wechatId;
	private String friendId;
	private String msgSvrId;
	private String isSend;
	private Integer contentType;
	private String content;
	private Integer type;//0个人1群聊
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

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getMsgSvrId() {
		return msgSvrId;
	}

	public void setMsgSvrId(String msgSvrId) {
		this.msgSvrId = msgSvrId;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	 
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}

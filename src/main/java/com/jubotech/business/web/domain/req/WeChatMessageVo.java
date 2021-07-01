package com.jubotech.business.web.domain.req;

import com.jubotech.framework.domain.base.Page;

public class WeChatMessageVo extends Page {

	private Integer cid;// 所属客户id
	private String wechatId;
	private String friendId;

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

}

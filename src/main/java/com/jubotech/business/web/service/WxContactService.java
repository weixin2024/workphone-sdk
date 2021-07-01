package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jubotech.business.web.dao.WxContactDao;
import com.jubotech.business.web.domain.WxContactInfo;

@Service
@Transactional // 支持事务
public class WxContactService {

	@Autowired
	private WxContactDao weChatContactDao;

	public WxContactInfo findContactinfoByid(Integer id) {
		return weChatContactDao.findContactinfoByid(id);
	}

	public WxContactInfo findContactinfoByfriendid(Integer cid, String wechatid, String friendid) {
		return weChatContactDao.findContactinfoByfriendid(cid, wechatid, friendid);
	}

	public List<WxContactInfo> findContactinfoByWeChatId(Integer cid, String wechatid) {
		return weChatContactDao.findContactinfoByWeChatId(cid, wechatid);
	}
	
	public WxContactInfo findContactinfoByWechatidFriendid(String wechatid, String friendid) {
		return weChatContactDao.findContactinfoByWechatidFriendid(wechatid, friendid);
	}
	 
	public void insert(WxContactInfo info) {
		weChatContactDao.insert(info);
	}

	public void update(WxContactInfo info) {
		weChatContactDao.update(info);
	}

	public void delete(Integer id) {
		WxContactInfo info = new WxContactInfo();
		info.setId(id);
		weChatContactDao.delete(info);
	}

}

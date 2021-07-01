package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.WxAccountDao;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.framework.netty.common.Constant;

@Service
@Transactional // 支持事务
public class WxAccountService {

	@Autowired
	private WxAccountDao weChatAccountDao;


	public WxAccountInfo getWeChatAccountByid(Integer id) {
		WxAccountInfo user = weChatAccountDao.findWeChatAccountInfoByid(id);
		return user;
	}
	public WxAccountInfo findWeChatAccountInfoByDeviceid(String deviceid) {
		WxAccountInfo user = weChatAccountDao.findWeChatAccountInfoByDeviceid(deviceid);
		return user;
	}
	
	public WxAccountInfo findWeChatAccountInfoByWeChatId(String weChatId) {
		WxAccountInfo user = weChatAccountDao.findWeChatAccountInfoByWeChatId(weChatId);
		return user;
	}
 
	public List<WxAccountInfo> findWeChatAccountInfo(Integer cid ,Integer accountid) {
		return weChatAccountDao.findWeChatAccountInfo(cid,accountid);
	}
	
	public List<WxAccountInfo> findAllWeChatAccountInfo(Integer isonline) {
		return weChatAccountDao.findAllWeChatAccountInfo(isonline);
	}
	
	public List<WxAccountInfo> findWeChatAccountInfoByWeChatIdNotEqualsDeviceid(String wechatid,String deviceid){
		return weChatAccountDao.findWeChatAccountInfoByWeChatIdNotEqualsDeviceid(wechatid, deviceid);
	}
	
	public void delete(Integer id) {
		weChatAccountDao.delete(id);
	}
	 
	public void update(WxAccountInfo user) {
		weChatAccountDao.update(user);
	}

	public void updateLogined(WxAccountInfo user) {
		weChatAccountDao.updateLogined(user);
	}
	
	public void updateOnline(WxAccountInfo user) {
		weChatAccountDao.updateOnline(user);
	}
	
	public void updateOnlineLogined(WxAccountInfo user) {
		weChatAccountDao.updateOnlineLogined(user);
	}
 
	/**
	 * 刷新缓存
	 */
	public List<WxAccountInfo> refreshCache(){
		List<WxAccountInfo> accList = weChatAccountDao.findAllIsLoginAccountWechatInfo();
		if(null != accList && accList.size()>0){
			Constant.accountInfoList = accList;
		}
		return accList;
	}

	  
}

package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.WxAccountInfo;

@Mapper
public interface WxAccountDao {
	WxAccountInfo findWeChatAccountInfoByid(@Param("id")Integer id);
	
	WxAccountInfo findWeChatAccountInfoByDeviceid(@Param("deviceid")String deviceid);
	
    List<WxAccountInfo> findWeChatAccountInfoByWeChatIdNotEqualsDeviceid(@Param("wechatid")String wechatid,@Param("deviceid")String deviceid);
    
    List<WxAccountInfo> findAllIsLoginAccountWechatInfo();
    
    List<WxAccountInfo> findAccountWechatInfoByCid(@Param("cid")Integer cid);
    
	void delete(@Param("id")Integer id);
	
	WxAccountInfo findWeChatAccountInfoByWeChatId(@Param("wechatid")String wechatid);
	
	List<WxAccountInfo> findWeChatAccountInfo(@Param("cid")Integer cid ,@Param("accountid")Integer accountid);
	
	List<WxAccountInfo> findAllWeChatAccountInfo(@Param("isonline")Integer isonline);
	
	void update(WxAccountInfo info);
	
	void updateLogined(WxAccountInfo info);
	
	void updateOnline(WxAccountInfo info);
	
	void updateOnlineLogined(WxAccountInfo info);
	
	void updateAccountidOffline(@Param("id")Integer id ,@Param("accountid")Integer accountid);
	   
}

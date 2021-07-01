package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.WxContactInfo;

@Mapper
public interface WxContactDao {
	
	WxContactInfo findContactinfoByid(@Param("id") Integer id);
	
	WxContactInfo findContactinfoByfriendid(@Param("cid") Integer cid,@Param("wechatid") String wechatid ,@Param("friendid") String friendid);

	WxContactInfo findContactinfoByWechatidFriendid(@Param("wechatid") String wechatid ,@Param("friendid") String friendid);
	
	List<WxContactInfo> findContactinfoByWeChatId(@Param("cid") Integer cid,@Param("wechatid") String wechatid);
	   
	void insert(WxContactInfo info);

	void update(WxContactInfo info);

	void delete(WxContactInfo info);
}

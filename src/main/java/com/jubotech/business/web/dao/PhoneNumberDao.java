package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.PhoneNumberInfo;
import com.jubotech.business.web.domain.req.PhoneNumberVo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface PhoneNumberDao {
	  
	List<PhoneNumberInfo> queryPhoneNumberInfos(@Param("page") DBPage page,@Param("info") PhoneNumberVo info);
	
	Integer queryPhoneNumberInfosCount(@Param("page") DBPage page,@Param("info") PhoneNumberVo info);
	
	List<PhoneNumberInfo> queryPhonesByWechatid(@Param("wechatid")String wechatid,@Param("count")Integer count);
	
	List<PhoneNumberInfo> queryPhoneNumberInfo(@Param("count")Integer count);
	
	PhoneNumberInfo queryPhoneNumberInfoByWechatidPhoneNumber(@Param("wechatid")String wechatid,@Param("phonenumber")String phonenumber);
	 
	Integer insert(PhoneNumberInfo info);
	
	void update(PhoneNumberInfo info);
	
}

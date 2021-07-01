package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.SysAutoSetting;

@Mapper
public interface SysAutoSettingDao {

	SysAutoSetting findSysAutoSettingByWeChatId(@Param("cid")Integer cid,@Param("auto_type")Integer auto_type,@Param("wechatId")String wechatId); 
 
	SysAutoSetting findSettingByWcIdAutoType(@Param("wechatId")String wechatId,@Param("auto_type")Integer auto_type);
	
	void insert(SysAutoSetting info);
	   
	void delete(SysAutoSetting info);
	 
	List<SysAutoSetting> getAllSysAutoSettingByCid(@Param("cid")Integer cid);
    
}

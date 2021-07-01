package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.DeviceStateInfo;
import com.jubotech.business.web.domain.req.DeviceStateInfoVo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface DeviceStateDao{
	
	List<DeviceStateInfo> queryDeviceStateInfo(@Param("page") DBPage page,@Param("info")DeviceStateInfoVo info);
	
	Integer queryDeviceStateInfoCount(@Param("page")DBPage page,@Param("info")DeviceStateInfoVo info);
	
	DeviceStateInfo findDeviceStateInfoByid(@Param("id")Integer id);
	
	Integer getPhoneAllCountByCid(@Param("cid")Integer cid);
	
	void insert(DeviceStateInfo info);
	
	void update(DeviceStateInfo info);
	
	void binding(@Param("id")Integer id,@Param("accountid")Integer accountid,@Param("did")Integer did);
 
	void updateLoginTime(@Param("deviceid")String deviceid);
}

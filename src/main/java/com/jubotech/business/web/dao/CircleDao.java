package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.CircleInfo;

@Mapper
public interface CircleDao {

	void insert(CircleInfo info);
	 
	void update(CircleInfo info);
	
	CircleInfo findCircleInfoByWeChatIdCircleId(@Param("wechatid")String wechatid ,@Param("circleid")String circleid);
	
	List<CircleInfo> queryCircleInfoByInserttime(@Param("dat")String dat);
	 
}

package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.CommontagInfo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface CommontagDao {
	
	List<CommontagInfo> queryCommontagInfo(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	Integer queryCommontagInfoCount(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	List<CommontagInfo> getAllCommontagInfoByDid(@Param("did")Integer did);
	
	List<CommontagInfo> getAllCommontagInfoByCid(@Param("cid")Integer cid);
	
	List<CommontagInfo> getAllCommontagInfoByCidDid(@Param("cid")Integer cid,@Param("did")Integer did);
	
	CommontagInfo findCommontagInfoByid(@Param("id")Integer id);
	  
	Integer insert(CommontagInfo info);
	
	void update(CommontagInfo info);
	
	void delete(CommontagInfo info);
  
}

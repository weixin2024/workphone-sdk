package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.DepartmentInfo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface DepartmentDao {
	
	List<DepartmentInfo> queryDepartmentInfo(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid);
	
	Integer queryDepartmentInfoCount(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid);
	
	List<DepartmentInfo> getAllDepartmentInfoByCid(@Param("cid")Integer cid);
	
	DepartmentInfo findDepartmentInfoByid(@Param("id")Integer id);
	  
	Integer insert(DepartmentInfo info);
	
	void update(DepartmentInfo info);
	
	void delete(DepartmentInfo info);
  
}

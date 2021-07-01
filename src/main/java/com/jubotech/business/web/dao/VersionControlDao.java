package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.VersionControl;
import com.jubotech.business.web.domain.req.VersionControlVo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface VersionControlDao {
    
    Integer queryVersionControlCount(@Param("info")VersionControlVo info);
	
	List<VersionControl> queryVersionControl(@Param("page")DBPage page,@Param("info")VersionControlVo info);
	
	VersionControl queryVersionControlById(@Param("id") Integer id);
	
	void update(VersionControl info);
	  
	void insert(VersionControl info);

	void delete(VersionControl info);
}

package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.CommontermType;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface CommontermTypeDao {
	
	List<CommontermType> queryCommontermType(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	Integer queryCommontermTypeCount(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	List<CommontermType> getAllCommontermTypeByCid(@Param("cid")Integer cid);
	
	CommontermType findCommontermTypeByid(@Param("id")Integer id);
	  
	Integer insert(CommontermType info);
	
	void update(CommontermType info);
	
	void delete(CommontermType info);
  
}

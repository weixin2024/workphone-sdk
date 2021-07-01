package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.CommontermInfo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface CommontermDao {
	
	List<CommontermInfo> queryCommontermInfo(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	Integer queryCommontermInfoCount(@Param("page") DBPage page,@Param("name")String name,@Param("cid")Integer cid,@Param("did")Integer did);
	
	List<CommontermInfo> getAllCommontermInfoByDid(@Param("did")Integer did);
	
	List<CommontermInfo> getAllCommontermInfoByCid(@Param("cid")Integer cid);
	
	List<CommontermInfo> getAllCommontermInfoByCidDid(@Param("cid")Integer cid,@Param("did")Integer did);
	
	CommontermInfo findCommontermInfoByid(@Param("id")Integer id);
	  
	Integer insert(CommontermInfo info);
	
	void update(CommontermInfo info);
	
	void delete(CommontermInfo info);
  
}

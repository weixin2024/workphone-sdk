package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface AccountDao {

	void insert(AccountInfo info);
	
    List<AccountInfo> queryAccountInfo(@Param("page") DBPage page,@Param("account")String account,@Param("type")Integer type,@Param("cid")Integer cid,@Param("did")Integer did);
	
	Integer queryAccountInfoCount(@Param("page") DBPage page,@Param("account")String account,@Param("type")Integer type,@Param("cid")Integer cid,@Param("did")Integer did);
	 
	AccountInfo findAccountInfoByid(@Param("id")Integer id); 
	
	AccountInfo findAccountInfoByWeChatId(@Param("wechatId")String wechatId); 
	
	AccountInfo findAccountInfoByAccount(@Param("account")String account);
	
	void update(AccountInfo info);
	
	void delete(AccountInfo info);
	
	AccountInfo findAccountInfo(@Param("account")String account,@Param("password")String password,@Param("type")Integer type);
	
	AccountInfo findAccountInfoByAccountPwd(@Param("account")String account,@Param("password")String password);
	
	void pwdedit(@Param("password")String password,@Param("id")Integer id);
	
	List<AccountInfo> getAllAccountInfoByCid(@Param("cid")Integer cid);
 
	List<AccountInfo> getAllAccountInfoByTypeCidDid(@Param("cid")Integer cid,@Param("did")Integer did);
	  
}

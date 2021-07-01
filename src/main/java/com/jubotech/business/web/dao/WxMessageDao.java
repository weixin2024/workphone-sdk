package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.WxMessageInfo;
import com.jubotech.business.web.domain.req.HistoryMessageVo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface WxMessageDao {
    List<WxMessageInfo> queryWeChatMessageInfo(@Param("page") DBPage page,@Param("cid") Integer cid,@Param("wechatid") String wechatid ,@Param("friendid") String friendid);
	
	Integer queryWeChatMessageInfoCount(@Param("page") DBPage page,@Param("cid") Integer cid,@Param("wechatid") String wechatid ,@Param("friendid") String friendid);
	
    Integer queryHistormMessageCount(HistoryMessageVo info);
	
	List<WxMessageInfo> queryHistormMessage(@Param("page")DBPage page,@Param("info")HistoryMessageVo info);
	
	WxMessageInfo queryWeChatMessageInfoByMsgServerId(@Param("wechatid") String wechatid ,@Param("friendid") String friendid,@Param("msgSvrId") String msgSvrId);
	
	void update(WxMessageInfo info);
	
	void updateContent(WxMessageInfo info);
	
	void insert(WxMessageInfo info);

	void delete(WxMessageInfo info);
}

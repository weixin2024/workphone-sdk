package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.WxMessageDao;
import com.jubotech.business.web.domain.WxMessageInfo;
import com.jubotech.business.web.domain.req.HistoryMessageVo;
import com.jubotech.business.web.domain.req.WeChatMessageVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class WxMessageService {

	@Autowired
	private WxMessageDao weChatMessageDao;

	public PageBean<WxMessageInfo> queryWeChatMessageInfo(WeChatMessageVo info) {
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());

		List<WxMessageInfo> resultList = weChatMessageDao.queryWeChatMessageInfo(page, info.getCid(),
				info.getWechatId(), info.getFriendId());
		Integer totalResult = weChatMessageDao.queryWeChatMessageInfoCount(page, info.getCid(), info.getWechatId(),
				info.getFriendId());
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize()
				: totalResult / info.getPageSize() + 1;

		PageBean<WxMessageInfo> pageBean = new PageBean<WxMessageInfo>(info.getPageSize(), info.getPageNo(),
				pageTotal, resultList);

		return pageBean;
	}

	public List<WxMessageInfo> queryHistormMessage(DBPage page,HistoryMessageVo info) {
		return weChatMessageDao.queryHistormMessage(page,info);
	}
	
	public Integer queryHistormMessageCount(HistoryMessageVo info) {
		return weChatMessageDao.queryHistormMessageCount(info);
	}
	
	public WxMessageInfo queryWeChatMessageInfoByMsgServerId(String wechatid, String friendid, String msgSvrId) {
		return weChatMessageDao.queryWeChatMessageInfoByMsgServerId(wechatid, friendid, msgSvrId);
	}
	
	public void update(WxMessageInfo info) {
		try {
			weChatMessageDao.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateContent(WxMessageInfo info) {
		try {
			weChatMessageDao.updateContent(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public void insert(WxMessageInfo info) {
		try {
			weChatMessageDao.insert(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		WxMessageInfo info = new WxMessageInfo();
		info.setId(id);
		weChatMessageDao.delete(info);
	}

}

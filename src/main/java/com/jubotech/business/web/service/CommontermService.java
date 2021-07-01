package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.CommontermDao;
import com.jubotech.business.web.domain.CommontermInfo;
import com.jubotech.business.web.domain.req.CommontermVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class CommontermService {

	@Autowired
	private CommontermDao commontermDao;

	public PageBean<CommontermInfo> queryCommontermInfo(CommontermVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<CommontermInfo> resultList = commontermDao.queryCommontermInfo(page,info.getName(),info.getCid(),info.getDid());
		Integer totalResult = commontermDao.queryCommontermInfoCount(page,info.getName(),info.getCid(),info.getDid());
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<CommontermInfo> pageBean = new PageBean<CommontermInfo>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}

 
	public List<CommontermInfo> getAllCommontermInfoByCid(Integer cid){
		List<CommontermInfo> list = commontermDao.getAllCommontermInfoByCid(cid);
		return list;
	}
	
	public List<CommontermInfo> getAllCommontermInfoByCidDid(Integer cid,Integer did){
		List<CommontermInfo> list = commontermDao.getAllCommontermInfoByCidDid(cid,did);
		return list;
	}
	
	
	public CommontermInfo getCommontermInfoByid(Integer id){
		CommontermInfo user = commontermDao.findCommontermInfoByid(id);
		return user;
	}
	
	public String insert(CommontermInfo info) {
		String res = "success";
		try {
			commontermDao.insert(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public String update(CommontermInfo info) {
		String res = "success";
		try {
			commontermDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public void delete(Integer id) {
		CommontermInfo info = new CommontermInfo();
		info.setId(id);
		commontermDao.delete(info);
	}
	 
	
}

package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.CommontermTypeDao;
import com.jubotech.business.web.domain.CommontermType;
import com.jubotech.business.web.domain.req.CommontermTypeVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class CommontermTypeService {

	@Autowired
	private CommontermTypeDao commontermTypeDao;

	public PageBean<CommontermType> queryCommontermType(CommontermTypeVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<CommontermType> resultList = commontermTypeDao.queryCommontermType(page,info.getName(),info.getCid(),info.getDid());
		Integer totalResult = commontermTypeDao.queryCommontermTypeCount(page,info.getName(),info.getCid(),info.getDid());
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<CommontermType> pageBean = new PageBean<CommontermType>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}

	public List<CommontermType> getAllCommontermTypeByCid(Integer cid){
		List<CommontermType> list = commontermTypeDao.getAllCommontermTypeByCid(cid);
		return list;
	}
 
	
	public CommontermType getCommontermTypeByid(Integer id){
		CommontermType user = commontermTypeDao.findCommontermTypeByid(id);
		return user;
	}
	
	public String insert(CommontermType info) {
		String res = "success";
		try {
			commontermTypeDao.insert(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public String update(CommontermType info) {
		String res = "success";
		try {
			commontermTypeDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public void delete(Integer id) {
		CommontermType info = new CommontermType();
		info.setId(id);
		commontermTypeDao.delete(info);
	}
	 
	
}

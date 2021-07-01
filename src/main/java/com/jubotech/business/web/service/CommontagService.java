package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.CommontagDao;
import com.jubotech.business.web.domain.CommontagInfo;
import com.jubotech.business.web.domain.req.CommontagVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class CommontagService {

	@Autowired
	private CommontagDao commontagDao;

	public PageBean<CommontagInfo> queryCommontagInfo(CommontagVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<CommontagInfo> resultList = commontagDao.queryCommontagInfo(page,info.getName(),info.getCid(),info.getDid());
		Integer totalResult = commontagDao.queryCommontagInfoCount(page,info.getName(),info.getCid(),info.getDid());
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<CommontagInfo> pageBean = new PageBean<CommontagInfo>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}

 
	public List<CommontagInfo> getAllCommontagInfoByCid(Integer cid){
		List<CommontagInfo> list = commontagDao.getAllCommontagInfoByCid(cid);
		return list;
	}
	
	public List<CommontagInfo> getAllCommontagInfoByCidDid(Integer cid,Integer did){
		List<CommontagInfo> list = commontagDao.getAllCommontagInfoByCidDid(cid,did);
		return list;
	}
	
	public CommontagInfo getCommontagInfoByid(Integer id){
		CommontagInfo user = commontagDao.findCommontagInfoByid(id);
		return user;
	}
	
	public String insert(CommontagInfo info) {
		String res = "success";
		try {
			commontagDao.insert(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public String update(CommontagInfo info) {
		String res = "success";
		try {
			commontagDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public void delete(Integer id) {
		CommontagInfo info = new CommontagInfo();
		info.setId(id);
		commontagDao.delete(info);
	}
	 
	
}

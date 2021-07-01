package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.DepartmentDao;
import com.jubotech.business.web.domain.DepartmentInfo;
import com.jubotech.business.web.domain.req.DepartmentVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	 

	public PageBean<DepartmentInfo> queryDepartmentInfo(DepartmentVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<DepartmentInfo> resultList = departmentDao.queryDepartmentInfo(page,info.getName(),info.getCid());
		Integer totalResult = departmentDao.queryDepartmentInfoCount(page,info.getName(),info.getCid());
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<DepartmentInfo> pageBean = new PageBean<DepartmentInfo>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}

 
	public List<DepartmentInfo> getAllDepartmentInfoByCid(Integer cid){
		List<DepartmentInfo> list = departmentDao.getAllDepartmentInfoByCid(cid);
		return list;
	}
	
	public DepartmentInfo getDepartmentInfoByid(Integer id){
		DepartmentInfo user = departmentDao.findDepartmentInfoByid(id);
		return user;
	}
	
	public String insert(DepartmentInfo info) {
		String res = "success";
		try {
			departmentDao.insert(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public String update(DepartmentInfo info) {
		String res = "success";
		try {
			departmentDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

	public void delete(Integer id) {
		DepartmentInfo info = new DepartmentInfo();
		info.setId(id);
		departmentDao.delete(info);
	}
	 
	
}

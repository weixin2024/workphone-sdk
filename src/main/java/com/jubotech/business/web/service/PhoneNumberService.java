package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.PhoneNumberDao;
import com.jubotech.business.web.domain.PhoneNumberInfo;
import com.jubotech.business.web.domain.req.PhoneNumberVo;
import com.jubotech.framework.domain.base.DBPage;

@Service
@Transactional // 支持事务
public class PhoneNumberService {
	 
	
	@Autowired
	private PhoneNumberDao phoneNumberDao;
 
 
	public List<PhoneNumberInfo> queryPhoneNumberInfos(PhoneNumberVo info){
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		return phoneNumberDao.queryPhoneNumberInfos(page,info);
	}
	
	public Integer queryPhoneNumberInfosCount(PhoneNumberVo info){
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		return phoneNumberDao.queryPhoneNumberInfosCount(page,info);
	}
	
  
}

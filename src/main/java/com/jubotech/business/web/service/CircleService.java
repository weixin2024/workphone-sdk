package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.CircleDao;
import com.jubotech.business.web.domain.CircleInfo;

@Service
@Transactional // 支持事务
public class CircleService {

	@Autowired
	private CircleDao circleDao;

	public List<CircleInfo> queryCircleInfoByInserttime(String date) {
		return circleDao.queryCircleInfoByInserttime(date);
	}
	
    public CircleInfo findCircleInfoByWeChatIdCircleId(String WeChatId ,String CircleId){
    	return circleDao.findCircleInfoByWeChatIdCircleId(WeChatId,CircleId);
    }

	public void insert(CircleInfo info) {
		try {
			circleDao.insert(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(CircleInfo info) {
		try {
			circleDao.update(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

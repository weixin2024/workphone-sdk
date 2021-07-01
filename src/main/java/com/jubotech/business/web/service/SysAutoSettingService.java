package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubotech.business.web.dao.SysAutoSettingDao;
import com.jubotech.business.web.domain.SysAutoSetting;

@Service
@Transactional // 支持事务
public class SysAutoSettingService {

	@Autowired
	private SysAutoSettingDao sysAutoSettingDao;

	public SysAutoSetting findSysAutoSettingByWeChatId(Integer cid, Integer auto_type, String wechatId) {
		return sysAutoSettingDao.findSysAutoSettingByWeChatId(cid, auto_type, wechatId);
	}

	public SysAutoSetting findSettingByWcIdAutoType(String wechatId, Integer auto_type) {
		return sysAutoSettingDao.findSettingByWcIdAutoType(wechatId, auto_type);
	}

	public SysAutoSetting insert(SysAutoSetting info) {
		try {
			SysAutoSetting sys = sysAutoSettingDao.findSysAutoSettingByWeChatId(info.getCid(), info.getAuto_type(),
					info.getWechatId());
			if (null == sys) {
				sysAutoSettingDao.insert(info);
			} else {
				sysAutoSettingDao.delete(sys);
				sysAutoSettingDao.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			info = null;
		}
		return info;
	}

	public void delete(SysAutoSetting info) {
		sysAutoSettingDao.delete(info);
	}

	public List<SysAutoSetting> getAllSysAutoSettingByCid(Integer cid) {
		return sysAutoSettingDao.getAllSysAutoSettingByCid(cid);
	}
}

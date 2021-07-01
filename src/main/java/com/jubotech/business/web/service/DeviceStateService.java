package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jubotech.business.web.dao.AccountDao;
import com.jubotech.business.web.dao.CustomerDao;
import com.jubotech.business.web.dao.DeviceStateDao;
import com.jubotech.business.web.dao.WxAccountDao;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.DeviceStateInfo;
import com.jubotech.business.web.domain.WxAccountInfo;
import com.jubotech.business.web.domain.req.DeviceStateInfoVo;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.domain.base.PageBean;

@Service
@Transactional // 支持事务
public class DeviceStateService {
  
	@Autowired
	private DeviceStateDao deviceStateDao;
	 
	@Autowired
	private CustomerDao customerDao;
	
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private WxAccountDao weChatAccountDao;
	
	 
	public PageBean<DeviceStateInfo> queryDeviceStateInfo(DeviceStateInfoVo info) {
		 
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		
		List<DeviceStateInfo> resultList = deviceStateDao.queryDeviceStateInfo(page,info);
		Integer totalResult = deviceStateDao.queryDeviceStateInfoCount(page,info);
		int pageTotal = totalResult % info.getPageSize() == 0 ? totalResult / info.getPageSize(): totalResult / info.getPageSize() + 1;

		PageBean<DeviceStateInfo> pageBean = new PageBean<DeviceStateInfo>(info.getPageSize(), info.getPageNo(), pageTotal, resultList);

		return pageBean;
	}
 
	
	public void delete(Integer id) {
		if(id != null ){
			weChatAccountDao.delete(id);
		}
	}
	
	
	public DeviceStateInfo findDeviceStateInfoByid(Integer id){
		return deviceStateDao.findDeviceStateInfoByid(id);
	}
	 
	public String insert(DeviceStateInfo info) {
		String res = "success";
		Integer count = customerDao.getCustomerPhoneCount(info.getCid());//该客户端的的设备数
		Integer pcount =  deviceStateDao.getPhoneAllCountByCid(info.getCid());//已经绑定的设备数
		if(pcount >= count){
			res = "over";
		}else{
			try {
				Integer accountid = info.getAccountid();
				AccountInfo account = accountDao.findAccountInfoByid(accountid);
				info.setDid(account.getDid());
				String deviceid = info.getDeviceid().trim();
				info.setDeviceid(deviceid);
				deviceStateDao.insert(info);
			} catch (Exception e) {
				res = "fail";
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public String update(DeviceStateInfo info) {
		String res = "success";
		try {
			Integer accountid = info.getAccountid();
			AccountInfo account = accountDao.findAccountInfoByid(accountid);
			info.setDid(account.getDid());
			String deviceid = info.getDeviceid().trim();
			info.setDeviceid(deviceid);
			deviceStateDao.update(info);
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}
		return res;
	}

 
	
	public boolean binding(Integer accountid,String ids){
		try {
			if(!StringUtils.isEmpty(accountid) && !StringUtils.isEmpty(ids)){
				AccountInfo account = accountDao.findAccountInfoByid(accountid);
				String []  s= ids.split(",");
				if(null != s && s.length>0){
					for(int i= 0;i<s.length;i++){
						Integer id = Integer.valueOf(s[i]);
						DeviceStateInfo  phone = deviceStateDao.findDeviceStateInfoByid(id);
						if(null != account && null != phone){
							bangding(phone,id, accountid, account.getDid());
						}
					}
				}else{
					Integer id = Integer.valueOf(ids);
					DeviceStateInfo  phone = deviceStateDao.findDeviceStateInfoByid(id);
					if(null != account && null != phone){
						bangding(phone,id, accountid, account.getDid());
					}
				}
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void bangding(DeviceStateInfo phone,Integer id,Integer accountid,Integer did){
		if(null != phone && null != did){
			//先绑定 操作员 及部门
			deviceStateDao.binding(id,accountid,did);
			//再查询设备状态，更新操作员id，保险起见 将该操作员踢下线
			if(null != phone.getDeviceid()){
				WxAccountInfo  account = weChatAccountDao.findWeChatAccountInfoByDeviceid(phone.getDeviceid());
				if(null != account && null != account.getId() && null != accountid){
					weChatAccountDao.updateAccountidOffline(account.getId(), accountid);
				}
			}
		}
	}
	
  
	
	public void updateLoginTime(String deviceid){
		deviceStateDao.updateLoginTime(deviceid);
	}
	
}

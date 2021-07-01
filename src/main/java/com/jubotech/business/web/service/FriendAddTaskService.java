package com.jubotech.business.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.dao.FriendAddTaskDao;
import com.jubotech.business.web.dao.FriendAddTaskDetailsDao;
import com.jubotech.business.web.dao.PhoneNumberDao;
import com.jubotech.business.web.domain.AccountInfo;
import com.jubotech.business.web.domain.FriendAddTask;
import com.jubotech.business.web.domain.FriendAddTaskDetails;
import com.jubotech.business.web.domain.FriendAddTaskSetting;
import com.jubotech.business.web.domain.PhoneNumberInfo;
import com.jubotech.business.web.domain.WechatConfig;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.util.DateUtil;

import Jubo.JuLiao.IM.Wx.Proto.AddFriendsTask.AddFriendsTaskMessage;

@Service
@Transactional // 支持事务
public class FriendAddTaskService {
	
	@Autowired
	private AccountService  accountService;
	
	@Autowired
	private FriendAddTaskDao friendAddTaskDao;
	
	@Autowired
	private FriendAddTaskDetailsDao  friendAddTaskDetailsDao;
	
	@Autowired
	private PhoneNumberDao phoneNumberDao;
 
 
	public List<FriendAddTask> queryFriendAddTaskByAccountId(FriendAddTask info){
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		return friendAddTaskDao.queryFriendAddTaskByAccountId(page,info.getAccountid(), info.getState());
	}
	

	public FriendAddTask findFriendAddTaskByid(Integer id) {
		return friendAddTaskDao.findFriendAddTaskByid(id);
	}
 

	public void delete(Integer id) {
		try {
			//先删除子任务
			friendAddTaskDetailsDao.deleteByTid(id);
			//再删除主任务
			FriendAddTask user = new FriendAddTask();
			user.setId(id);
			friendAddTaskDao.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(FriendAddTask info){
		friendAddTaskDao.update(info);
	}
	 
 
	public List<FriendAddTask> findFriendAddTaskByTime(String execute_time){
		return friendAddTaskDao.findFriendAddTaskByTime(execute_time);
	}
	
	public List<FriendAddTaskDetails> findTimeTaskDetailsByTid(Integer tid){
		return friendAddTaskDetailsDao.findFriendAddTaskDetailsByTid(tid);
	}
	
	public List<FriendAddTaskDetails> findFriendAddTaskDetailsByTime(String execute_time){
		return friendAddTaskDetailsDao.findFriendAddTaskDetailsByTime(execute_time);
	}
	
	
	 
	public void updateDetailState(FriendAddTaskDetails info){
		friendAddTaskDetailsDao.updateState(info);
	}
	
	private static void saveAddFriendTaskDetail(FriendAddTask info ,FriendAddTaskDetailsDao  friendAddTaskDetailsDao,String extcute_time,String phoneNumber){
			try {
				String wechatId = info.getWechatid();
				FriendAddTaskDetails detail = new FriendAddTaskDetails();
				detail.setTid(info.getId());
				detail.setExecute_time(extcute_time);
				detail.setWechatid(wechatId);
				detail.setState(1);
				detail.setPhonenumber(phoneNumber);
				friendAddTaskDetailsDao.insert(detail);
				 
				if(null != detail.getId()){
					//按微信号生成需要发的消息内容
					AddFriendsTaskMessage.Builder buider = AddFriendsTaskMessage.newBuilder();
					buider.addPhones(phoneNumber);
					buider.setTaskId(detail.getId());
					buider.setWeChatId(wechatId);
				 
					AddFriendsTaskMessage msg = buider.build();
					String json = null;
					if (null != msg) {
						try {
							json = JsonFormat.printer().print(msg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if(!StringUtils.isEmpty(json)){
						FriendAddTaskDetails tds =  new FriendAddTaskDetails();
						tds.setId(detail.getId());
						tds.setJson_content(json);
						friendAddTaskDetailsDao.updateJsonContent(tds);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	public synchronized void createTaskDetails(FriendAddTask info){
		 
		try {
			Integer betweenTime =  info.getBetween_time();
			String extcute_time = info.getExecute_time();
			Date extcuteTime = DateUtil.convertString2Date(extcute_time, DateUtil.DATE_FORMAT_4);
			Long longTime = extcuteTime.getTime();
			
			List<PhoneNumberInfo>  phones = phoneNumberDao.queryPhonesByWechatid(info.getWechatid(),info.getSayhellosize());
			if(null != phones && phones.size()>0){
				for(PhoneNumberInfo phone :phones){
					extcute_time = DateUtil.convertDate2String(new Date(longTime), DateUtil.DATE_FORMAT_4);
					saveAddFriendTaskDetail(info,friendAddTaskDetailsDao,extcute_time,phone.getPhonenumber());
					try {
						phone.setState(0);
						phoneNumberDao.update(phone);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//修改时间
					longTime = longTime+(betweenTime * 60 * 1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    
    /**
     * pc端添加定时任务
     * @param info
     * @return
     */
    public synchronized String savePcTask(FriendAddTaskSetting info) {
		String res = "success";
		try {
			
			FriendAddTask task = new FriendAddTask();
			task.setAccountid(info.getAccountid());
			task.setCreateTime(new Date());
			task.setMessage(info.getMessage());
			AccountInfo  account = accountService.findAccountInfoByid(info.getAccountid());
    		if(null != account){
    			task.setCid(account.getCid());
    		}
    		//把电话号码存起来
    		List<String>  phoneNumbers = info.getPhones();
    		if(null != phoneNumbers && phoneNumbers.size()>0){
    			for(String  number : phoneNumbers){
    				PhoneNumberInfo phones =  new PhoneNumberInfo();
    				phones.setCreateTime(new Date());
    				phones.setPhonenumber(number.trim());
    				phones.setState(1);
    				phones.setTask_result(-1);
    				try {
						phoneNumberDao.insert(phones);
					} catch (Exception e) {
						e.printStackTrace();
					}
    			}
    		}
    		
    		
			List<WechatConfig>  wechatList = info.getConfig();
			for(WechatConfig config :wechatList){
				Integer count = config.getAdd_count();
				if(count >0 ){
					task.setWechatid(config.getWechatid());
					//主任务存储数据库
					task.setState(1);//1开启中 0已完成
					task.setBetween_time(info.getBetween_time());
					task.setDoingsize(0);
					task.setTotalsize(count);
					task.setSuccesssize(0);
					task.setSayhellosize(info.getSayhellosize());
					task.setExecute_time(info.getExecute_time());
					friendAddTaskDao.insert(task);
					
					List<PhoneNumberInfo>  pNumbers = phoneNumberDao.queryPhoneNumberInfo(count);
					if(null != pNumbers && pNumbers.size()>0){
						for(PhoneNumberInfo pNumber:pNumbers){
							pNumber.setWechatid(config.getWechatid());
							pNumber.setTid(task.getId());
							phoneNumberDao.update(pNumber);
						}
					}
				}
				
			    
			}
			     
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}

		return res;
	}
    

}

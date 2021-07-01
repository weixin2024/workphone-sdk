package com.jubotech.business.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.JsonFormat;
import com.jubotech.business.web.dao.TaskTimeDao;
import com.jubotech.business.web.dao.TimeTaskDetailsDao;
import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.business.web.domain.TimeTaskDetails;
import com.jubotech.framework.domain.base.DBPage;
import com.jubotech.framework.netty.utils.MsgIdBuilder;
import com.jubotech.framework.util.StringUtil;
import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage.AttachmentMessage;
import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage.VisibleMessage;
import Jubo.JuLiao.IM.Wx.Proto.PostSNSNewsTask.PostSNSNewsTaskMessage.VisibleMessage.EnumVisibleType;
import Jubo.JuLiao.IM.Wx.Proto.TalkToFriendTask.TalkToFriendTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.TransportMessageOuterClass.EnumContentType;
import Jubo.JuLiao.IM.Wx.Proto.WeChatGroupSendTask.WeChatGroupSendTaskMessage;
import Jubo.JuLiao.IM.Wx.Proto.WeChatGroupSendTask.WeChatGroupSendTaskMessage.EnumGroupMsgContentType;

@Service
@Transactional // 支持事务
public class TaskTimeService {
	  
	@Autowired
	private TaskTimeDao taskTimeDao;
	
	@Autowired
	private TimeTaskDetailsDao  timeTaskDetailsDao;
 
 
	public List<TaskTimeInfo> queryTaskTimeInfoByAccountId(TaskTimeInfo info){
		DBPage page = new DBPage(info.getPageSize(), (info.getPageNo() - 1) * info.getPageSize());
		return taskTimeDao.queryTaskTimeInfoByAccountId(page,info.getAccountid(), info.getTasktype(), info.getState());
	}
	

	public TaskTimeInfo findTaskTimeInfoByid(Integer id) {
		return taskTimeDao.findTaskTimeInfoByid(id);
	}
 

	public void delete(Integer id) {
		try {
			//先删除子任务
			timeTaskDetailsDao.deleteByTid(id);
			//再删除主任务
			TaskTimeInfo user = new TaskTimeInfo();
			user.setId(id);
			taskTimeDao.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateState(TaskTimeInfo info) {
		taskTimeDao.updateState(info);
	}
	
	public List<TaskTimeInfo> findTaskTimeByTime(String execute_time){
		return taskTimeDao.findTaskTimeByTime(execute_time);
	}
	
	public List<TimeTaskDetails> findTimeTaskDetailsByTid(Integer tid){
		return timeTaskDetailsDao.findTimeTaskDetailsByTid(tid);
	}
	 
	
	private static void saveCircleSendTimeTaskDetail(TaskTimeInfo info ,TimeTaskDetailsDao  timeTaskDetailsDao){
		if(null != info.getId()){
			
			String wechatId = info.getWechatId();
			List<String> friendWechatList = StringUtil.stringToList(info.getWhoinvisible());
			
			List<String> newfriendWechatList =  null;
			if( null != friendWechatList && friendWechatList.size()>0){
				//friendWechatList去除重复
				newfriendWechatList = StringUtil.removeRepeat(friendWechatList);
			}
	    	
	    	TimeTaskDetails detail = new TimeTaskDetails();
	    	detail.setTid(info.getId());
	    	detail.setExecute_time(info.getExecute_time());
	    	timeTaskDetailsDao.insert(detail);
	    	
	    	if(null != detail.getId()){
	    		//设置附件
	    		AttachmentMessage.Builder attachment = AttachmentMessage.newBuilder();
	    		attachment.setTypeValue(info.getRestype());
	    		attachment.addAllContent(StringUtil.stringToList(info.getAttachtcontent()));
	    		//设置可见范围
	    		VisibleMessage.Builder  visible  = VisibleMessage.newBuilder();
	    		visible.setTypeValue(EnumVisibleType.WhoInvisible_VALUE);//不给谁看
	    		visible.setFriends(StringUtil.ListToString(newfriendWechatList));
	    		 
	    		//按微信号生成需要发的消息内容
	    		PostSNSNewsTaskMessage.Builder buider = PostSNSNewsTaskMessage.newBuilder();
				buider.setContent(info.getContent());
				buider.setAttachment(attachment);
				buider.setTaskId(detail.getId());
				buider.setWeChatId(wechatId);
				buider.setComment(info.getComment());
				buider.setVisible(visible);
				PostSNSNewsTaskMessage msg = buider.build();
				String json = null;
				if (null != msg) {
					try {
						json = JsonFormat.printer().print(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(!StringUtils.isEmpty(json)){
					TimeTaskDetails tds =  new TimeTaskDetails();
					tds.setId(detail.getId());
					tds.setJson_content(json);
					timeTaskDetailsDao.updateJsonContent(tds);
				}
	    	}
	    }
		
	}
	
	
	
	
	private static void saveGroupSendTimeTaskDetail(TaskTimeInfo info,TimeTaskDetailsDao  timeTaskDetailsDao){
		if(null != info.getId() ){
			List<String> wechatList = info.getWechatList();
			if(null == wechatList || wechatList.size()==0){
				return;
			}
			wechatList = StringUtil.removeRepeat(wechatList);//去除重复
			talkMsgToFriend(info, timeTaskDetailsDao, wechatList);
	    }
		
	}
	
	private static void saveGroupSendQunTaskDetail(TaskTimeInfo info,TimeTaskDetailsDao  timeTaskDetailsDao){
		if(null != info.getId()){
			List<String> friends = info.getWechatList();
			if(null != friends && friends.size()>0){
				talkMsgToFriend(info, timeTaskDetailsDao, friends);
			}
	    }
	}
	
	@SuppressWarnings("unused")
	private static void talkMsgToFriendByHelper(TaskTimeInfo info, TimeTaskDetailsDao timeTaskDetailsDao,List<String> friends) {
		WeChatGroupSendTaskMessage.Builder build = WeChatGroupSendTaskMessage.newBuilder();
		if(info.getRestype()==1){//文本类型
			build.setContentType(EnumGroupMsgContentType.Text);
		}else{//图片类型
			build.setContentType(EnumGroupMsgContentType.Picture);
		}
		build.setContent(info.getContent());
		build.setTaskId(MsgIdBuilder.getId());
		build.setWeChatId(info.getWechatId());
		build.addAllFriendIds(friends);
		WeChatGroupSendTaskMessage msg = build.build();
		if (null != msg) {
			try {
				String json  = JsonFormat.printer().print(msg);
				if(!StringUtils.isEmpty(json)){
					TimeTaskDetails detail = new TimeTaskDetails();
			    	detail.setTid(info.getId());
			    	detail.setExecute_time(info.getExecute_time());
			    	detail.setJson_content(json);
			    	timeTaskDetailsDao.insert(detail);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static void talkMsgToFriend(TaskTimeInfo info, TimeTaskDetailsDao timeTaskDetailsDao,List<String> friends) {
		for(String friend:friends){
			ByteString byteString = ByteString.copyFromUtf8(info.getContent());
			TalkToFriendTaskMessage.Builder  build=TalkToFriendTaskMessage.newBuilder();
			build.setWeChatId(info.getWechatId());
			build.setFriendId(friend);
			build.setContent(byteString);
			build.setMsgId(MsgIdBuilder.getId());
			if(info.getRestype()==1){//文本类型
				build.setContentType(EnumContentType.Text);
			}else if(info.getRestype()==2){//图片类型
				build.setContentType(EnumContentType.Picture);
			}else if(info.getRestype()==3){//语音类型
				build.setContentType(EnumContentType.Voice);
			}else if(info.getRestype()==4){//视频类型
				build.setContentType(EnumContentType.Video);
			}else if(info.getRestype()==6){//链接类型
				build.setContentType(EnumContentType.Link);
			}else if(info.getRestype()==13){//小程序
				build.setContentType(EnumContentType.WeApp);
			}
			TalkToFriendTaskMessage msg = build.build();
			if (null != msg) {
				try {
					String json  = JsonFormat.printer().print(msg);
					if(!StringUtils.isEmpty(json)){
						TimeTaskDetails detail = new TimeTaskDetails();
				    	detail.setTid(info.getId());
				    	detail.setExecute_time(info.getExecute_time());
				    	detail.setJson_content(json);
				    	timeTaskDetailsDao.insert(detail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

    
    /**
     * pc端添加定时任务
     * @param info
     * @return
     */
    public String savePcTask(TaskTimeInfo info) {
		String res = "success";
		try {
			 
			//主任务存储数据库
			info.setState(1);//1开启中 0已完成
		    taskTimeDao.insert(info);
		      
		    //子任务分别处理  存储子任务详情 
			if(info.getTasktype()==1){//添加群发任务
		       saveGroupSendTimeTaskDetail(info, timeTaskDetailsDao);
			}else if(info.getTasktype()==2){//发朋友圈
			   saveCircleSendTimeTaskDetail(info, timeTaskDetailsDao);
			}else if(info.getTasktype()==5){//群发群
				saveGroupSendQunTaskDetail(info, timeTaskDetailsDao);
			}
			     
		} catch (Exception e) {
			res = "fail";
			e.printStackTrace();
		}

		return res;
	}
    

}

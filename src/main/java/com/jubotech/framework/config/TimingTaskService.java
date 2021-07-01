package com.jubotech.framework.config;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jubotech.business.web.domain.FriendAddTask;
import com.jubotech.business.web.domain.FriendAddTaskDetails;
import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.business.web.domain.TimeTaskDetails;
import com.jubotech.business.web.service.FriendAddTaskService;
import com.jubotech.business.web.service.TaskTimeService;
import com.jubotech.business.web.service.TimeTaskDetailsService;
import com.jubotech.framework.netty.utils.JsonToProtoConverterUtil;
import com.jubotech.framework.netty.utils.NettyConnectionUtil;
import com.jubotech.framework.proxy.ProxyUtil;
import com.jubotech.framework.util.DateUtil;

import io.netty.channel.ChannelHandlerContext;

@Service
@EnableScheduling
@EnableAsync
public class TimingTaskService {
	private  final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EhcacheService ehcacheService;
 
	/**
	 * 每分钟去查询数据库，检查是否有新任务
	 */
	@Async
	@Scheduled(cron = "0 0/1 * * * ?")//测试
	public void executeTask() {
		try {
	        checkTask();
	        checkAddFriendTask();
	        checkTaskDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void checkTaskDetails(){//检查加好友子任务
		try {
			log.info(LocalDateTime.now()+" 定时任务检查加好友子任务  对应的线程名: "+Thread.currentThread().getName());
			FriendAddTaskService friendAddTaskService = ProxyUtil.getBean("friendAddTaskService", FriendAddTaskService.class);
			String execute_time = DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_4);
			long execute_long = DateUtil.convertString2Date(execute_time, DateUtil.DATE_FORMAT_4).getTime();
			List<FriendAddTaskDetails> tasks = 	friendAddTaskService.findFriendAddTaskDetailsByTime(execute_time);
			if(null != tasks && tasks.size()>0){
				for(int i=0;i<tasks.size();i++){
					FriendAddTaskDetails task =	tasks.get(i);
					if(null != task){
						long details_execute_long = DateUtil.convertString2Date(task.getExecute_time(), DateUtil.DATE_FORMAT_4).getTime();
						if(execute_long >= details_execute_long ){
							JsonToProtoConverterUtil.sendAddFriendsTaskMessage(task);
							task.setState(0);//修改子任务状态
							friendAddTaskService.updateDetailState(task);
						}
						
						//修改主任务
						FriendAddTask faddTask = friendAddTaskService.findFriendAddTaskByid(task.getTid());
						if(null != faddTask){
							Integer doingsize = faddTask.getDoingsize()+1;
							faddTask.setDoingsize(doingsize);
							if(doingsize >= faddTask.getTotalsize()){
								faddTask.setState(0);
							}
							friendAddTaskService.update(faddTask);
						}
					}
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public  void checkAddFriendTask(){//检查加好友任务
		try {
			log.info(LocalDateTime.now()+" 定时任务检查加好友  对应的线程名: "+Thread.currentThread().getName());
			FriendAddTaskService friendAddTaskService = ProxyUtil.getBean("friendAddTaskService", FriendAddTaskService.class);
			String execute_time = DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_4);
			long execute_long = DateUtil.convertString2Date(execute_time, DateUtil.DATE_FORMAT_4).getTime();
			List<FriendAddTask> tasks = 	friendAddTaskService.findFriendAddTaskByTime(execute_time);
			if(null != tasks && tasks.size()>0){
				//设置下次执行时间
				execute_long = execute_long + (60 * 60 * 24 * 1000 );
				execute_time = DateUtil.convertDate2String(new Date(execute_long), DateUtil.DATE_FORMAT_4);
				
				for(int i=0;i<tasks.size();i++){
					FriendAddTask task =	tasks.get(i);
					if(null != task){
						//创建子任务
						friendAddTaskService.createTaskDetails(task);
						//修改下次执行时间
						try {
							task.setExecute_time(execute_time);
							friendAddTaskService.update(task);
						} catch (Exception e) {
							e.printStackTrace();
						}finally {
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public  void checkTask(){
		try {
			log.info(LocalDateTime.now()+" 定时任务检查数据  对应的线程名: "+Thread.currentThread().getName());
			TaskTimeService taskTimeService = ProxyUtil.getBean("taskTimeService", TaskTimeService.class);
			TimeTaskDetailsService timeTaskDetailsService = ProxyUtil.getBean("timeTaskDetailsService", TimeTaskDetailsService.class);
			String execute_time = DateUtil.convertDate2String(new Date(), DateUtil.DATE_FORMAT_4);
			long execute_long = DateUtil.convertString2Date(execute_time, DateUtil.DATE_FORMAT_4).getTime();
			List<TaskTimeInfo> tasks = 	taskTimeService.findTaskTimeByTime(execute_time);
			if(null != tasks && tasks.size()>0){
				for(int i=0;i<tasks.size();i++){
					TaskTimeInfo task =	tasks.get(i);
					if(null != task){
						List<TimeTaskDetails> taskDetails = taskTimeService.findTimeTaskDetailsByTid(task.getId());
						if(null != taskDetails && taskDetails.size()>0){
							for(int j=0;j<taskDetails.size();j++){
								TimeTaskDetails details = taskDetails.get(j);
								long details_execute_long = DateUtil.convertString2Date(details.getExecute_time(), DateUtil.DATE_FORMAT_4).getTime();
								if(execute_long >= details_execute_long ){
									JsonToProtoConverterUtil.sendProtoMsg(task,taskDetails.get(j));
									details.setState(0);//修改子任务状态
									timeTaskDetailsService.updateState(details);
								}
							}
						}else{
							task.setState(0);//修改主任务状态
							taskTimeService.updateState(task);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 每30秒检查通道是否有效
	 */
	@Async
	@Scheduled(cron = "0/30 * * * * ?")//测试
	public void checkChannel() {
		try {
			 
	        log.info(LocalDateTime.now()+" 定时任务检查可用通道  对应的线程名: "+Thread.currentThread().getName());
			
			Map<String, ChannelHandlerContext> map = NettyConnectionUtil.userId_nettyChannel;
			if(null != map && map.size()>0){
				Cache  cache = ehcacheService.getCache();
				for (Map.Entry<String, ChannelHandlerContext> entry : map.entrySet()) {
		            try {
						ChannelHandlerContext ctx = entry.getValue();
						String key =  NettyConnectionUtil.getNettyId(ctx);
						if(null != cache){
							Integer value = 0;
							if(null != cache.get(key)){
								value= cache.get(key,Integer.class);
								if(value > 3){
									NettyConnectionUtil.exit(ctx);
									value = 0; 
								}else{
									value = value + 1;
								}
							}
							cache.put(key, value);
						}
					} catch (Throwable e) {
						e.printStackTrace();
					}
		        }
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}

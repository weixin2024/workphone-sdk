package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.TaskTimeInfo;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface TaskTimeDao {
	
	List<TaskTimeInfo> queryTaskTimeInfo(@Param("page") DBPage page,@Param("cid")Integer cid,@Param("did")Integer did,@Param("tasktype")Integer tasktype,@Param("state")Integer state);
	
	List<TaskTimeInfo> queryTaskTimeInfoByAccountId(@Param("page") DBPage page ,@Param("accountid")Integer accountid , @Param("tasktype")Integer tasktype,@Param("state")Integer state);
	 
	Integer queryTaskTimeInfoCount(@Param("page") DBPage page,@Param("cid")Integer cid,@Param("did")Integer did,@Param("tasktype")Integer tasktype,@Param("state")Integer state);
	 
	TaskTimeInfo findTaskTimeInfoByid(@Param("id")Integer id);
	 
	Integer insert(TaskTimeInfo info);
	
	void update(TaskTimeInfo info);
	
	void delete(TaskTimeInfo info);
	 
	void updateState(TaskTimeInfo info);
	
	List<TaskTimeInfo> findTaskTimeByTime(@Param("execute_time") String execute_time);
}

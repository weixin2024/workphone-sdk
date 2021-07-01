package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.FriendAddTask;
import com.jubotech.framework.domain.base.DBPage;

@Mapper
public interface FriendAddTaskDao {
	 
	List<FriendAddTask> queryFriendAddTaskByAccountId(@Param("page") DBPage page ,@Param("accountid")Integer accountid ,@Param("state")Integer state);
	 
	Integer queryFriendAddTaskByAccountIdCount(@Param("page") DBPage page,@Param("accountid")Integer accountid,@Param("state")Integer state);
	 
	FriendAddTask findFriendAddTaskByid(@Param("id")Integer id);
	 
	Integer insert(FriendAddTask info);
	
	void update(FriendAddTask info);
	
	void delete(FriendAddTask info);
	
	List<FriendAddTask> findFriendAddTaskByTime(@Param("execute_time") String execute_time);
}

package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.FriendAddTaskDetails;

@Mapper
public interface FriendAddTaskDetailsDao {

	FriendAddTaskDetails findFriendAddTaskDetailsByid(@Param("id") Integer id);

	Integer insert(FriendAddTaskDetails info);

	void deleteByTid(@Param("tid") Integer tid);
	
	void updateJsonContent(FriendAddTaskDetails info);
	 
	void updateState(FriendAddTaskDetails info);
	
	List<FriendAddTaskDetails> findFriendAddTaskDetailsByTid(@Param("tid") Integer tid);
	
	
	List<FriendAddTaskDetails> findFriendAddTaskDetailsByTime(@Param("execute_time") String execute_time);
	  
}

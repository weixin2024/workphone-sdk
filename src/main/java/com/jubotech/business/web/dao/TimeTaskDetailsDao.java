package com.jubotech.business.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jubotech.business.web.domain.TimeTaskDetails;

@Mapper
public interface TimeTaskDetailsDao {

	TimeTaskDetails findTimeTaskDetailsByid(@Param("id") Long id);

	Integer insert(TimeTaskDetails info);

	void deleteByTid(@Param("tid") Integer tid);
	
	void updateJsonContent(TimeTaskDetails info);
	
	void updateResults(TimeTaskDetails info);
	
	void updateState(TimeTaskDetails info);
	
	List<TimeTaskDetails> findTimeTaskDetailsByTid(@Param("tid") Integer tid);

}

package com.jiang.framework.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiang.framework.dao.BatchExcuteDAO;
import com.jiang.framework.dao.BatchExcuteLogDAO;
import com.jiang.framework.dao.interfaces.IInsertV2;
import com.jiang.framework.dao.interfaces.IUpdate;


@Service
public class BatchExcuteService  {
	
	@Resource
	public BatchExcuteDAO batchExcuteDAO;
	@Resource
	public BatchExcuteLogDAO batchExcuteLogDAO; 
	

	public void batchUpdate(Set<IUpdate> objectList) {
		batchExcuteDAO.batchExcute(objectList);
	}
	
	
	public void batchInsertLog(List<IInsertV2> insertList) {
		batchExcuteLogDAO.batchCreate(insertList);
	}
	
	
	public void batchInsert(List<IInsertV2> objectList) {
		batchExcuteDAO.batchCreateV2(objectList);
	}

}

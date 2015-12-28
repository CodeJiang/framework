package com.jiang.framework.service.impl;

import java.util.List;
import java.util.Set;

import com.jiang.framework.dao.BatchExcuteDAO;
import com.jiang.framework.dao.BatchExcuteLogDAO;
import com.jiang.framework.dao.interfaces.IUpdate;



public class BatchExcuteService  {

	public BatchExcuteDAO batchExcuteDAO = new BatchExcuteDAO();
	public BatchExcuteLogDAO batchExcuteLogDAO = new BatchExcuteLogDAO();
	

	public void batchUpdate(Set<IUpdate> objectList) {
		
	}

	public void batchDelete(Set<?> objcectList) {
		
	}
	
	
	public void batchInsertLog(List<?> objectList) {
		
	}
	
	
	public void batchInsert(List<?> objectList) {
		
	}

}

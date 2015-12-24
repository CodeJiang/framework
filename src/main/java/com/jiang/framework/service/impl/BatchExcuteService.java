package com.jiang.framework.service.impl;

import java.util.List;
import java.util.Set;



public class BatchExcuteService  {

	public BatchExcuteDAO batchExcuteDAO = new BatchExcuteDAO();
	public BatchExcuteLogDAO batchExcuteLogDAO = new BatchExcuteLogDAO();
	

	@Override
	public void batchUpdate(Set<IUpdate> objectList) {
		if (objectList != null && objectList.size() > 0) {
			batchExcuteDAO.batchUpdate(objectList);
		}
	}

	@Override
	public void batchDelete(Set<?> objcectList) {
		if (objcectList != null && objcectList.size() > 0) {
			batchExcuteDAO.batchExcute(objcectList, SimpleSqlSessionTemplate.EXCUTOR_DELETE);
		}
	}
	
	@Override
	public void batchInsertLog(List<?> objectList) {
		if(objectList != null && !objectList.isEmpty()) {
			batchExcuteLogDAO.batchCreate(objectList);
		}
	}
	
	@Override
	public void batchInsert(List<?> objectList) {
		if(objectList != null && !objectList.isEmpty()) {
			batchExcuteDAO.batchCreate(objectList);
		}
	}

}

package com.jiang.framework.dao;

import java.util.List;
import java.util.Set;

import com.jiang.framework.util.BaseGameDAO;
import com.jiang.framework.util.BaseLogDAO;

/**
 * @author barsk
 * 2013-11-7
 * 批量执行DAO
 */
public class BatchExcuteDAO extends BaseGameDAO {

	public void batchExcute(Set<?> paramObjectList, String executor) {
		super.batchExcute(paramObjectList, executor);
	}

	public void batchCreate(List<?> paramObjectList) {
		super.batchInsert(paramObjectList);
	}
	
}

package com.dao;

import java.util.List;

import com.db.LogSqlSessionTemplate;

/**
 * @author barsk
 * 2013-11-7
 * 批量执行日志DAO接口实现
 */
public class BatchExcuteLogDAO extends LogSqlSessionTemplate {

	public void batchCreate(List<?> paramObjectList) {
		super.batchInsert_log(paramObjectList);
	}

}

package com.jiang.framework.service;

public interface IBaseService {
	/**初始化基础数据表*/
	public void initBaseCache();
	/**初始化该模块需要的数据,有些数据 起服就加载的*/
	public void initCache();
	/**删除缓存*/
	public void deleteCache();
}

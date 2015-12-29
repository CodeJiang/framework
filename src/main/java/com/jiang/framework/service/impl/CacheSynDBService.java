package com.jiang.framework.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;





import org.springframework.stereotype.Service;

import com.jiang.framework.dao.interfaces.IInsertV2;
import com.jiang.framework.dao.interfaces.IUpdate;

@Service
public class CacheSynDBService {
	
	/** 定时更新缓存-5分钟 */
	private  Map<String, Set<IUpdate>> fiveMinuteUpdateOneCacheMap = new HashMap<String, Set<IUpdate>>();
	private  Map<String, Set<IUpdate>> fiveMinuteUpdateTwoCacheMap = new HashMap<String, Set<IUpdate>>();
	private  Map<String, Set<IUpdate>> fiveMinuteUpdateThreeCacheMap = new HashMap<String, Set<IUpdate>>();

	/** 定时插入缓存-10分钟*/
	private  Map<String, List<IInsertV2>> tenMinuteInsertOneCacheMap = new HashMap<String, List<IInsertV2>>();

	/** 定时写日志  注:日志库*/
	private  Map<String, List<IInsertV2>> tenSecondInsertCacheLogMap = new HashMap<String, List<IInsertV2>>();
	private  Map<String, List<IInsertV2>> fiveMinuteInsertCacheLogMap = new HashMap<String, List<IInsertV2>>();
	private  Map<String, List<IInsertV2>> tenMinuteInsertCacheLogMap = new HashMap<String, List<IInsertV2>>();
	private  Map<String, List<IInsertV2>> oneMinuteInsertCacheLogMap = new HashMap<String,List<IInsertV2>>();
	
	@Resource
	BatchExcuteService batchExcuteService;
	/**
	 * 缓存初始化
	 * */
	public static void initCacheMap() {
		initFiveMinuteOneCacheMap();
		initFiveMinuteTwoCacheMap();
		initFiveMinuteThreeCacheMap();
		
		
		initTenMinuteCacheMap();
		
		initTenSecondLogCacheMap();
		initFiveMinuteLogCacheMap();
		initTenMinuteLogCacheMap();
		initOneMinuteLogCacheMap();
	}

	
	private static void initOneMinuteLogCacheMap() {
		
	}

	/**
	 * 五分钟缓存初始化-更新
	 * */
	private static void initFiveMinuteOneCacheMap() {

	}

	/**
	 * 五分钟缓存初始化-更新
	 * */
	public static void initFiveMinuteTwoCacheMap() {
	}
	
	/**
	 * 五分钟缓存初始化-更新
	 * */
	public static void initFiveMinuteThreeCacheMap() {
		
	}

	/**
	 * 10分钟缓存初始化-新增
	 * */
	 public static void initTenMinuteCacheMap() {
		 
	 }

	 /**
	  * 日志五分钟缓存初始化-新增
	  * 注:日志库
	  */
	 private static void initFiveMinuteLogCacheMap() {
		 
	 }
	 
	 /**
	 * 日志10秒钟缓存初始化-新增
	 * 注:日志库
	 * */
	private static void initTenSecondLogCacheMap(){

	}
	 
	 /**
	  * 日志十分钟缓存初始化-新增
	  * 注:日志库
	  */
	 private static void initTenMinuteLogCacheMap() {}

	 /**
	  * 缓存五分钟缓存数据
	  * @param key
	  * @return
	  */
	 public  Set<IUpdate> getFromFiveUpdateOneCache(String key) {
		 return fiveMinuteUpdateOneCacheMap.get(key);
	 }

	 /**
	  * 缓存五分钟缓存数据
	  */
	 public  Set<IUpdate> getFromFiveUpdateTwoCache(String key) {
		 return fiveMinuteUpdateTwoCacheMap.get(key);
	 }
	 
	 /**
	  * 缓存五分钟缓存数据
	  */
	 public  Set<IUpdate> getFromFiveUpdateThreeCache(String key) {
		 return fiveMinuteUpdateThreeCacheMap.get(key);
	 }

	 /**
	  * 获得十分钟缓存数据
	  * @param key	
	  * @return
	  */
	 public  List<?> getFromTenMinuteOneCache(String key) {
		 return tenMinuteInsertOneCacheMap.get(key);
	 }

	 /**
	  * 获得10秒钟日志缓存数据
	  * 注:日志库
	  */
	 public  Object getFromTenSecondLogCache(String key) {
		 return tenSecondInsertCacheLogMap.get(key);
	 }
	 
	 public  Object getFromOneMinuteLogCache(String key){
		 return oneMinuteInsertCacheLogMap.get(key);
	 }
	 /**
	  * 获得五分钟日志缓存数据
	  * 注:日志库
	  */
	 public  Object getFromFiveMinuteLogCache(String key) {
		 return fiveMinuteInsertCacheLogMap.get(key);
	 }
	 
	 /**
	  * 获得十分钟日志缓存数据
	  * 注:日志库
	  */
	 public  Object getFromTenMinuteLogCache(String key) {
		 return tenMinuteInsertCacheLogMap.get(key);
	 }

	 /**
	  * 获得当前缓存中所有数据后并清空-更新
	  * @return 当前缓存中的所有数据
	  */
	 public  List<Set<IUpdate>> getAllAndClearCache_five_one_update() {
		 synchronized (fiveMinuteUpdateOneCacheMap) {

			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateOneCacheMap);

			 initFiveMinuteOneCacheMap();

			 return dataList;
		 }
	 }

	 /**
	  * 获得当前缓存中所有数据后并清空-更新
	  * @return 当前缓存中的所有数据
	  */
	 public  List<Set<IUpdate>> getAllAndClearCache_five_two_update() {

		 synchronized (fiveMinuteUpdateTwoCacheMap) {

			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateTwoCacheMap);

			 initFiveMinuteTwoCacheMap();

			 return dataList;
		 }
	 }
	 
	 /**
	  * 获得当前缓存中所有数据后并清空-更新
	  * @return 当前缓存中的所有数据
	  */
	 public  List<Set<IUpdate>> getAllAndClearCache_five_three_update() {
		 
		 synchronized (fiveMinuteUpdateThreeCacheMap) {
			 
			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateThreeCacheMap);
			 
			 initFiveMinuteThreeCacheMap();
			 
			 return dataList;
		 }
	 }

	 private  List<Set<IUpdate>> getAllUpdateCahce(Map<String, Set<IUpdate>> cacheMap) {

		 List<Set<IUpdate>> dataList = new ArrayList<Set<IUpdate>>();

		 for (Set<IUpdate> dataSet : cacheMap.values()) {
			 if (dataSet.size() > 0) {
				 dataList.add(dataSet);
			 }
		 }

		 return dataList;

	 }

	 /**
	  * 获得当前日志缓存中所有数据后并清空-新增(10秒钟)
	  * @return 当前缓存中的所有数据
	  */
	 public  List<List<IInsertV2>> getAllAndClearLogCache_ten_second_insert() {

		 synchronized (tenSecondInsertCacheLogMap) {

			 List<List<IInsertV2>> dataList = getAllInsetLogCache(tenSecondInsertCacheLogMap);

			 initTenSecondLogCacheMap();

			 return dataList;
		 }

	 }
	 
	 public  List<List<IInsertV2>> getAllAndClearLogCache_OneMinuteInsert(){
		 synchronized (oneMinuteInsertCacheLogMap) {
			 List<List<IInsertV2>> dataList = getAllInsetLogCache(oneMinuteInsertCacheLogMap);
			 
			 initOneMinuteLogCacheMap();
			 
			 return dataList;
		}
	 }
	 /**
	  * 获得当前日志缓存中所有数据后并清空-新增(五分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public  List<List<IInsertV2>> getAllAndClearLogCache_five_minute_insert() {

		 synchronized (fiveMinuteInsertCacheLogMap) {

			 List<List<IInsertV2>> dataList = getAllInsetLogCache(fiveMinuteInsertCacheLogMap);

			 initFiveMinuteLogCacheMap();

			 return dataList;
		 }

	 }
	 
	 /**
	  * 获得当前日志缓存中所有数据后并清空-新增(十分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public  List<List<IInsertV2>> getAllAndClearLogCache_ten_minute_insert() {
		 
		 synchronized (tenMinuteInsertCacheLogMap) {
			 
			 List<List<IInsertV2>> dataList = getAllInsetLogCache(tenMinuteInsertCacheLogMap);
			 
			 initTenMinuteLogCacheMap();
			 
			 return dataList;
		 }
		 
	 }

	 /**
	  * 获得当前缓存中所有数据后并清空-新增(十分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public  List<List<IInsertV2>> getAllAndClearCache_ten_one_insert() {

		 synchronized (tenMinuteInsertOneCacheMap) {

			 List<List<IInsertV2>> dataList = getAllInsetLogCache(tenMinuteInsertOneCacheMap);

			 initTenMinuteCacheMap();

			 return dataList;
		 }
	 }

	 private  List<List<IInsertV2>> getAllInsetLogCache(Map<String, List<IInsertV2>> cacheLogMap) {

		 List<List<IInsertV2>> dataList = new ArrayList<List<IInsertV2>>();

		 for (List<IInsertV2> value : cacheLogMap.values()) {
			 dataList.add(value);
		 }

		 return dataList;
	 }
	 public void synCache_beforeClose() {
		update_fiveOneData();
		update_fiveTwoData();
		update_fiveThreeData();
		insert_tenOneData();
		insert_tenSecondData_log();
		insert_FiveMinuteData_log();
		insert_OneMinuteData_Log();
	}
		
		
	public void update_fiveOneData() {
		synUpdateData(getAllAndClearCache_five_one_update());
	}
		
		
	public void update_fiveTwoData() {
		synUpdateData(getAllAndClearCache_five_two_update());
	}

	public void update_fiveThreeData() {
		synUpdateData(getAllAndClearCache_five_three_update());
	}
		
		
	public void insert_tenOneData() {
		
		List<List<IInsertV2>> dataList =  getAllAndClearCache_ten_one_insert();

		if (dataList.isEmpty()) {
			return;
		}

		for (List<IInsertV2> objectList : dataList) {
			batchExcuteService.batchInsert(objectList);
		}
	}

		
	public void insert_tenSecondData_log() {
		synInsertLogData(getAllAndClearLogCache_ten_second_insert());
	}
	
	
	public void insert_FiveMinuteData_log() {
		synInsertLogData(getAllAndClearLogCache_five_minute_insert());
	}
	
	
	public void insert_TenMinuteData_log() {
		synInsertLogData(getAllAndClearLogCache_ten_minute_insert());
	}
	
	private void synUpdateData(List<Set<IUpdate>> dataList) {
		if (dataList != null && dataList.isEmpty()) {
			return;
		}

		for (Set<IUpdate> objectList : dataList) {
			batchExcuteService.batchUpdate(objectList);
		}
	}
	
	private void synInsertLogData(List<List<IInsertV2>> dataList) {
		if (dataList.isEmpty()) {
			return;
		}


		for (List<IInsertV2> objectList : dataList) {
			batchExcuteService.batchInsertLog(objectList);
		}
	}

	
	public void insert_OneMinuteData_Log() {
		synInsertLogData(getAllAndClearLogCache_OneMinuteInsert());
		
	}
	 
	 
}

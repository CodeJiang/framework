package com.jiang.framework.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cache.CacheSynDBService;
import com.common.GameContext;
import com.jiang.framework.dao.interfaces.IUpdate;
import com.service.IBatchExcuteService;

@Service
public class CacheSynDBService {
	
	/** 定时更新缓存-5分钟 */
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateOneCacheMap = new HashMap<String, Set<IUpdate>>();
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateTwoCacheMap = new HashMap<String, Set<IUpdate>>();
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateThreeCacheMap = new HashMap<String, Set<IUpdate>>();

	/** 定时插入缓存-10分钟*/
	private static Map<String, List<?>> tenMinuteInsertOneCacheMap = new HashMap<String, List<?>>();

	/** 定时写日志  注:日志库*/
	private static Map<String, List<?>> tenSecondInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> fiveMinuteInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> tenMinuteInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> oneMinuteInsertCacheLogMap = new HashMap<String,List<?>>();

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
	 public static Set<IUpdate> getFromFiveUpdateOneCache(String key) {
		 return fiveMinuteUpdateOneCacheMap.get(key);
	 }

	 /**
	  * 缓存五分钟缓存数据
	  */
	 public static Set<IUpdate> getFromFiveUpdateTwoCache(String key) {
		 return fiveMinuteUpdateTwoCacheMap.get(key);
	 }
	 
	 /**
	  * 缓存五分钟缓存数据
	  */
	 public static Set<IUpdate> getFromFiveUpdateThreeCache(String key) {
		 return fiveMinuteUpdateThreeCacheMap.get(key);
	 }

	 /**
	  * 获得十分钟缓存数据
	  * @param key	
	  * @return
	  */
	 public static List<?> getFromTenMinuteOneCache(String key) {
		 return tenMinuteInsertOneCacheMap.get(key);
	 }

	 /**
	  * 获得10秒钟日志缓存数据
	  * 注:日志库
	  */
	 public static Object getFromTenSecondLogCache(String key) {
		 return tenSecondInsertCacheLogMap.get(key);
	 }
	 
	 public static Object getFromOneMinuteLogCache(String key){
		 return oneMinuteInsertCacheLogMap.get(key);
	 }
	 /**
	  * 获得五分钟日志缓存数据
	  * 注:日志库
	  */
	 public static Object getFromFiveMinuteLogCache(String key) {
		 return fiveMinuteInsertCacheLogMap.get(key);
	 }
	 
	 /**
	  * 获得十分钟日志缓存数据
	  * 注:日志库
	  */
	 public static Object getFromTenMinuteLogCache(String key) {
		 return tenMinuteInsertCacheLogMap.get(key);
	 }

	 /**
	  * 获得当前缓存中所有数据后并清空-更新
	  * @return 当前缓存中的所有数据
	  */
	 public static List<Set<IUpdate>> getAllAndClearCache_five_one_update() {
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
	 public static List<Set<IUpdate>> getAllAndClearCache_five_two_update() {

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
	 public static List<Set<IUpdate>> getAllAndClearCache_five_three_update() {
		 
		 synchronized (fiveMinuteUpdateThreeCacheMap) {
			 
			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateThreeCacheMap);
			 
			 initFiveMinuteThreeCacheMap();
			 
			 return dataList;
		 }
	 }

	 private static List<Set<IUpdate>> getAllUpdateCahce(Map<String, Set<IUpdate>> cacheMap) {

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
	 public static List<List<?>> getAllAndClearLogCache_ten_second_insert() {

		 synchronized (tenSecondInsertCacheLogMap) {

			 List<List<?>> dataList = getAllInsetLogCache(tenSecondInsertCacheLogMap);

			 initTenSecondLogCacheMap();

			 return dataList;
		 }

	 }
	 
	 public static List<List<?>> getAllAndClearLogCache_OneMinuteInsert(){
		 synchronized (oneMinuteInsertCacheLogMap) {
			 List<List<?>> dataList = getAllInsetLogCache(oneMinuteInsertCacheLogMap);
			 
			 initOneMinuteLogCacheMap();
			 
			 return dataList;
		}
	 }
	 /**
	  * 获得当前日志缓存中所有数据后并清空-新增(五分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public static List<List<?>> getAllAndClearLogCache_five_minute_insert() {

		 synchronized (fiveMinuteInsertCacheLogMap) {

			 List<List<?>> dataList = getAllInsetLogCache(fiveMinuteInsertCacheLogMap);

			 initFiveMinuteLogCacheMap();

			 return dataList;
		 }

	 }
	 
	 /**
	  * 获得当前日志缓存中所有数据后并清空-新增(十分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public static List<List<?>> getAllAndClearLogCache_ten_minute_insert() {
		 
		 synchronized (tenMinuteInsertCacheLogMap) {
			 
			 List<List<?>> dataList = getAllInsetLogCache(tenMinuteInsertCacheLogMap);
			 
			 initTenMinuteLogCacheMap();
			 
			 return dataList;
		 }
		 
	 }

	 /**
	  * 获得当前缓存中所有数据后并清空-新增(十分钟)
	  * @return 当前缓存中的所有数据
	  */
	 public static List<List<?>> getAllAndClearCache_ten_one_insert() {

		 synchronized (tenMinuteInsertOneCacheMap) {

			 List<List<?>> dataList = getAllInsetLogCache(tenMinuteInsertOneCacheMap);

			 initTenMinuteCacheMap();

			 return dataList;
		 }
	 }

	 private static List<List<?>> getAllInsetLogCache(Map<String, List<?>> cacheLogMap) {

		 List<List<?>> dataList = new ArrayList<List<?>>();

		 for (List<?> value : cacheLogMap.values()) {
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
			synUpdateData(CacheSynDBService.getAllAndClearCache_five_one_update());
		}
		
		
		public void update_fiveTwoData() {
			synUpdateData(CacheSynDBService.getAllAndClearCache_five_two_update());
		}

		public void update_fiveThreeData() {
			synUpdateData(CacheSynDBService.getAllAndClearCache_five_three_update());
		}
		
		
		public void insert_tenOneData() {
			
			List<List<?>> dataList =  CacheSynDBService.getAllAndClearCache_ten_one_insert();

			if (dataList.isEmpty()) {
				return;
			}

			IBatchExcuteService batchExcuteService = GameContext.getInstance().getServiceCollection().getBatchExcuteService();

			for (List<?> objectList : dataList) {
				batchExcuteService.batchInsert(objectList);
			}
		}

		@Override
		public void insert_tenSecondData_log() {
			synInsertLogData(CacheSynDBService.getAllAndClearLogCache_ten_second_insert());
		}
		
		@Override
		public void insert_FiveMinuteData_log() {
			synInsertLogData(CacheSynDBService.getAllAndClearLogCache_five_minute_insert());
		}
		
		@Override
		public void insert_TenMinuteData_log() {
			synInsertLogData(CacheSynDBService.getAllAndClearLogCache_ten_minute_insert());
		}
		
		private void synUpdateData(List<Set<IUpdate>> dataList) {
			if (dataList != null && dataList.isEmpty()) {
				return;
			}

			IBatchExcuteService batchExcuteService = GameContext.getInstance().getServiceCollection().getBatchExcuteService();
			for (Set<IUpdate> objectList : dataList) {
				batchExcuteService.batchUpdate(objectList);
			}
		}
		
		private void synInsertLogData(List<List<?>> dataList) {
			if (dataList.isEmpty()) {
				return;
			}

			IBatchExcuteService batchExcuteService = GameContext.getInstance().getServiceCollection().getBatchExcuteService();

			for (List<?> objectList : dataList) {
				batchExcuteService.batchInsertLog(objectList);
			}
		}

		@Override
		public void insert_OneMinuteData_Log() {
			synInsertLogData(CacheSynDBService.getAllAndClearLogCache_OneMinuteInsert());
			
		}
	 
	 
}

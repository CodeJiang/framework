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
	
	/** ��ʱ���»���-5���� */
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateOneCacheMap = new HashMap<String, Set<IUpdate>>();
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateTwoCacheMap = new HashMap<String, Set<IUpdate>>();
	private static Map<String, Set<IUpdate>> fiveMinuteUpdateThreeCacheMap = new HashMap<String, Set<IUpdate>>();

	/** ��ʱ���뻺��-10����*/
	private static Map<String, List<?>> tenMinuteInsertOneCacheMap = new HashMap<String, List<?>>();

	/** ��ʱд��־  ע:��־��*/
	private static Map<String, List<?>> tenSecondInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> fiveMinuteInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> tenMinuteInsertCacheLogMap = new HashMap<String, List<?>>();
	private static Map<String, List<?>> oneMinuteInsertCacheLogMap = new HashMap<String,List<?>>();

	/**
	 * �����ʼ��
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
	 * ����ӻ����ʼ��-����
	 * */
	private static void initFiveMinuteOneCacheMap() {

	}

	/**
	 * ����ӻ����ʼ��-����
	 * */
	public static void initFiveMinuteTwoCacheMap() {
	}
	
	/**
	 * ����ӻ����ʼ��-����
	 * */
	public static void initFiveMinuteThreeCacheMap() {
		
	}

	/**
	 * 10���ӻ����ʼ��-����
	 * */
	 public static void initTenMinuteCacheMap() {
		 
	 }

	 /**
	  * ��־����ӻ����ʼ��-����
	  * ע:��־��
	  */
	 private static void initFiveMinuteLogCacheMap() {
		 
	 }
	 
	 /**
	 * ��־10���ӻ����ʼ��-����
	 * ע:��־��
	 * */
	private static void initTenSecondLogCacheMap(){

	}
	 
	 /**
	  * ��־ʮ���ӻ����ʼ��-����
	  * ע:��־��
	  */
	 private static void initTenMinuteLogCacheMap() {}

	 /**
	  * ��������ӻ�������
	  * @param key
	  * @return
	  */
	 public static Set<IUpdate> getFromFiveUpdateOneCache(String key) {
		 return fiveMinuteUpdateOneCacheMap.get(key);
	 }

	 /**
	  * ��������ӻ�������
	  */
	 public static Set<IUpdate> getFromFiveUpdateTwoCache(String key) {
		 return fiveMinuteUpdateTwoCacheMap.get(key);
	 }
	 
	 /**
	  * ��������ӻ�������
	  */
	 public static Set<IUpdate> getFromFiveUpdateThreeCache(String key) {
		 return fiveMinuteUpdateThreeCacheMap.get(key);
	 }

	 /**
	  * ���ʮ���ӻ�������
	  * @param key	
	  * @return
	  */
	 public static List<?> getFromTenMinuteOneCache(String key) {
		 return tenMinuteInsertOneCacheMap.get(key);
	 }

	 /**
	  * ���10������־��������
	  * ע:��־��
	  */
	 public static Object getFromTenSecondLogCache(String key) {
		 return tenSecondInsertCacheLogMap.get(key);
	 }
	 
	 public static Object getFromOneMinuteLogCache(String key){
		 return oneMinuteInsertCacheLogMap.get(key);
	 }
	 /**
	  * ����������־��������
	  * ע:��־��
	  */
	 public static Object getFromFiveMinuteLogCache(String key) {
		 return fiveMinuteInsertCacheLogMap.get(key);
	 }
	 
	 /**
	  * ���ʮ������־��������
	  * ע:��־��
	  */
	 public static Object getFromTenMinuteLogCache(String key) {
		 return tenMinuteInsertCacheLogMap.get(key);
	 }

	 /**
	  * ��õ�ǰ�������������ݺ����-����
	  * @return ��ǰ�����е���������
	  */
	 public static List<Set<IUpdate>> getAllAndClearCache_five_one_update() {
		 synchronized (fiveMinuteUpdateOneCacheMap) {

			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateOneCacheMap);

			 initFiveMinuteOneCacheMap();

			 return dataList;
		 }
	 }

	 /**
	  * ��õ�ǰ�������������ݺ����-����
	  * @return ��ǰ�����е���������
	  */
	 public static List<Set<IUpdate>> getAllAndClearCache_five_two_update() {

		 synchronized (fiveMinuteUpdateTwoCacheMap) {

			 List<Set<IUpdate>> dataList = getAllUpdateCahce(fiveMinuteUpdateTwoCacheMap);

			 initFiveMinuteTwoCacheMap();

			 return dataList;
		 }
	 }
	 
	 /**
	  * ��õ�ǰ�������������ݺ����-����
	  * @return ��ǰ�����е���������
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
	  * ��õ�ǰ��־�������������ݺ����-����(10����)
	  * @return ��ǰ�����е���������
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
	  * ��õ�ǰ��־�������������ݺ����-����(�����)
	  * @return ��ǰ�����е���������
	  */
	 public static List<List<?>> getAllAndClearLogCache_five_minute_insert() {

		 synchronized (fiveMinuteInsertCacheLogMap) {

			 List<List<?>> dataList = getAllInsetLogCache(fiveMinuteInsertCacheLogMap);

			 initFiveMinuteLogCacheMap();

			 return dataList;
		 }

	 }
	 
	 /**
	  * ��õ�ǰ��־�������������ݺ����-����(ʮ����)
	  * @return ��ǰ�����е���������
	  */
	 public static List<List<?>> getAllAndClearLogCache_ten_minute_insert() {
		 
		 synchronized (tenMinuteInsertCacheLogMap) {
			 
			 List<List<?>> dataList = getAllInsetLogCache(tenMinuteInsertCacheLogMap);
			 
			 initTenMinuteLogCacheMap();
			 
			 return dataList;
		 }
		 
	 }

	 /**
	  * ��õ�ǰ�������������ݺ����-����(ʮ����)
	  * @return ��ǰ�����е���������
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

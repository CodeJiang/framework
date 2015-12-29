package com.jiang.framework.util;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiang.framework.service.IBaseService;

public class SpringUtil {
	private static ApplicationContext context = null;
	public static void init(){
		context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		Map<String,IBaseService> map = context.getBeansOfType(IBaseService.class);
		for(Entry<String, IBaseService> entry : map.entrySet()){
			entry.getValue().initBaseCache();
			entry.getValue().initCache();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObject(String name, Class<T> clazz){
		return (T) context.getBean(name);
	}
	
	public static <T> T getObject(Class<T> clazz){
		return context.getBean(clazz);
	}
}

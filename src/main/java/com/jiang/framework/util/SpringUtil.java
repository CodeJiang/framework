package com.jiang.framework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext context = null;
	public static void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObject(String name, Class<T> clazz){
		return (T) context.getBean(name);
	}
	
	public static <T> T getObject(Class<T> clazz){
		return context.getBean(clazz);
	}
}

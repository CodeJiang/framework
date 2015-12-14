package com.jiang.framework.util;

import java.lang.reflect.Field;


public  class ClassUtil {
	
	public static <T> String toString(T t){
		StringBuilder sb = new StringBuilder();
		try{
			
			Field[] fields = t.getClass().getDeclaredFields();
			
			boolean flag = false;
			for(Field field : fields){
				if(flag){
					sb.append(",");
				}
				sb.append(field.getName());
				sb.append("=");
				field.setAccessible(true);
				sb.append(field.get(t));
				
				flag = true;
			}
		}catch(Exception e){
			LogUtil.error("toString error==>"+t.getClass(),e);
		}
		
		return sb.toString();
	}
}

package com.jiang.framework.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class LogUtil {
	private LogUtil(){
		
	}
	
	public static void debug(String message){
		if(isDebug()){
			getDebugLogger().debug(message);
		}
	}
	
	public static void debug(String message, Throwable throwable){
		if(isDebug()){
			getDebugLogger().debug(message, throwable);
		}
	}
	
	public static void debug(Throwable throwable){
		if(isDebug()){
			getDebugLogger().debug(throwable.getMessage(), throwable);
		}
	}
	
	public static void info(String message){
		if(isInfo()){
			getInfoLogger().info(message);
		}
	}
	
	public static void info(String message, Throwable throwable){
		if(isInfo()){
			getInfoLogger().info(message, throwable);
		}
	}
	
	public static void info(Throwable throwable){
		if(isInfo()){
			getInfoLogger().info(throwable.getMessage(), throwable);
		}
	}
	
	public static void warn(String message){
		if(isWarn()){
			getWarnLogger().warn(message);
		}
	}
	
	public static void warn(String message, Throwable throwable){
		if(isWarn()){
			getWarnLogger().warn(message, throwable);
		}
	}
	
	public static void warn(Throwable throwable){
		if(isWarn()){
			getWarnLogger().warn(throwable.getMessage(), throwable);
		}
	}
	
	public static void error(String message){
		if(isError()){
			getErrorLogger().error(message);
		}
	}
	
	public static void error(String message, Throwable throwable){
		if(isError()){
			getErrorLogger().error(message, throwable);
		}
	}
	
	public static void error(Throwable throwable){
		if(isError()){
			getErrorLogger().error(throwable.getMessage(), throwable);
		}
	}
	
	public static void fatal(String message){
		if(isFatal()){
			getFatalLogger().fatal(message);
		}
	}
	
	public static void fatal(String message, Throwable throwable){
		if(isFatal()){
			getFatalLogger().fatal(message, throwable);
		}
	}
	
	public static void fatal(Throwable throwable){
		if(isFatal()){
			getFatalLogger().fatal(throwable.getMessage(), throwable);
		}
	}
	
	private static Logger getDebugLogger(){
		return LogManager.getLogger("debugLogger");
	}	
	
	private static Logger getInfoLogger(){
		return LogManager.getLogger("infoLogger");
	}
	
	private static Logger getWarnLogger(){
		return LogManager.getLogger("warnLogger");
	}
	
	private static Logger getErrorLogger(){
		return LogManager.getLogger("errorLogger");
	}
	
	private static Logger getFatalLogger(){
		return LogManager.getLogger("fatalLogger");
	}
	
	private static Boolean isDebug(){
		return LogManager.getRootLogger().getLevel().intLevel() >= Level.DEBUG.intLevel();
	}
	
	private static Boolean isInfo(){
		return LogManager.getRootLogger().getLevel().intLevel() >= Level.INFO.intLevel(); 
	}
	
	private static Boolean isWarn(){
		return LogManager.getRootLogger().getLevel().intLevel() >= Level.WARN.intLevel(); 
	}
	
	private static Boolean isError(){
		return LogManager.getRootLogger().getLevel().intLevel() >= Level.ERROR.intLevel(); 
	}
	
	private static Boolean isFatal(){
		return LogManager.getRootLogger().getLevel().intLevel() >= Level.FATAL.intLevel(); 
	}
}

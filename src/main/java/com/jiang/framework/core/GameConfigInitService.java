package com.jiang.framework.core;

public class GameConfigInitService {
	
	private GameConfigInitService(){
		
	}
	private static GameConfigInitService configService = new GameConfigInitService();
	
	public  static  GameConfigInitService getInstance(){
		return configService;
	}
	
	public void init(){
		
	}
}

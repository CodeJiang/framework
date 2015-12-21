package com.jiang.framework.core;

import com.jiang.framework.util.SpringUtil;

public class StartServer {
	public static void main(String args[]) throws InterruptedException{
		start();
	}
	
	
	public static void start() throws InterruptedException{
		//��ʼ��spring
		SpringUtil.init();
		
		//socket�����������
		GameSocketServer gameSocketServer = SpringUtil.getObject(GameSocketServer.class);		
		gameSocketServer.start();
		
	}
	
	public static void stop(){
		GameSocketServer gameSocketServer = SpringUtil.getObject(GameSocketServer.class);
		gameSocketServer.stop();
	}
}

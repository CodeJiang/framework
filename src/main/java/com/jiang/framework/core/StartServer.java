package com.jiang.framework.core;

import com.jiang.framework.service.PlayerService;
import com.jiang.framework.util.LogUtil;
import com.jiang.framework.util.SpringUtil;

public class StartServer {
	public static void main(String args[]){
		//��ʼ��spring
		SpringUtil.init();
		PlayerService playerService = SpringUtil.getObject("playerService", PlayerService.class);
		playerService.createPlayer("test","test1");
		System.out.println("over");
		
		LogUtil.error("error");
		LogUtil.info("info");
		LogUtil.warn("warn");
		
	}
}

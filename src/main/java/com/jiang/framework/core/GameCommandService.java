package com.jiang.framework.core;

import java.util.HashMap;
import java.util.Map;

import com.jiang.framework.common.GameException;
import com.jiang.framework.socket.GameMessage;
import com.jiang.framework.util.LogUtil;

public class GameCommandService {
	static Map<Integer, GameCommand> commandMap = new HashMap<Integer, GameCommand>();
	static{
		
	}
	
	
	public static void executeCommand(GameMessage gameMessage){
		GameCommand command = commandMap.get(gameMessage.getMsgID());
		if(command != null){
			try{
				command.execute(gameMessage);
			}catch(GameException ge){
				command.executFail(ge);
			}catch(Exception e){
				LogUtil.error("ִ��ָ���쳣");
			}
			
		}
	}
}
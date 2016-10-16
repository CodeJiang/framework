package com.jiang.framework.core;

import java.util.HashMap;
import java.util.Map;

import com.jiang.framework.common.GameException;
import com.jiang.framework.message.MessageProto.Message.MessageID;
import com.jiang.framework.socket.GameMessage;
import com.jiang.framework.util.LogUtil;
import com.jiang.framework.util.SpringUtil;

/**
 * //只是在分支上面加点东西 命令
 * @author Codej
 *
 */
public class GameCommandService {
	static Map<Integer, GameCommand> commandMap = new HashMap<Integer, GameCommand>(200);
	public static void init(){
		commandMap.put(MessageID.C_USER_LOGIN_VALUE, SpringUtil.getObject("userLoginCmd", GameCommand.class));
	}
	
	
	public static void executeCommand(GameMessage gameMessage){
		GameCommand command = commandMap.get(gameMessage.getMsgID());
		if(command != null){
			try{
				command.execute(gameMessage);
			}catch(GameException ge){
				command.executFail(ge);
			}catch(Exception e){
				LogUtil.error("未知异常",e);
			}
			
		}
	}
}

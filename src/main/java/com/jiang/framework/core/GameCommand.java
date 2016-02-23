package com.jiang.framework.core;

import com.jiang.framework.common.GameException;
import com.jiang.framework.socket.GameMessage;

public abstract class GameCommand {
	public abstract void execute(GameMessage gameMessage) throws Exception;
	
	public void executFail(GameException exception){
		System.out.println("game exception id===>"+exception.getErrorID());
	}
}

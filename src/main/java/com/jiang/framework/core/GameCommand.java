package com.jiang.framework.core;

import com.jiang.framework.common.GameException;
import com.jiang.framework.socket.GameMessage;

public abstract class GameCommand {
	public abstract void execute(GameMessage gameMessage);
	
	public void executFail(GameException exception){
		System.out.println("game exception id===>"+exception.getErrorID());
	}
}

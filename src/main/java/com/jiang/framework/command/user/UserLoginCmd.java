package com.jiang.framework.command.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jiang.framework.action.UserAction;
import com.jiang.framework.core.GameCommand;
import com.jiang.framework.socket.GameMessage;

@Component(value="userLoginCmd")
public class UserLoginCmd extends GameCommand {
	@Resource
	UserAction userAction;
	@Override
	public void execute(GameMessage gameMessage) throws Exception  {
		userAction.login(gameMessage);
	}

}

package com.jiang.framework.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.google.protobuf.InvalidProtocolBufferException;
import com.jiang.framework.message.UserProto.C_USER_LOGIN;
import com.jiang.framework.message.UserProto.S_USER_LOGIN;
import com.jiang.framework.service.impl.GameSocketService;
import com.jiang.framework.socket.GameMessage;
import com.jiang.framework.socket.MessageObj;

@Component
public class UserAction {
	@Resource
	GameSocketService gameSocketService;
	public void login(GameMessage gameMessage) throws InvalidProtocolBufferException{
		C_USER_LOGIN cParam = C_USER_LOGIN.parseFrom(gameMessage.getData());
		
		S_USER_LOGIN.Builder sBuilder = S_USER_LOGIN.newBuilder();
		byte[] bytes = sBuilder.build().toByteArray();
		
		MessageObj msgObj = new MessageObj(com.jiang.framework.message.MessageProto.Message.MessageID.S_USER_LOGIN_VALUE, sBuilder.build().toByteArray());
		
		gameSocketService.sendData(gameMessage.getConnection(), msgObj);
	
	}
}

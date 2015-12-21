package com.jiang.framework.service.impl;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelId;

import org.springframework.stereotype.Service;

import com.jiang.framework.core.GameSocketServer;
import com.jiang.framework.socket.Connection;
import com.jiang.framework.socket.MessageObj;

@Service
public class GameSocketService {
	private Map<Integer, Connection> playerIDConnection = null;
	private Map<ChannelId, Connection> channelIDConnection = null;
	
	@PostConstruct
	public void init(){
		/**Íæ¼ÒIDºÍConnectionµÄÓ³Éä*/
		playerIDConnection = new ConcurrentHashMap<Integer, Connection>(1000);
		channelIDConnection = new ConcurrentHashMap<ChannelId, Connection>(1000);
	}
	
	public Connection getConnection(int playerID){
		return this.getPlayerIDConnectionMap().get(playerID);
	}
	
	public Connection getConnection(Channel channel){
		return this.getConnection(channel.id());
	}
	
	public Connection getConnection(ChannelId channelID){
		return getChannelIDConnectionMap().get(channelID);
	}
	public Map<Integer,Connection> getPlayerIDConnectionMap(){
		return playerIDConnection;
	}
	
	public Map<ChannelId, Connection> getChannelIDConnectionMap(){
		return channelIDConnection;
	}
	
	
	public ChannelFuture sendData(Connection conn, MessageObj msgObj){
		Channel channel = conn.getChannel();
		ChannelFuture cf = null;
		
		if(channel != null && channel.isActive()){
			cf = this.sendData(conn.getChannel(), msgObj);
		}
		
		return cf;
	}
	
	public ChannelFuture sendData(Channel channel, MessageObj msgObj){
		return this.sendData(channel, msgObj, true);
	}
	
	public ChannelFuture sendData(Channel channel, MessageObj msgObj, boolean flag){
		ChannelFuture cf = channel.writeAndFlush(msgObj.getBuffData());
		if(flag){
			msgObj.gc();
		}
		return cf;
	}
	
	public ChannelFuture sendData(int playerID, MessageObj msgObj){
		Connection conn = this.getConnection(playerID);
		ChannelFuture cf = null;
		if(conn != null){
			cf = this.sendData(conn, msgObj);
		}
		
		return cf;
	}
	
	public void sendData(List<Integer>playerIDList, MessageObj msgObj){
		Connection conn = null;
		for(Integer playerID : playerIDList){
			conn = this.getConnection(playerID);
			if(conn != null){
				this.sendData(conn.getChannel(), msgObj, false);
			}
		}
		
		msgObj.gc();
	}
	
	public void snedDataToAll(MessageObj msgObj){
		GameSocketServer.channelGroup.writeAndFlush(msgObj);
		
		msgObj.gc();
	}
}

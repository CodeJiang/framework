package com.jiang.framework.socket;

import io.netty.channel.Channel;

public class Connection {
	/**������Ϣ�ľ��*/
	private Channel channel;
	/**��ҵ�ID*/
	private int playerID;
	public Channel getChannel() {
		return channel;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
}

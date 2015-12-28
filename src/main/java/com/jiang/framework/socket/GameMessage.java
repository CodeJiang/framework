package com.jiang.framework.socket;



public class GameMessage {
	private Connection connection;
	private int msgID;
	private byte[] data;
	public Connection getConnection() {
		return connection;
	}
	public int getMsgID() {
		return msgID;
	}
	public byte[] getData() {
		return data;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}

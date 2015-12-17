package com.jiang.framework.socket;

public class GameMessage {
	/**连接*/
	private Connection connection;
	/**消息ID*/
	private int msgID;
	/**消息数据*/
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

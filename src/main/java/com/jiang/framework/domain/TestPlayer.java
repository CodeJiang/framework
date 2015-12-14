package com.jiang.framework.domain;

import com.jiang.framework.dao.interfaces.IUpdate;

public class TestPlayer implements IUpdate{
	/**玩家ID*/
	private int playerID;
	/**用户名*/
	private String userName;
	/**密码*/
	private String password;
	
	public int getPlayerID() {
		return playerID;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getUpdateSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE T_PLAYER_TEST SET USER_NAME = '");
		sb.append(userName);
		sb.append("'");
		sb.append(",");
		sb.append("PASSWORD='");
		sb.append(password);
		sb.append("'");
		sb.append(" WHERE PLAYER_ID=");
		sb.append(playerID);
		
		return sb.toString();
	}
}

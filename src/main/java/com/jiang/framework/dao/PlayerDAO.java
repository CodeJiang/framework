package com.jiang.framework.dao;

import org.springframework.stereotype.Repository;

import com.jiang.framework.domain.TestPlayer;
import com.jiang.framework.util.BaseGameDAO;

@Repository
public class PlayerDAO extends BaseGameDAO {
	public TestPlayer insertPlayer(TestPlayer tp){
		StringBuilder sb = new StringBuilder(50);
		sb.append("INSERT INTO T_PLAYER_TEST(USER_NAME,PASSWORD) VALUE('"+tp.getUserName()+"','"+tp.getPassword()+"')");
		
		tp.setPlayerID(this.insert(sb.toString()));
		
		return tp;
	}
}

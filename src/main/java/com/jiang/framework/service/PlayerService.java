package com.jiang.framework.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiang.framework.dao.PlayerDAO;
import com.jiang.framework.domain.TestPlayer;
import com.jiang.framework.util.ClassUtil;

@Service
public class PlayerService {
	@Resource
	private PlayerDAO playerDAO;
	public void createPlayer(String username,String password){
		TestPlayer tp = new TestPlayer();
		tp.setUserName(username);
		tp.setPassword(password);
		
		playerDAO.insertPlayer(tp);
		
		System.out.println(ClassUtil.toString(tp));
	}
}

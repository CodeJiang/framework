package com.jiang.framework.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class BaseGameDAO {
	
	
	@Resource(name="jdbcTemplateGame")
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(String sql){
		int result = 0;
		try{
			result = jdbcTemplate.update(sql);
		}catch(Exception e){
			LogUtil.error("update sql error==>"+sql,e);
		}
		
		return result;
	}
	
	public int delete(final String sql){
		int result = 0;
		try{
			result = jdbcTemplate.update(sql);
		}catch(Exception e){
			LogUtil.error("delete sql error==>"+sql,e);
		}
		
		return result;
	}
	
	public int insert(final String sql){
		int autoID = 0;
		try{
			KeyHolder key = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection connection)
						throws SQLException {
							PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
							statement.executeUpdate();
							return statement;
					
				}
			}, key);
			autoID = key.getKey().intValue();
		}catch(Exception e){
			LogUtil.error("insert sql error===>"+sql,e);
		}
		
		return autoID;
	}
}

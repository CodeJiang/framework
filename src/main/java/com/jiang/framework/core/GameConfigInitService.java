package com.jiang.framework.core;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class GameConfigInitService {
	
	private GameConfigInitService(){
		
	}
	private static GameConfigInitService configService = new GameConfigInitService();
	
	public  static  GameConfigInitService getInstance(){
		return configService;
	}
	
	public void init(){
		try{
			InputStream in = GameConfigInitService.class.getClassLoader()
	                .getResourceAsStream("DBGcc.properties");
			Properties props = new Properties();
			props.load(in);
			System.out.println(props);
			DruidDataSource ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
			
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			try{
				conn = ds.getConnection();
				st = conn.createStatement();

				rs = st.executeQuery("SELECT * FROM t_game_config");
				while(rs.next()){
					System.setProperty("jdbcUrlLog", rs.getString("jdbcUrlLog"));
					System.setProperty("jdbcUrlGame", rs.getString("jdbcUrlGame"));
					System.setProperty("jdbcUrlBase", rs.getString("jdbcUrlBase"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(st != null){
					st.close();
				}
				
				if(rs != null){
					rs.close();
				}				
			}
			
			ds.close();			
			
		}catch(Exception e){
			System.out.println("init db gcc error");
			e.printStackTrace();
		}
		 
	}
}

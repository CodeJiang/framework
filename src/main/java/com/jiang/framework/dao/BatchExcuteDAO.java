package com.jiang.framework.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jiang.framework.constant.DBConstant;
import com.jiang.framework.dao.interfaces.IInsert;
import com.jiang.framework.dao.interfaces.IInsertV2;
import com.jiang.framework.dao.interfaces.IUpdate;
import com.jiang.framework.util.BaseGameDAO;
import com.jiang.framework.util.LogUtil;

@Repository
public class BatchExcuteDAO extends BaseGameDAO {

	public void batchExcute(Set<IUpdate> updateList) {
		Connection conn = null;
		Statement statement = null;
		try{
			conn = this.getJdbcTemplate().getDataSource().getConnection();
			statement = conn.createStatement();
			int n=0;
			for(IUpdate update : updateList){
				String sql = update.getUpdateSQL();
				
				statement.addBatch(sql);
				n++;
				if(n % DBConstant.BATCH_UPDATE_SIZE == 0 || n == updateList.size()){
					statement.executeBatch();
				}
			}
			
		}catch(Exception e){
			LogUtil.error("batch update error==>", e);
		}finally{
			if(statement != null){
				try{
					statement.close();
				}catch(Exception e){
					LogUtil.error("close statement error",e);
				}				
			}
			
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					LogUtil.error("close conn error", e);
				}
				
			}
			
		}
		 
	}
	
	/**该接口尽量使用小批次的*/
	public void batchCreate(List<IInsert> insertList) {
		Connection conn = null;
		Statement statement = null;
		try{
			conn = this.getJdbcTemplate().getDataSource().getConnection();
			statement = conn.createStatement();
			int n=0;
			for(IInsert insert : insertList){
				String sql = insert.getInsertSQL();
				
				statement.addBatch(sql);
				n++;
				if(n % DBConstant.BATCH_UPDATE_SIZE == 0 || n == insertList.size()){
					statement.executeBatch();
				}
			}
			
		}catch(Exception e){
			LogUtil.error("batch update error==>", e);
		}finally{
			if(statement != null){
				try{
					statement.close();
				}catch(Exception e){
					LogUtil.error("close statement error",e);
				}				
			}
			
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					LogUtil.error("close conn error", e);
				}
				
			}
			
		}
	}
	
	public void batchCreateV2(List<IInsertV2> insertList){
		Connection conn = null;
		Statement statement = null;
		try{
			conn = this.getJdbcTemplate().getDataSource().getConnection();
			statement = conn.createStatement();
			int n=0;
			StringBuilder sb = new StringBuilder(1024);
			for(IInsertV2 insert : insertList){
				insert.getInsertSQL(sb);		
				n++;
				if(n % DBConstant.BATCH_UPDATE_SIZE == 0 || n == insertList.size()){					
					statement.addBatch(sb.toString());
					statement.executeBatch();
					sb.delete(0, sb.length());
				}
			}
			
		}catch(Exception e){
			LogUtil.error("batch update error==>", e);
		}finally{
			if(statement != null){
				try{
					statement.close();
				}catch(Exception e){
					LogUtil.error("close statement error",e);
				}				
			}
			
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					LogUtil.error("close conn error", e);
				}
				
			}
			
		}
	}
	
}

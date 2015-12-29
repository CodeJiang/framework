package com.jiang.framework.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jiang.framework.constant.DBConstant;
import com.jiang.framework.dao.interfaces.IInsertV2;
import com.jiang.framework.util.BaseLogDAO;
import com.jiang.framework.util.LogUtil;

@Repository
public class BatchExcuteLogDAO  extends BaseLogDAO{

	public void batchCreate(List<IInsertV2> insertList) {
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

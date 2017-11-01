package com.wzx.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public abstract class DBUtil {
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	
	public DBUtil() throws SQLException{
		
		conn = DBConn.getConnection();
		
	}

	public void setPreparedStatement(String sql,Object ... obj){
	
		 try {
			 ps = conn.prepareStatement(sql);
			 for(int i = 0 ; i < obj.length;i++){
				 
				 ps.setObject(i+1, obj[i]);
				 
			 }
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	
	}
	
	
	public void closeDB(){
		
		DBConn.closeDB(ps, conn);
		
	}
	public void closeDB(ResultSet rs){
		
		DBConn.closeDB(conn, ps, rs);
		
	}
	
	//增，删，改
	public abstract boolean  executeUpdates(String sql,Object...obj);
	
	public abstract ResultSet executeQuerys(String sql,Object...obj);
	
	

}


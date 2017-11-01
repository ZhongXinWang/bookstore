package com.wzx.bookstore.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMysql  extends DBUtil{

	public DBMysql() throws SQLException {
		super();
	}
	    //增，删，改
		public boolean executeUpdates(String sql,Object...obj){

			try {
				
			 setPreparedStatement(sql,obj);
			 return ps.executeUpdate()>0?true:false;
				 
			} catch (SQLException e) {

				e.printStackTrace();
			}finally{
				
				closeDB();
				
			}

			return false;
			
		}
		//查询操作
		public ResultSet executeQuerys(String sql,Object...obj){

			try {
				
				setPreparedStatement(sql,obj);
				return  ps.executeQuery() == null?null:ps.executeQuery();
				
			} catch (SQLException e) {

				
				e.printStackTrace();
			}

			return null;

	 }
}

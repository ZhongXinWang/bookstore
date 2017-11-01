package com.wzx.bookstore.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//连接数据库
public class DBConn {

    private static Logger logger = Logger.getLogger(DBConn.class);
	private static ComboPooledDataSource dataSource = null;
	static{
	
		dataSource = new ComboPooledDataSource("myc3p0");

	}
	
	public static Connection getConnection() throws SQLException{

		return dataSource.getConnection();
	}
	public static void test() throws SQLException{
		
	logger.debug("table="+dataSource.getAutomaticTestTable()+"--"+dataSource.getInitialPoolSize()+"---"+dataSource.getNumBusyConnections());
		
	}
    //释放资源，将数据库连接还给数据库连接池
    public static void closeDB(Connection conn,PreparedStatement ps,ResultSet rs) {
            try {
                if (rs!=null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try {
                    if (ps!=null) {
                        ps.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally{
                    try {
                        if (conn!=null) {
                            conn.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    //释放资源，将数据库连接还给数据库连接池
    public static void closeDB(PreparedStatement ps,Connection conn) {
         try {
            if (ps!=null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




/*
	private final static String URL="jdbc:mysql://119.29.174.85:3306/bookstore";
	private final static String USER="book";
	private final static String PASS="123456";
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private Connection conn;
	public void connection(){
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println(conn.toString());
			
		} catch (ClassNotFoundException e) {
	
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}*/
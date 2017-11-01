package com.wzx.bookstore.util.test;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.wzx.bookstore.entity.Book;
import com.wzx.bookstore.util.DBConn;
import com.wzx.bookstore.util.DBMysql;
import com.wzx.bookstore.util.DBUtil;
import com.wzx.bookstore.util.SQLUtil;

public class TestDBUtil {

   private static Logger logger = Logger.getLogger(TestDBUtil.class);
	@Test
	public void TestConn(){
		DBUtil util = null;
		ResultSet rs = null;
		try{
			
		//	DBConn.test();
			
			util = new DBMysql();
			
			String sql = "select *from users";
			
		    rs = util.executeQuerys(sql);
			
			while(rs.next()){
				
				//System.out.println(rs.getString("user_name"));
				logger.info(rs.getString("user_name"));
				
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
		
			util.closeDB(rs);
			try {
				DBConn.test();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Test
	public void testAnnotation(){
		//声明对象
		AnnotationTest test = new AnnotationTest();
		//获取该对象的Class类
        Class clazz = test.getClass();
        logger.info(clazz+"---"+clazz.getName());
        //判断该类是否使用了Table注解
        boolean exists = clazz.isAnnotationPresent(Table.class);
        logger.info(exists);
        //如果不是该类的注解对象，直接return
        if(!exists){
        	
        	return ;
        }
        //获取注解对象
        Table table = (Table) clazz.getAnnotation(Table.class);
        //获取注解的值，输出    annotation
        logger.info(table.value());
	}
	
	@Test
	public void testAnnotation1(){
		//声明对象
		AnnotationTest test = new AnnotationTest();
		//获取该对象的Class类
        Class clazz = test.getClass();
        //判断该类是否使用了Table注解
        boolean exists = clazz.isAnnotationPresent(Request.class);
        logger.info(exists);
        //如果不是该类的注解对象，直接return
        if(!exists){
        	
        	return ;
        }
        //获取注解对象
        Request request = (Request) clazz.getAnnotation(Request.class);
        //获取注解的值，输出   annotation---/annotation
        logger.info(request.name()+"---"+request.url());
	}
	
	@Test
	public void testAnnotation2() throws NoSuchMethodException, SecurityException{
		//声明对象
		AnnotationTest test = new AnnotationTest();
		//获取该对象的Class类
         Method method = test.getClass().getMethod("test");
        //判断该类是否使用了Table注解
        boolean exists = method.isAnnotationPresent(Request.class);
        logger.info(exists);
        //如果不是该类的注解对象，直接return
        if(!exists){
        	
        	return ;
        }
        //获取注解对象
        Request request = (Request) method.getAnnotation(Request.class);
        //获取注解的值，输出   annotation---/annotation
        logger.info(request.name()+"---"+request.url());
	}
	
	@Test
	public void testTable(){
		
		try{
			Book b = new Book();
			b.setBookName("dddd");
			b.setBookPub("ddd");
		    
			String sql = SQLUtil.getInsert(b);
			
			logger.info(sql);
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
	}
}

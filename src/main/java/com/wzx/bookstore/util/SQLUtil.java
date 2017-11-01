package com.wzx.bookstore.util;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.sun.prism.paint.Color;
import com.wzx.bookstore.annotation.Column;
import com.wzx.bookstore.annotation.Table;

public class SQLUtil {

	static Logger log = Logger.getLogger(SQLUtil.class);
	/*获取到insert语句*/
	public static String getInsert(Object o){
		
		String sql = "insert into tableName (\ncolumnName\n) values(\ncolumnValue\n)";
		try{
			
		//获取tableName
		Class<?> clazz = o.getClass();
		boolean exists  = clazz.isAnnotationPresent(Table.class);
		//不存在该注解
		if(!exists){
			
			return null;
		}
		
		Table table = clazz.getAnnotation(Table.class);
		//添加tableName
		String tableName = table.value();
		sql = sql.replaceAll("tableName",tableName);
		
		//获取列的名字
		Field[] field = clazz.getDeclaredFields();
		for (Field f : field) {
			
			//不是Column注解的字段
			if(!f.isAnnotationPresent(Column.class)){
				
				continue;
			}
			
			Column c = f.getAnnotation(Column.class);
			
			log.info(c.value());
			
			
			
		}
		
		}catch(Exception e){
			
			//log.error(e.getMessage());
		e.printStackTrace();
		}
		
		
		
		return sql;
		
		
	}
}

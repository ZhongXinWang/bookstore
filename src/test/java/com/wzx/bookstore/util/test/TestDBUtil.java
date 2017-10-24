package com.wzx.bookstore.util.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wzx.bookstore.util.DBUtil;

public class TestDBUtil {

	private DBUtil mDbutil;
	@Before
	public void before(){
		
		mDbutil = new DBUtil();
		
	}
	@Test
	public void TestConn(){
		
		try{
			
			mDbutil.connection();
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		
	}
	@After
	public void after(){
		
		mDbutil = null;
		
	}
}

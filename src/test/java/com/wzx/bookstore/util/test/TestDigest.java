package com.wzx.bookstore.util.test;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.wzx.bookstore.util.MD5;

public class TestDigest {

	static Logger log = Logger.getLogger(TestDigest.class);
	@Test
	public void test(){

	
		log.info(MD5.getMD5AsSql("123456"));

	}
}

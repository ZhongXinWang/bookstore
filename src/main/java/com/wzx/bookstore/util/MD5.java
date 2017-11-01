package com.wzx.bookstore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;


public class MD5 {

	//加密出来的字符串和数据库的字符串不一样
	public static String getMD5(String str){
		
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
		    Base64 ba = new Base64();

		   String result= ba.encodeToString(md5.digest(str.getBytes("UTF-8")));
		   
		   return result;
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//和数据一样的md5加密算法
	public static String getMD5AsSql(String str){
		
		
		try {
			//声明加密的类型还有sha－1
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			//传递数据
			md5.update(str.getBytes("utf-8"));
			//有带参数的md5也会执行update的方法
			byte[] rs = md5.digest();
			//把字节转化为十六进制，一个字节8位，一个十六进制数4位二进制数
			
			return toHexStrings(rs);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static String toHexStrings(byte[] b){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < b.length;i++){
			
			
			int  j = b[i];
			//i<0要加上256变成正的
			if(j < 0){
				
				j+=256;
			}

			//如果i<16  也就是16进制的表示范围，前面直接加0
			if(j < 16){
				
				sb.append("0");
			}
			
			sb.append(Integer.toHexString(j));
			
		}
		
		//32位的md5十六进制数
		
		//16的md5十六进制数是去32头八位和尾八位得到

		return sb.toString();
		
		
	}
}

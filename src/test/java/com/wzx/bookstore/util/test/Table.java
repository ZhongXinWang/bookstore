package com.wzx.bookstore.util.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)    //声明该注解是什么类型的注解
@Retention(RetentionPolicy.RUNTIME)  //注解的生命周期
@Documented                          
public @interface Table {      //使用@interface声明注解

	String value();           //当只有一个value时，命名要使用value()
}

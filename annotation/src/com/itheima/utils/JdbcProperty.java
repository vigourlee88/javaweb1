package com.itheima.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface JdbcProperty {
	
	//声明了一个注解，可以替代配置文件
	String driverClass();
	
	String url();
	
	String user();
	
	String password();
	
}

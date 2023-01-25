package com.itheima.annotation;

public @interface MyAnnotation {
	
//  接口中属性默认是public static final
//	int i =10;
	
	public String show() ;//在注解中，我们管他叫做注解属性

	int[] a();//基本数据类型
	
	boolean[] b();
	
	MyEnum[] me();//枚举类型
	
	MyAnnotation2[] ma2();//注解类型
	
	Class[] clazz();//类的class文件
	
}

package com.itheima.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Reflect_Test {
	
	@Test
	public void test() {
		
		Map<String,Object> map= new HashMap<String,Object>();
		
		map.put("username","tom");
		map.put("age",20);
		map.put("sex","男");
		map.put("address","北京");
	}
	
	//通过属性对应的setXxx方法完成操作
	/**
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String,Object> map= new HashMap<String,Object>();
		
		map.put("username","tom");
		map.put("age",20);
		map.put("sex","男");
		map.put("address","北京");
		
		//1.得到Person类的Class
		Class clazz= Class.forName("com.itheima.reflect.Person");
		Object obj = clazz.newInstance();
		
		//2.得到Person类中方法
		Method[] methods= clazz.getDeclaredMethods();
		
		//3.遍历map
		for(String key:map.keySet()) {
		//	System.out.println(key);
			//将所有的key前面加上set,与方法的名称不区分大小写来对比
			String methodName="set"+key;//操作方法
			for(Method method:methods) {
				String mname=method.getName();
				if(methodName.equalsIgnoreCase(mname)) {
					method.invoke(obj, map.get(key));
				}	
			}
		}
		System.out.println(obj);
	}
	
	//通过属性来完成操作，不常见
	@Test
	public void test1() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
		
		Map<String,Object> map= new HashMap<String,Object>();
				
		map.put("username","tom");
		map.put("age",20);
		map.put("sex","男");
		map.put("address","北京");
		
		
		//1.得到Person类的Class
		Class clazz= Class.forName("com.itheima.reflect.Person");
		Object obj = clazz.newInstance();
		
		//2.得到Person类的所有属性
		Field[] fds = clazz.getDeclaredFields();
	    //3.得到Map中的所有的key
		Set<String> keys = map.keySet();
		
		for(Field f : fds) {
			String field_name=(f.getName());//得到属性名称比如是username
		    
			if(keys.contains(field_name)) {//map的key中包含了Person类的属性
				//4.将key对应的value赋值给属性
				//对私有化属性进行操作，需要取消检查
				f.setAccessible(true);
				f.set(obj, map.get(field_name));//map.get()得到"tom",赋给对象的属性f.set
			}
		}
		
		System.out.println(obj);
	
	}
	

}

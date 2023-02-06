package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class BeanFactory {
	
	
/*	private static IUserService userService= new UserServiceImpl();	
	public static IUserService getUserService() {		
		return userService;	
	} */
    
	//name属性对应的是bean.xml文件中的id, path代表的是bean,xml文件的路径
	
	public static Object createBean(String name,String path) {
		
		try {
			//使用dom4j来读取xml配置文件
			//1.创建一个SaxHeader
			SAXReader reader = new SAXReader();
			//2.加载xml文件
			Document document = reader.read(path);
			//3.查找bean.xml文件中<bean name=?>的Element
			Element element = (Element) document.selectSingleNode("//bean[@name='" + name + "']");
			//4.获取<bean name="" class="">获取class属性的值
			String attribute = element.attributeValue("class");
			//实例化一个对象
			return Class.forName(attribute).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}

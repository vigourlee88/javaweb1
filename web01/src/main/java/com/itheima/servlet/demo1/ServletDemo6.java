package com.itheima.servlet.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web项目中读取文件
 */
public class ServletDemo6 extends HttpServlet {
	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // test1();	
	   // test2();
		test3();
	}
	
	/**
	 * 读取web项目下的文件:使用servletContext读取
	 * @throws IOException 
	 * 
	 */
	
	private void test3() throws IOException {
        //使用servletContext方式	
		Properties properties = new Properties();
		//创建文件的输入流
		//InputStream is = new FileInputStream("classes/db.properties");
		//InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		System.out.println(path);
		InputStream is = new FileInputStream(path);
		properties.load(is);
		//获取数据
		String driverClassName = properties.getProperty("driverClassName");
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String username = properties.getProperty("username");
		//输出到控制台
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(password);
		System.out.println(username);

	}
	private void test2() throws IOException {
        //使用servletContext方式	
		Properties properties = new Properties();
		//创建文件的输入流
		//InputStream is = new FileInputStream("classes/db.properties");
		InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		properties.load(is);
		//获取数据
		String driverClassName = properties.getProperty("driverClassName");
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String username = properties.getProperty("username");
		//输出到控制台
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(password);
		System.out.println(username);

	}
	
	/**
	 * 传统方式读取文件*不好使
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	private void test1() throws FileNotFoundException, IOException {
		//传统方式	
		Properties properties = new Properties();
		//创建文件的输入流
		InputStream is = new FileInputStream("src/db.properties");
		properties.load(is);
		//获取数据
		String driverClassName = properties.getProperty("driverClassName");
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String username = properties.getProperty("username");
		//输出到控制台
		System.out.println(driverClassName);
		System.out.println(url);
		System.out.println(password);
		System.out.println(username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

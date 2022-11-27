package com.itheima.request.demo1;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Request接收中文数据
 */
public class RequestDemo3 extends HttpServlet {
	/**
	 * 演示get方式处理中文乱码
	 * get方式提交的数据在请求行的url后面，在地址栏上已经进行了一次URL编码了，
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
		//request.setCharacterEncoding("UTF-8");
		/**
		 *产生乱码的原因 
		 *GET方式提交的数据在请求行URL后面，在地址栏上其实就已经进行了一次URL编码了
		 *解决方案
		 *将存入到request缓冲区中的值以ISO-8859-1的方式获取到，以UTF-8方式进行解码
		 * 
		 */
		String name = request.getParameter("name");
		//String encode = URLEncoder.encode(name,"ISO-8859-1");
		//String decode = URLDecoder.decode(encode,"UTF-8");
		//System.out.println("姓名:"+decode);
	    //System.out.println("姓名:"+name);
		String value = new String(name.getBytes(),"UTF-8");
		System.out.println("姓名:"+value);
 
	}

	/**
	 * 演示post方式处理中文乱码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//接收数据
		/**
		 * 产生乱码的原因
		 ** post方式提交的数据是在请求体中，request对象接收到数据之后，放入request的缓冲区中，缓冲区就会有编码(默认ISO-8859-1不支持中文)
		 **解决方案:
		 *将request的缓冲区的编码修改了即可
		 */
		//设置缓冲区编码
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println("姓名:"+name);
	}

}

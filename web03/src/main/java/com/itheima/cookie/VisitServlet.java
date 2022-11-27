package com.itheima.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.CookieUtils;

/**
 * 记录用户上次访问时间的Servlet
 */
public class VisitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 用户访问servlet
		 * *如果第一次访问
		 *   显示您好，欢迎来到本网站
		 *   记录当前访问时间，存入到cookie,或写道浏览器
		 * *如果不是第一次访问
		 *   从cookie中获得上次时间，显示到页面
		 *   记录当前访问时间，存入到cookie,回写到浏览器
		 */
		//判读是否是第一次访问,从指定的cookie的数组中获得指定名称的cookie
		Cookie[] cookies = request.getCookies(); 
		//从数组中找到指定名称的cookie
		Cookie cookie = CookieUtils.findCookie(cookies,"lastVisit");
		//判断是否是第一次访问
		if(cookie == null) {
			//是第一访问
			//显示到页面上一段内容
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>您好,欢迎访问本站<h1>");
		}else {
			//不是第一次访问
			//获得cookie中上一次访问时间，显示到页面
			String value = cookie.getValue();
			value =URLDecoder.decode(value,"utf-8");
			//显示到页面上一段内容
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<h1>您好,您的上次访问时间为:"+value+"!</h1>");
		}
	    //记录当前系统时间存入到Cookie,回写到浏览器
		Date d = new Date();
		
		String value = URLEncoder.encode(d.toLocaleString(),"utf-8");
		//存入到cookie当中
		Cookie c = new Cookie("lastVisit",value);
		
		//给cookie设置项目下的有效路径
		c.setPath("web03");
		//给cookie设置有效时长
		c.setMaxAge(60 * 60);//有效时间为1小时
		//回写到浏览器
		response.addCookie(c);
	}

	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

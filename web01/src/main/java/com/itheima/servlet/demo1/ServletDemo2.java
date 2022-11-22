package com.itheima.servlet.demo1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet的启动时加载
 * @author jack
 *
 */
public class ServletDemo2 implements Servlet {
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletDemo2初始化了...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	}
	@Override
	public void destroy() {
	}

	
	
	
	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	

}

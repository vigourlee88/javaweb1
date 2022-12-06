package com.itheima.listener.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Bean2 implements HttpSessionActivationListener ,Serializable{
   @Override
	public void sessionDidActivate(HttpSessionEvent se) {
		
	   System.out.println("Bean2被session活化了...");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("Bean2被session钝化了...");
		
	}

    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}

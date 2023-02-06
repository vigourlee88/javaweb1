package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Customer;
import com.itheima.domain.JsonResult;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.itheima.utils.MailUtils;
import com.itheima.utils.RedisUtils;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if("regist".equals(method)) {
			regist(request, response);
			
		}
		
		if("sendEmail".equals(method)) {
			sendEmail(request, response);
			
		}
		
		
		if("checkEmail".equals(method)) {
			checkEmail(request, response);
			
		}
		
	}
    //邮箱认证
	public  void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
	    //1.获取请求参数
		String email= request.getParameter("email");
		String emailCode= request.getParameter("emailCode");
		
		//2.判断emailCode是否正确
		String _emailCode= (String) request.getSession().getAttribute("emailCode");
		JsonResult jr= new JsonResult();
		
		if(emailCode.equalsIgnoreCase(_emailCode)) {
			jr.setType(0);
			jr.setError("邮箱验证码不正确");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
			
		}
		//3.调用servlet完成认证操作
		ICustomerService customerService=new CustomerServiceImpl();
		try {
			customerService.updateEmailStatus(email);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		} catch (Exception e) {
			e.printStackTrace();
			jr.setType(0);
			jr.setError("邮箱验证失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
	   
		
	
	}
    //发送邮件
	public  void sendEmail(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException,IOException{
	
	//1.得到发送邮件的邮箱地址	
	String email=request.getParameter("email");
	//2.产生随机码
	String num = RandomStringUtils.randomNumeric(4);
	
	String emailMsg="邮箱验证码为:"+num;
	
	//在服务器端保存邮件验证码
	//request.getSession().setAttribute("emailCode", num);
	//存储到redis中
	RedisUtils.set(email, num, 3*60);//设置邮箱验证码，可以保存3分钟
	
	
	JsonResult jr=new JsonResult();
	
	try {
		//3.送邮件
		MailUtils.sendMail(email, emailMsg);
		jr.setType(1);
		response.getWriter().write(JSONObject.toJSONString(jr));
		return;
		
	} catch (Exception e) {
		e.printStackTrace();
		jr.setType(1);
		jr.setError("邮件发送失败");
		response.getWriter().write(JSONObject.toJSONString(jr));
		return;
	 }	
	
}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	//注册操作
	
	public  void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.得到请求参数，封装到Customer
		Customer c= new Customer();
		try {
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		ICustomerService customerService=new CustomerServiceImpl();
		//2.要保证客户的名称和账户是唯一的
		JsonResult jr= new JsonResult();
		try {
			
			Customer c1 = customerService.findByName(c.getC_name());
			Customer c2 = customerService.findByEmail(c.getC_name());
			if (c1 != null) {
				//说明用户名占用
				jr.setType(0);
				jr.setError("客户名称被占用");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;	
				
			}
			if (c2 != null) {
				//说明邮箱占用
				jr.setType(0);
				jr.setError("邮箱被占用");
				response.getWriter().write(JSONObject.toJSONString(jr));
				return;
				
			}
			//3.调用service将c添加，还需要添加账户信息
			customerService.addCustomer(c);
			jr.setType(1);
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			jr.setType(0);
			jr.setError("注册失败");
			response.getWriter().write(JSONObject.toJSONString(jr));
			return;
		}
	
	}

}

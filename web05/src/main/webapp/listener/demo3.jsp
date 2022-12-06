<%@page import="com.itheima.listener.bean.Bean1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  Bean1 bean1 = new Bean1();
  bean1.setName("张三");
  session.setAttribute("bean1",bean1);
  
  session.removeAttribute("bean1");

%>
</body>
</html>
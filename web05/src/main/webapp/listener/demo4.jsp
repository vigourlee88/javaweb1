<%@page import="com.itheima.listener.bean.Bean2"%>
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
  Bean2 bean2 = new Bean2();
  bean2.setName("bean2");
  
  session.setAttribute("bean2",bean2);

%>
</body>
</html>
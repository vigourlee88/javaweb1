<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>学生信息显示页面</h1>
<table border="1" width="600">
  <tr>
    <td>学生编号</td>
    <td>学生姓名</td>
    <td>学生性别</td>
    <td>学生年龄</td>
  </tr>
  <c:forEach var="student" items="${ list }" >
  <tr>
    <td>${ student.sid }</td>
    <td>${ student.sname }</td>
    <td>${ student.sex }</td>
    <td>${ student.age }</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
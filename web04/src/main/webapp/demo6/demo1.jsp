<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL获取数据</h1>
<%
  pageContext.setAttribute("name","张三");
  request.setAttribute("name","李四");
  session.setAttribute("name","王五");
  application.setAttribute("name","赵六");
%>

<%= pageContext.getAttribute("name") %> - ${ pageScope.name }<br/>
<%= request.getAttribute("name") %> - ${ requestScope.name }<br/>
<%= session.getAttribute("name") %> - ${ sessionScope.name }<br/>
<%= application.getAttribute("name") %> - ${ applicationScope.name }<br/>
<h1>EL的简写</h1>
${ name }

</body>
</html>
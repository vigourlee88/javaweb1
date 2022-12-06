<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>JSP的动作标签:转发</h1>
<jsp:forward page="/demo4/demo2.jsp">
     <jsp:param value="aaa" name="name"/>
</jsp:forward>
    

</body>

</html>
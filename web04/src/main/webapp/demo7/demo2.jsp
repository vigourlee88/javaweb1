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
<h1>JSTL的if标签的使用</h1>
<c:set var="i" value="5" scope="page"></c:set>
<c:if test="${ i >= 10 }">
    <font color="red">i大于等于10</font>
</c:if>
<c:if var="flag" test="${ i < 10 }" scope="page">
    <font color="blue">i小于10</font>
</c:if>

<c:if test="${ flag }"></c:if>
  flag为true
</body>
</html>
<%@page import="java.util.LinkedList"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Queue"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>树形遍历</h1>
<%
   //1.创建一个队列
    Queue<File> queue = new LinkedList<File>();
   //2.先将根节点入队
   File root = new File("C://bbb");
   queue.offer(root);
   //判断这个队列是否为空，不为空需要进行遍历
   while(queue.isEmpty()) {
	   //将根节点出队
	   File file = queue.poll();
	   //获得根节点下的所有子节点
	   File[] files = file.listFiles();
	   //遍历所有子节点
	   for(File f:files) {
		   //判断该节点是否为叶子节点
		   if(f.isFile()) {
%>
<h4><a href="${ pageContext.request.contextPath }/DownloadListServlet?filename=<%=f.getCanonicalPath()%>"><%= f.getName() %></a></h4>
<%	   
		   }else {
			   queue.offer(f);
		   }
	   }
   }
%>
</body>
</html>
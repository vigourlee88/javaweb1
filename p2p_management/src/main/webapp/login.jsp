<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P2P网站后台管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/semantic.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"/>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/semantic.js"></script>

<style type="text/css">
 body{
   font-family:Verdana,Arial,Helvetica,sans-serif;
   margin:0;
   background-color:#fff;
 }
 
 .ui.grid{
  margin:0;
 }
 .header-rowl{
  height:100px;
 }
.login-header{
 background-color:green;
 height:160px;

}
</style>
</head>
<body>
   <div class="ui three column stackable grid login-div">
   <div class="column"></div>
   <div class="column">
      <form id="login" class="ui fluid form segment"
          action="${pageContext.request.contextPath }/login" method="POST">
          <div class="inline field"></div>
          <div class="field">
           <label class="">用户名</label>
           <div class="ui left icon input">
             <input type="text" name="username" placeholder="Enter username">
             <i class="user icon"></i>
             <div class="ui corner label">
               <i class="icon asterisk"></i>
             </div>
           </div>
          </div>
          <div class="field">
           <label class="">密码</label>
           <div class="ui left icon input">
            <input type="password" name="password"
               placeholder="Enter password"> <i class="lock icon"></i>
               <div class="ui corner label">
                <i class="icon asterisk"></i>
                </div>
           </div>
          </div>
          
          <div class="inline field">
           <input type="submit" value="登录" class="ui blue submit button">
          </div>
          </form>
         </div>
         <div class="column"></div>
   </div>
    

</body>
</html>
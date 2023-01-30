<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P2P网站后台管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/semantic.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css"/>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/semantic.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/home.js"></script>

</head>
<body>
     <!-- header -->
     <div class="ui clearing segment">
       <h3 class="ui left floated header">
          P2P网站后台管理系统
       </h3>
       <div class="ui right floated header">
         <div class="ui horizontal list">
            <div class="item">
              <a href="javascript:;">${user.username }</a>
              <a href="javascript:;" onclick="shutdown()"><i class="power icon"></i></a>
            </div>
         </div>
       </div>
     </div>
     <!-- main -->
     
     <div class="ui grid">
       <!-- left -->
        <div class="two wide column">
          <div class="ui inverted segment">
            <div class="ui inverted accordion">
             <div class="title">
               <i class="dropdown icon"></i><i class="code icon"></i>用户及交易管理
             </div>
             <div class="content item vertical tabular menu">
                <div class="transition hidden header item" data-tab="one">用户信息管理</div>
                <div class="transition hidden header item" data-tab="two">资金流水记录</div>
                
             </div>
             <div class="title"></div>
            </div>
          </div>
        </div>
     </div>

</body>
</html>

//显示邮箱认证弹出窗口
function showMailModal(){
	
	//向服务器发送请求，获取当前用户的邮箱信息
	$.post("p2p_home/customer?method=findCustomer",function(data){
		var jsonObj=eval("("+data+")");
		if(jsonObj.type == 0){
			alert(jsonObj.error);
		}else{
			//没有认证，将客户的邮箱显示在文本框中
			$("#emailAddr").val(jsonObj.content.email);
			//弹出窗口
			$("#emailModal").modal("show");
			
			$("#emailSendBtn").click(function(){
				//向服务器发送请求，发送邮件
				$.post("p2p_home/customer?method=sendEmail",
				{"email":$("#emailAddr").val()},
				function(data){
					var jsonObj=eval("("+data+")");
					if(jsonObj.type ==0){
						alert(jsonObj.error);
					}else{
						alert("邮件发送成功，请查阅邮件，尽快认证");
					}
				});
			});
		}
	});
	
};
//邮箱认证操作
function emailRz(){
	//1.获取邮箱地址与录入的验证码
	var emailAddr =$("#emailAddr").val();
	var emailCode=$("#emailCheckCode").val();
	alert(emailAddr+" "+emailCode);
	//2.向服务器发送请求
	$.post("/p2p_home/customer?method=checkEmail",{"email":emailAddr,"emailCode":emailCode},function(data){
		var jsonObj=eval("("+data+")");
		if(jsonObj.type==0){
			alert(jsonObj.error);
			
		}else{
			//成功
			alert("邮箱认证成功");
			$("#emailStatus").html("已认证");
			$("#emailStatus").attr("class","yes");
			$("#emailIcon").attr("class","glyphicon glyphicon-ok-circle");
		    $("#emailModal").modal("hide");
		}
		
	});
	
}
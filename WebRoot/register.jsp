<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>register</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>register</title>
	<style type="text/css">
	
	.box1
	{
		padding: 0px 300px 200px 200px;
		height: 200px;
		width: 500px;
		border: solid 1px blue;
	}

	.innerbox
	{
		padding:  100px 120px;
		height: 70px;
		width: 200px;
		border: solid 2px red;
	}
	</style>
	<script type="text/javascript">
		function reg()
		{
			var request = new XMLHttpRequest();//创建XHR对象
			request.open("POST", "servlet/RegServlet");//post方式发送，默认异步
			var data = "username=" + document.getElementById("username").value 
		                  + "&password=" + document.getElementById("password").value
		                  + "&confirmp=" + document.getElementById("confirmp").value;//获取数据
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			request.send(data);
			request.onreadystatechange = function()
			{
				if(request.readyState===4)//表示请求已经完成
				{
					if(request.status===200)//用户请求被正确接收
					{ 
						document.getElementById("createResult").innerHTML = request.responseText;
						//获取响应的报文，使用innerHTML向searchResult中插入,通过上边判断请求成功之后，在html中显示提示
						/*alert("注册成功！！");
						setTimeout(location.href = "login_success.jsp",5000);//跳转页面*/
					} 
					else
				 	{
						alert("发生错误：" + request.status);
					}
				} 
			};
			
		}
	</script>
  </head>
  
  <body>
    <div class="box1">
		<h1>用户注册</h1>
		<div class="innerbox">
			<label>请输入您的用户名：</label>
			<input type="text" id="username" /><br>
			<label>请输入您的密码：</label>
			<input type="password" id="password" /><br>
			<label>请确认密码：</label>
			<input type="password" id="confirmp" /><br>	
			<input type="button" value="注册" id="register" onclick="reg()"/>
			<p id="createResult"></p>
			<!-- <button id="save">注册</button> -->
		</div>
	</div>
	
  </body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>register2</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  
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
  </head>
  
  <body>
    <div class="box1">
		<h1>用户注册</h1>
		<div class="innerbox">
			<form action="servlet/RegServlet" method="post">
				<label>请输入您的用户名：</label>
				<input type="text" id="username" /><br>
				<label>请输入您的密码：</label>
				<input type="password" id="password" /><br>
				<label>请确认密码：</label>
				<input type="password" id="confirmp" /><br>
				
				<input type="submit" value="注册" />
			</form>
			<!-- <button id="save">注册</button> -->
		</div>
	</div>
  </body>
</html>

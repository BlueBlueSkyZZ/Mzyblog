<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  
  <body style="background:#000;">
  <div class="login_logo"><img src="images/login_logo.jpg" alt=""></div>
  <div class="login">
  	<form action="servlet/LoginServlet" method="post">
    <div class="login_1"><input name="username" type="text" /></div>
    <div class="login_2"><input name="password" type="password" /></div>
    <div class="login_4"><a href="servlet/LoginServlet"><img src="images/login_08.jpg" /></a></div> 
    </form>
  </div>
</body>
</html>

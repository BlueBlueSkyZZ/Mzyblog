<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login4.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	  	function reloadCode()
			{
				var time = new Date().getTime();//获取时间
				document.getElementById("imagecode").src = "<%=request.getContextPath()%>/servlet/ImageServlet?d="+ time;
			}
	</script>
  </head>
  
  <body>
    <div id="container">
    	<div class = "logo" >
    		<a href="#"><img src="asserts/logo.png" alt=""></a>
    	</div>
    	<div id = "box">
    		<form name="loginForm" action="servlet/LoginServlet" method="post">
    		<p>
    			<label>用户名：</label>
    			<input name="username" type="text"/><br><br>
    			<label>密码：</label>
    			<input name="password" type="password"/>
    		</p>
    		验证码:<input type="text" name="checkcode"/>
	     	<img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
	     	<a href="javascript:reloadCode()">看不清楚</a><br> <!-- 刷新图片 -->
	     	<input type="submit" value="提交">
    		<p>
    			<a href = "register.jsp">还没注册？？亲，赶快！！</a>
    		</p>
    		</form>
    		
    	</div>
    </div>
  </body>
</html>

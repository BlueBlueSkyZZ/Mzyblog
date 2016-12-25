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
	<style type="text/css">
		#container1{
			float:left;
			height:500px;
			width:500px;
			border:solid #B1CEBC;
			padding-left:50px;
			padding-right:50px;
		}
		
		.logo{
			color:#4B5B51;
			font-size:60px;
			text-align:center;
		}
		
		.biggest{
			height:100%;
			width:80%;
			
			text-align:center;
			margin:0px auto;
			
		}
		
		.pic{
			float:left;
			width:500px;
			height:50px;
			margin-top:100px;
		
		}
	</style>
	<link rel="stylesheet" href="bootstrap/style/css/bootstrap.min.css"/>
	
	</head>
  
  <body>
  <div class="biggest">
	 	 <div class = "logo" >
	    		Welcome to My Blog
	    </div>
	    
	    <div class = "pic">
	    	<img src="images/pic.jpeg" alt="logo">
	    </div>
	    
	    <div id="container1">
	    	<br>
	    	<h2>账号登录</h2>
	    	
	    	<br>
	    	<div id = "box">
	    		<form name="loginForm" action="servlet/LoginServlet" method="post">
	    		<p>
	    		<div class="input-group">
	  				<span class="input-group-addon">用户名：</span>
	  				<input name="username" type="text" class="form-control" style="width:200px;" placeholder="Username">
				</div>
	    		<br>
	    		<div class="input-group">
	  				<span class="input-group-addon">密 码：</span>
	  				<input name="password" type="text" class="form-control" style="width:210px;" placeholder="Password">
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">验证码</span>
					<input type="text" class="form-control" style="width:110px;" name="checkcode">
					<img alt="验证码" id="imagecode" style="padding-right:50px;" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
		     	
				</div>
				<br>
		     	
		     	<input type="submit" value="登录" class="btn btn-primary" style="float:left;width:70px;margin-left:70px;">
		     	<a href="javascript:reloadCode()" style="float:right;padding-right:100px;">看不清楚</a><br> <!-- 刷新图片 -->
		     	<br>
		     	
	    		<p>
	    			<a href = "register.jsp">还没注册？？亲，赶快！！</a>
	    		</p>
	    		</form>
	    		
	    	</div>
	    </div>
    </div>
  </body>
</html>

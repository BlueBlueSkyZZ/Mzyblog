<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>write</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.box
	{
		
		height: 500px;
		width: 800px;
		border: solid 2px red;
	}
	h3
	{
		text-align:left;
		color: blue;
	}
	h4
	{
		color: green;
	}
	input
	{
		text-align: left;
	}
	</style>
	<script type="text/javascript">
	function show_confirm()
	{
		var ifconfirm;
		ifconfirm = confirm("确认提交？？");
		if(ifconfirm == true)
		{
			
			document.getElementsById("write").submit();//使用JS进行form表单提交
			return true;
		}
		else
		{
			return false;
		}
	}
	</script>
  </head>
  
  <body>
  <%
  	if(request.getSession().getAttribute("userid") == null)//session中的用户如果不存在或者过期则需要重新登录
  	{
  		response.sendRedirect("login4.jsp");//重定向
  		return;//直接返回不执行后面的代码
	}
  	 %>
   欢迎你，<%=request.getSession().getAttribute("username") %>,id<%=request.getSession().getAttribute("userid") %>
   <a href="servlet/LoginOutServlet">退出</a><br>
<hr>
	<form id="write" action="servlet/WriteServlet" method="post">
		<div class = "box">
			<h3>标题</h3>
			<textarea rows="1" cols="80" name="title"></textarea>
			<h4>文章内容</h4>
			<textarea rows="20" cols="100" name="content"></textarea>
			<input type="submit" value="提交" onclick="javascript:return show_confirm();"/><!-- 返回false相当于没点 --> 
		</div> 
		
	</form>
	<a href="myarticle.jsp">返回我的文章</a>
  </body>
</html>

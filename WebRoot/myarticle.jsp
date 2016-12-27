<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "dao.WriteDAO" %>
<%@ page import = "entity.Article" %><!-- 导入包 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>myarticle</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap/style/css/bootstrap.min.css"/>
	
	<style type="text/css">
	.box1
	{
		height: 70px;
		width: 200px;
		border: solid 2px red;
		float:left;
	}
	.title
	{
		height: 300px;
		width: 400px;
		border: solid 2px blue;
		float:left;
	}
	</style>
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
	<div class = "box1">
		<div><a href="homepage.jsp" >最新文章</a><br></div>
		
		<div><a href="myarticle.jsp" >我的文章</a></div>
		
		
	</div>
	<!-- <div class="widget"></div> -->
	<div class="title">
	
	
	<button type="button" class="btn btn-default btn-lg">
    		<a href="write.jsp" >
		<span class="glyphicon glyphicon-plus"></span>
		写新文章</a>
  			
		</button>
	
	<br>
		<%
			WriteDAO writeDao = new WriteDAO();//新建文章逻辑类
			ArrayList<Article> list = writeDao.getAllArticle();//获取所有文章信息的列表
			if(list != null && list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)//遍历列表，展示所有我的文章
				{
					
					Article article = list.get(i);//获取编号i的文章
					int userid = ((Integer)request.getSession().getAttribute("userid")).intValue();//Object类需要用Integar包装类进行强制转换
					if( userid == article.getUserid() )//对文章进行筛选，只显示当前用户的文章
					{	
						
						
			/*
			ItemsDAO itemsDao = new ItemsDAO();
    		ArrayList<Article> list = itemsDao.getAllItems();
     		if(list != null && list.size() > 0)
     		{
     			for(int i = 0; i < list.size(); i++)
     		{
     			Items item = list.get(i);*/
		 %>
		<a href="content.jsp?articleid=<%=article.getId() %>" ><%=article.getTitle() %></a><br>
		&nbsp;发布时间:<%=article.getDate() %>&nbsp;&nbsp;<a href="servlet/DeleteArServlet?id=<%=article.getId() %>" onclick = "">删除</a><br>
		<%
					}
				}	
			}
		 %>
	</div>
  </body>
</html>

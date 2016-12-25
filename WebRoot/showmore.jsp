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
    
    <title>My JSP 'showmore.jsp' starting page</title>
    
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
		padding:  100px 120px;
		height: 70px;
		width: 200px;
		border: solid 2px red;
	}
	.title
	{
		padding:  100px 240px;
		height: 200px;
		width: 400px;
		border: solid 2px blue;
	}
	.showmore
	{
		padding-left: 300px;
		
		padding-top: 100px;
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
		<a href="homepage.jsp" >最新文章</a><br>
		<a href="myarticle.jsp" >我的文章</a><br>
	</div>
	<div class="title">
		<%
			WriteDAO writeDao = new WriteDAO();//新建文章逻辑类
			ArrayList<Article> list = writeDao.getAllArticle();//获取所有文章信息的列表
			if(list != null && list.size() > 0)
			{

				for(int i = 0; i < list.size(); i++)//遍历列表，展示所有文章
				{
					
					Article article = list.get(i);//获取编号i的文章
					int userid = ((Integer)request.getSession().getAttribute("userid")).intValue();//Object类需要用Integar包装类进行强制转换
					
		 %>
		<a href="newcontent.jsp?articleid=<%=article.getId() %>" ><%=article.getTitle() %></a><br>&nbsp;作者:<%=writeDao.author(article.getUserid()) %>&nbsp;日期:<%=article.getDate() %><br>
		<%
			
				}
			}
		 %>
	</div>
  </body>
</html>

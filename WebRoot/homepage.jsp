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
    
    <title>homepage</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="bootstrap/style/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="bootstrap/style/js/bootstrap.min.js"/>
	<style type="text/css">
	.box1
	{
		
		height: 70px;
		width: 15%;
		border: solid 2px red;
		float:left;
		margin-left:10%;
		padding-left:20px;padding-top:20px;
	}
	.title
	{
	
		height: 300px;
		width: 400px;
		border: solid 2px blue;
		float:left;
		padding-left:5%;padding-top:2%;
	}
	.showmore
	{
		padding-left: 300px;
		
		padding-top: 100px;
	}
	</style>

	<script>
      $(function(){
          $('.dropdown-toggle').dropdown();
      });
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
	<div class = "box1">
		<img src="images/login_logo.jpg" alt="..." class="img-circle">
		<br>
		<a href="homepage.jsp" >最新文章</a><br>
		
		<a href="myarticle.jsp" >我的文章</a><br>
	</div>
	<div class="title">
		<%
			WriteDAO writeDao = new WriteDAO();//新建文章逻辑类
			ArrayList<Article> list = writeDao.getAllArticle();//获取所有文章信息的列表
			if(list != null && list.size() > 0)
			{
				int min = 5 > list.size() ? list.size() : 5;//最多显示五篇文章
				for(int i = 0; i < min; i++)//遍历列表，展示所有我的文章
				{
					
					Article article = list.get(i);//获取编号i的文章
					int userid = ((Integer)request.getSession().getAttribute("userid")).intValue();//Object类需要用Integar包装类进行强制转换
					//if( userid == article.getUserid() )//对文章进行筛选，只显示当前用户的文章
					//{	
		 %>
		<a href="newcontent.jsp?articleid=<%=article.getId() %>"><%=article.getTitle() %></a>
		&nbsp;&nbsp;作者:<%=writeDao.author(article.getUserid()) %><br><!-- 进行表之间的交互 -->
		&nbsp;&nbsp;发布时间:<%=article.getDate() %><br>
		<%
			//		}
			
				}
			}
		 %>
		<div class="showmore">
			<a href="showmore.jsp">显示更多</a>
		</div>
		
	</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import = "dao.WriteDAO" %>
<%@ page import = "entity.Article" %>

<%@ page import = "dao.CommentDAO" %>
<%@ page import = "entity.Comment" %><!-- 导入包 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newcontent.jsp' starting page</title>
    
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
	.artcontent
	{
		
		width: 800px;
		border: solid 2px red;
	}

	.comcontent
	{
		height: 80px;
		width: 800px;
		border: solid 2px blue;
	}
	h3
	{
		text-align:center;
		color:green;
	}
	.date
	{
		text-align:right;
	}
	.writecom
	{
		margin-top:50px;
		height: 100px;
		width: 800px;
		border: solid 2px yellow;
	}
	.delete0
	{
		display:block;/*暂时隐藏*/
		text-align:right;
	}
	.delete1
	{
		display:block;/*当符合条件时才能显示*/
		text-align:right;
	}
	</style>
	<script type="text/javascript">
		function show_confirm()
		{
			var ifconfirm;
			ifconfirm = confirm("确认提交？？");
			if(ifconfirm == true)
			{
				
				document.getElementsByName("write").submit();//使用JS进行form表单提交
			}
			else
			{
				
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
	int artuserid = 0;//文章作者id,必须初始化因为可能为空
  	 %>
     欢迎你，<%=request.getSession().getAttribute("username") %>
     <a href="servlet/LoginOutServlet">退出</a><br>
	<hr>
	<% 
		String artid = request.getParameter("articleid");
		int articleid = Integer.valueOf(artid).intValue();//将String转换为int
		
		WriteDAO writeDao = new WriteDAO();//新建文章逻辑类
		ArrayList<Article> list = writeDao.getAllArticle();//获取所有文章信息的列表
		if(list != null && list.size() > 0)
		{		
			for(int i = 0; i < list.size(); i++)//遍历列表，展示所有我的文章
			{
				Article article = list.get(i);//获取编号i的文章 
				if(article.getId() ==  articleid)
				{
					artuserid = article.getUserid();//文章作者id
					
	%>
					<div class="artcontent">
						<h3><%=article.getTitle()%></h3>
						<div class="date">
							作者:<%=writeDao.author(article.getUserid()) %>&nbsp;
							时间:<%=article.getDate() %>
						</div>
						<%=article.getContent() %>
				
					</div>
	 <% 			
	 			}
	 		}
	 		
	 	}
	 %>
	 <%
	 //自己的文章自己有权删除任何人的评论
	 	CommentDAO commentDao = new CommentDAO();//新建评论逻辑类
	 	ArrayList<Comment> comlist = commentDao.getAllComment();//获取所有评论信息的列表
	 	int userid = ((Integer)request.getSession().getAttribute("userid")).intValue();//Object类需要用Integar包装类进行强制转换
	 	if(comlist != null && comlist.size() > 0)
		{		
			for(int i = 0; i < comlist.size(); i++)//遍历列表，展示所有评论
			{
				Comment comment = comlist.get(i);//获取编号i的评论
	  			if(articleid == comment.getArticleid())
	  			{
	  				
	  %>
				<div class="comcontent">
					<%=comment.getContent()%>
					<div class="date">用户:<%=commentDao.reviewer(comment.getUesrid())%>&nbsp;评论时间:<%=comment.getDate()%></div>
					<%
						int authority = 0;//是否有权删除评论（仅评论者与文章作者有权删除评论）
						
				  		if(comment.getUesrid() == userid || userid == artuserid)//判断评论是否为当前用户所写
				  		{
				  			authority = 1;
					 %>
					<div class="delete<%=authority%>"><a href="servlet/DeleteComServlet?articleid=<%=comment.getArticleid()%>&commentid=<%=comment.getId()%>" >删除</a></div>
					<!-- 判断是否有权删除改变样式 -->
			
				</div>
				
	<%
					}
				}
			}
		}
	 %>
	
		<div class="writecom">
		提交评论<br>
		<form name="write" action="servlet/WriteComServlet?articleid=<%=artid%>" method="post">
			<textarea rows="4" cols="100" name="comment">不超过140个字</textarea>
			<input type="submit" value="提交" onclick="show_confirm()"/>
		</form>
		</div>
	<a href="homepage.jsp">返回主页</a>
  </body>
  </body>
</html>

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
	<link href="froala_editor/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="froala_editor/css/froala_editor.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="bootstrap/style/css/bootstrap.min.css"/>
	
	<style type="text/css">
	
	body{
	text-align: center;
    }

    section {
	    width: 80%;
	    margin: auto;
	    text-align: left;
    }
	
	
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
	
	#title{
		font-size:30px;
		text-align:center;
	}
	</style>
	<script type="text/javascript">
	function show_confirm()
	{
		var ifconfirm;
		ifconfirm = confirm("确认提交？？");
		if(ifconfirm == true)
		{
			/*ajax提交*/
			var request = new XMLHttpRequest();//创建XHR对象
			request.open("POST", "servlet/WriteServlet");//post方式发送，默认异步
			var data = "title=" + document.getElementById("title").innerHTML 
		                  + "&content=" + document.getElementById("content").innerHTML;//获取数据
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			request.send(data);
			request.onreadystatechange = function()
			{
				if(request.readyState===4)//表示请求已经完成
				{
					if(request.status===200)//用户请求被正确接收
					{ 
						location.href = "myarticle.jsp";
						
						//document.getElementById("createResult").innerHTML = request.responseText;
						//获取响应的报文，使用innerHTML向searchResult中插入,通过上边判断请求成功之后，在html中显示提示
						//alert("注册成功！！");
						//setTimeout(location.href = "login_success.jsp",5000);//跳转页面
					} 
					else
				 	{
						alert("发生错误：" + request.status);
					}
				} 
			};
			//document.getElementsById("write").submit();//使用JS进行form表单提交
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
	<!--<form id="write" action="servlet/WriteServlet" method="post">
		<div class = "box">
			<h3>标题</h3>
			<textarea rows="1" cols="80" name="title" placeholder="Title"></textarea>
			<h4>文章内容</h4>
			<textarea rows="20" cols="100" name="content"></textarea>
			<input type="submit" value="提交" onclick="javascript:return show_confirm();"/> 返回false相当于没点 
		</div> 
		
	</form>  -->
	<a href="myarticle.jsp">
		<button type="button" class="btn btn-default btn-lg">
			<span class="glyphicon glyphicon-home"></span>返回我的文章
		</button>
	</a>
	<section id="editor" style="height:700px;">
      <div id="edit" style="margin-top: 30px;">

          
      		<div id="title" >ランゲルハンス岛の午后——小确幸</div>
      		<div id="content" >摸摸口袋，发现居然有钱；<br>
							电话响了，拿起听筒发现是刚才想念的人；<br>
							你打算买的东西恰好降价了；<br>
							完美地磕开了一个鸡蛋；<br>
							吃妈妈做的炒鸡蛋；<br>
							排队时，你所在的队动得最快；<br>
							自己一直想买的东西，但是很贵，<br>
							一天你偶然的在小摊便宜的买到了；<br>
							当你运动完后，喝的冰镇透了的饮料<br>
							——“唔，是的，就是它”……<br>
							它们是生活中小小的幸运与快乐，<br>
							是流淌在生活的每个瞬间且稍纵即逝的美好，<br>
							是内心的宽容与满足，是对人生的感恩和珍惜。<br>
							当我们逐一将这些“小确幸”拾起的时候，<br>
							也就找到了最简单的快乐！<br>
		</div>
      		

      		
      </div>
      <input type="button" value="提交" class="btn btn-primary" onclick="javascript:return show_confirm();"> 
  </section>
	
  <script src="froala_editor/js/libs/jquery-1.11.1.min.js"></script>
  <script src="froala_editor/js/froala_editor.min.js"></script>
  <!--[if lt IE 9]>
    <script src="../js/froala_editor_ie8.min.js"></script>
  <![endif]-->
  <script src="froala_editor/js/plugins/tables.min.js"></script>
  <script src="froala_editor/js/plugins/lists.min.js"></script>
  <script src="froala_editor/js/plugins/colors.min.js"></script>
  <script src="froala_editor/js/plugins/media_manager.min.js"></script>
  <script src="froala_editor/js/plugins/font_family.min.js"></script>
  <script src="froala_editor/js/plugins/font_size.min.js"></script>
  <script src="froala_editor/js/plugins/block_styles.min.js"></script>
  <script src="froala_editor/js/plugins/video.min.js"></script>

  <script>
      $(function(){
          $('#edit').editable({inlineMode: false, alwaysBlank: true});
      });
  </script>
	
  </body>
</html>

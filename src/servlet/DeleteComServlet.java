package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;

public class DeleteComServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteComServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String articleid = request.getParameter("articleid");//获取文章id
		String id = request.getParameter("commentid");//获取评论id
		System.out.println("commentid="+id);
		System.out.println("articleid="+articleid);
		CommentDAO commentDao = new CommentDAO();//新建评论逻辑类
		System.out.println(request.getContextPath()+"/content.jsp?articleid="+articleid);
		commentDao.deleteComment(id);//删除评论
		//out.println(("<script>var ifconfirm;ifconfirm = confirm('确认提交？？')if(ifconfirm == true){window.location.href = request.getContextPath()+'/myarticle.jsp';//进行页面跳转}else{	}</script>"));//使用JS进行form表单提交
		response.sendRedirect(request.getContextPath()+"/content.jsp?articleid="+articleid);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

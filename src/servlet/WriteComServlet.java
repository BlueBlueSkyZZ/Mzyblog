package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;


public class WriteComServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WriteComServlet() {
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

		request.setCharacterEncoding("UTF-8");//防止输入中文乱码
		response.setCharacterEncoding("UTF-8");//防止输出中文乱码
		response.setContentType("text/html;charset=utf-8");//防止输出中文乱码
		CommentDAO commentDao = new CommentDAO();//新建写作逻辑类
		PrintWriter out = response.getWriter();
		int userid = (Integer) request.getSession().getAttribute("userid");//从session中获取userid
		String content = request.getParameter("comment");//获取评论
		String article = request.getParameter("articleid");//获取文章编号
		int articleid = Integer.parseInt(article);
		commentDao.addComToDB(articleid, userid, content);//将评论加入数据库
		out.println(("<script>alert('提交成功');</script>"));//跳出窗口history.back();location.reload()
		response.sendRedirect(request.getContextPath()+"/content.jsp?articleid="+articleid);//跳转回原来的页面实现刷新
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

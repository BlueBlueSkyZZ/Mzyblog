package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WriteDAO;

public class WriteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WriteServlet() {
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

		doPost(request,response);//ʹ��Post����ͳһ����
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

		request.setCharacterEncoding("UTF-8");//��ֹ������������
		response.setCharacterEncoding("UTF-8");//��ֹ�����������
		response.setContentType("text/html;charset=utf-8");//��ֹ�����������
		WriteDAO writeDao = new WriteDAO();//�½�д���߼���
		PrintWriter out = response.getWriter();
		int userid = (Integer) request.getSession().getAttribute("userid");//��session�л�ȡuserid
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		
		writeDao.addArticleToDB(userid, content, title);//��������ӵ����ݿ�
		
		out.println(("<script>alert('�ύ�ɹ�');history.back();</script>"));//��������
		response.sendRedirect(request.getContextPath()+"/myarticle.jsp");//��ת��myarticle.jspҳ��
		
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

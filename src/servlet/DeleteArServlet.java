package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WriteDAO;

public class DeleteArServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteArServlet() {
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
		
		String id = request.getParameter("id");//��ȡ����id
		System.out.println("id="+id);
		WriteDAO writeDao = new WriteDAO();//�½�д���߼���
		writeDao.deleteArticle(id);//ɾ������
		//out.println(("<script>var ifconfirm;ifconfirm = confirm('ȷ���ύ����')if(ifconfirm == true){window.location.href = request.getContextPath()+'/myarticle.jsp';//����ҳ����ת}else{	}</script>"));//ʹ��JS����form���ύ
		response.sendRedirect(request.getContextPath()+"/myarticle.jsp");
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

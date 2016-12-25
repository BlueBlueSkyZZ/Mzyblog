package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import entity.User;

public class LoginServlet_code extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet_code() {
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
		/*
		 * ��֤��ģ��
		 * */
		response.setContentType("text/html;charset=utf-8");//��ֹ�����������
		String piccode = (String) request.getSession().getAttribute("piccode");//�ӻỰ��ȡ��֤����ַ���
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();//��Сд������
		PrintWriter out = response.getWriter();
		if(checkcode.equals(piccode))
		{
			/*
			 * ��֤�û����Լ�����ģ��
			 * */
			request.setCharacterEncoding("UTF-8");//��ֹ������������
			response.setCharacterEncoding("UTF-8");//��ֹ�����������
			LoginDAO loginDao = new LoginDAO();//�½��߼���
			ArrayList<User> list = loginDao.getAllUser();//��ȡUser��ArrayList
			int count = 0;////ͳ�Ʊ������
			boolean flag = false;//����Ƿ���й���ת
			if(list != null && list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)//��������List
				{
					count++;//ͳ�Ʊ������
					User user = list.get(i);//���list�е�user��
					if(user.getUsername().equals(request.getParameter("username")))//������ϢУ��
					{
						if(user.getPassword().equals(request.getParameter("password")))
						{
							response.sendRedirect(request.getContextPath()+"/login_success.jsp");
							flag = true;
							break;
						}
						else
						{
							response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
							flag = true;
							break;
						}
					}
				}
				if(count >= list.size() && !flag)
				{
					response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
			}
		}
		else
		{
			out.println("��֤��������󣡣���");
		}
		out.flush();//�����ˢ��
		out.close();//�ر��� 
		
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

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import dao.RegDAO;
import entity.User;

public class RegServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");//��ֹ�����������
		RegDAO regdao = new RegDAO();//�½�ע���߼���
		LoginDAO loginDao = new LoginDAO();//�½���¼�߼���
		ArrayList<User> list = loginDao.getAllUser();//��ȡUser��ArrayList
		PrintWriter out = response.getWriter();
		String usernameser = request.getParameter("username");
		String passwordser = request.getParameter("password");
		String confirmpser = request.getParameter("confirmp");
		int count = 0;
		boolean flag = true;//����û����Ƿ���ڣ���ֹ���������һ��ʱ����bug
		if(list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size(); i++)//��������List
			{
				count++;//ͳ�Ʊ������
				User user = list.get(i);//���list�е�user��
				if(user.getUsername().equals(usernameser))//������ϢУ��
				{
					out.println("�û����Ѵ��ڣ���");
					flag = false;
					break;
				}
			}
			if(count >= list.size() && flag)
			{
				if(!passwordser.matches(".{8,}"))//�����������ʽ
				{
					out.println("�������ٰ�λ");
				}
				else
				{
					if(!passwordser.equals(confirmpser)) //��֤�����Ƿ���ͬ
					{
						out.println("��ȷ�����������������ͬ����");
					}
					else
					{
						regdao.addUserToDB(usernameser, passwordser);//���û��������ݿ�
						out.println("ע��ɹ�");
						out.println(usernameser+"\\"+passwordser);
						out.println("<a href = 'login4.jsp'>���ص�¼ҳ��</a>");
						//out.println("<script type='text/javascript'>location.href = 'login_success.jsp'</script>");
					}
				}
				
			}
		}
		out.flush();
		out.close();
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

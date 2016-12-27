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

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);// 令get方法调用doPost方法
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 验证码模块
		 * */
		request.setCharacterEncoding("UTF-8");//防止输入中文乱码
		response.setCharacterEncoding("UTF-8");//防止输出中文乱码
		response.setContentType("text/html;charset=utf-8");//防止输出中文乱码
		String piccode = (String) request.getSession().getAttribute("piccode");//从会话获取验证码的字符串
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();//大小写不敏感
		PrintWriter out = response.getWriter();
		if(checkcode.equals(piccode))
		{
			/*
			 * 验证用户名以及密码模块
			 * */
			
			LoginDAO loginDao = new LoginDAO();//新建逻辑类
			ArrayList<User> list = loginDao.getAllUser();//获取User的ArrayList
			String username = request.getParameter("username");//获取输入的用户名
			String password = request.getParameter("password");//获取输入的密码
			int count = 0;////统计遍历序号
			boolean flag = false;//标记是否进行过跳转
			if(list != null && list.size() > 0)
			{
				for(int i = 0; i < list.size(); i++)//遍历整个List
				{
					count++;//统计遍历序号
					User user = list.get(i);//获得list中的user类
					if(user.getUsername().equals(username))//进行信息校验
					{
						if(user.getPassword().equals(password))
						{
							request.getSession().setAttribute("username", username.toString());//将用户名存储到会话中
							request.getSession().setAttribute("userid", user.getId());//将用户id存储到会话中
							response.sendRedirect(request.getContextPath()+"/homepage.jsp");
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
			out.println("验证码输入错误！！！<a href=\""+request.getContextPath()+"/login4.jsp\">返回登录页面</a>");
		}
		out.flush();//输出流刷新
		out.close();//关闭流 
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

package servlet;

import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
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
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);//宽、高、三色
		Graphics g = bi.getGraphics();//为组件创建一个图形
		Color c = new Color(200, 150, 255);//设置三原色
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);//FillRect函数用指定的画刷填充矩形
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r = new Random();//随机数
		int len = ch.length,index;
		StringBuffer sb = new StringBuffer();//创建字符串变量存储
		for(int i = 0; i < 4; i++)
		{
			index = r.nextInt(len);//随机返回一个小于len的整数
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));//随机生成颜色
			g.drawString(ch[index]+"", (i*15)+3, 18);//绘制字符 ！！！需要使用JRE1.7及以下版本
			
			
			sb.append(ch[index]);//往动态字符串数组添加绘制的字符
		}
		request.getSession().setAttribute("piccode", sb.toString());//将生成的图片码存储到会话中
		ImageIO.write(bi, "JPG", response.getOutputStream());//对象， 格式， 输出位置(客户端接收服务器发送的流 )
		
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
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

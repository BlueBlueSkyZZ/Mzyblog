package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Article;
import util.DBHelper;

public class WriteDAO {

	public void addArticleToDB(int userid, String content, String title)//date日期自动更新
	{
		Connection conn = null;
		PreparedStatement stmt = null;// 连接对象
		try
		{
			conn = DBHelper.getConnection();// 获得连接对象
			
			String sql = "INSERT INTO article VALUES(NULL, ?, ?, ?, NULL)";// sql语句注册用户
			stmt = conn.prepareStatement(sql);// 创建连接对象,使用PreparedStatement方法增加可维护性
			stmt.setInt(1, userid);
			stmt.setString(2, content);
			stmt.setString(3, title);
			int i = stmt.executeUpdate();
			System.out.println("成功添加了" + i + "篇文章");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		finally
		{
			//释放数据集对象
			if(stmt  != null)
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			//释放语句对象
			if(stmt  != null)//释放内存
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<Article> getAllArticle()
	{
		Connection conn = null;
		PreparedStatement stmt = null;//连接对象
		ResultSet rs = null;//数据集
		ArrayList<Article> list = new ArrayList<Article>();//用户集合
		try
		{
			conn = DBHelper.getConnection();//获得连接对象
			String sql = "SELECT * FROM article";//sql语句获得所有用户
			stmt = conn.prepareStatement(sql);//创建连接对象
			rs = stmt.executeQuery();//获得一个数据集
			while(rs.next())
			{
				//初始化对象
				Article article = new Article();
				
				article.setId(rs.getInt("id"));//设置文章id
				article.setUserid(rs.getInt("userid"));//设置文章userid
				article.setContent(rs.getString("content"));//设置文章content
				article.setTitle(rs.getString("title"));//设置文章title
				article.setDate(rs.getString("date"));//设置文章date

				list.add(article);//把一篇文章加入集合
			}
			return list;//返回集合
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//释放数据集对象
			if(rs  != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			//释放语句对象
			if(stmt  != null)//释放内存
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	
	public void deleteArticle(String id)
	{
		Connection conn = null;
		PreparedStatement stmt = null;//连接对象
		try
		{
			conn = DBHelper.getConnection();//获得连接对象
			String sql = "DELETE FROM article WHERE id = '" + id + "'";//sql语句获得所有用户,id为String格式，不能直接加入sql语句
			stmt = conn.prepareStatement(sql);//创建连接对象
			String sql2 = "DELETE FROM comment WHERE articleid = '" + id + "'";//删除文章的同时删除评论
			stmt = conn.prepareStatement(sql2);
			int i = stmt.executeUpdate(sql);
			int j = stmt.executeUpdate(sql2);
			System.out.println(sql);
			System.out.println(sql2);
			System.out.println("成功删除" + i + "篇文章");
			System.out.println("成功删除" + j + "篇评论");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{
			//释放数据集对象
			if(stmt  != null)
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			//释放语句对象
			if(stmt  != null)//释放内存
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
	
	public String author(int uid)
	{
		Connection conn = null;
		PreparedStatement stmt = null;//连接对象
		ResultSet rs = null;//数据集
		String name = null;//返回获取的用户名
		try
		{
			conn = DBHelper.getConnection();//获得连接对象
			String sql = "SELECT username FROM user WHERE id =" + uid;//sql语句获得所有用户
			stmt = conn.prepareStatement(sql);//创建连接对象
			rs = stmt.executeQuery();//获得一个数据集
			while(rs.next())
			{
				name = rs.getString("username");//将获得的username赋值给String name
		        //System.out.println(name);
			}
			return name;//返回集合
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//释放数据集对象
			if(rs  != null)
			{
				try
				{
					rs.close();
					rs = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			//释放语句对象
			if(stmt  != null)//释放内存
			{
				try
				{
					stmt.close();
					stmt = null;
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}
}


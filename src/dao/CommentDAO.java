package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;

import entity.Comment;

public class CommentDAO {
	public ArrayList<Comment> getAllComment()
	{
		Connection conn = null;
		PreparedStatement stmt = null;//连接对象
		ResultSet rs = null;//数据集
		ArrayList<Comment> list = new ArrayList<Comment>();//用户集合
		try
		{
			conn = DBHelper.getConnection();//获得连接对象
			String sql = "SELECT * FROM comment";//sql语句获得所有用户
			stmt = conn.prepareStatement(sql);//创建连接对象
			rs = stmt.executeQuery();//获得一个数据集
			while(rs.next())
			{
				//初始化对象
				Comment comment = new Comment();
				
				comment.setId(rs.getInt("id"));//设置评论id
				comment.setArticleid(rs.getInt("articleid"));//设置评论articleid
				comment.setContent(rs.getString("content"));//设置文章content
				comment.setUesrid(rs.getInt("userid"));//设置文章title
				comment.setDate(rs.getString("date"));//设置文章date

				list.add(comment);//把一篇文章加入集合
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
	
	
	public void addComToDB(int articleid, int userid, String content)// 增加评论数据到数据库
	{
		Connection conn = null;
		PreparedStatement stmt = null;// 连接对象
		try
		{
			conn = DBHelper.getConnection();// 获得连接对象
			
			String sql = "INSERT INTO comment VALUES(NULL, ?, ?, ?, NULL)";// sql语句注册用户
			stmt = conn.prepareStatement(sql);// 创建连接对象,使用PreparedStatement方法增加可维护性
			stmt.setInt(1, articleid);
			stmt.setInt(2, userid);
			stmt.setString(3, content);
			int i = stmt.executeUpdate();
			System.out.println("成功添加了" + i + "行");
			
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
	
	public void deleteComment(String commentid)
	{
		Connection conn = null;
		PreparedStatement stmt = null;//连接对象
		try
		{
			conn = DBHelper.getConnection();//获得连接对象
			String sql = "DELETE FROM comment WHERE id = '" + commentid + "'";//sql语句获得所有用户,id为String格式，不能直接加入sql语句
			stmt = conn.prepareStatement(sql);//创建连接对象
			
			int i = stmt.executeUpdate(sql);	
			System.out.println(sql);

			System.out.println("成功删除" + i + "篇评论");
			
			
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
	
	public String reviewer(int uid)
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

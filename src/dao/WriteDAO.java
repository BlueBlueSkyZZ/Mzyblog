package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Article;
import util.DBHelper;

public class WriteDAO {

	public void addArticleToDB(int userid, String content, String title)//date�����Զ�����
	{
		Connection conn = null;
		PreparedStatement stmt = null;// ���Ӷ���
		try
		{
			conn = DBHelper.getConnection();// ������Ӷ���
			
			String sql = "INSERT INTO article VALUES(NULL, ?, ?, ?, NULL)";// sql���ע���û�
			stmt = conn.prepareStatement(sql);// �������Ӷ���,ʹ��PreparedStatement�������ӿ�ά����
			stmt.setInt(1, userid);
			stmt.setString(2, content);
			stmt.setString(3, title);
			int i = stmt.executeUpdate();
			System.out.println("�ɹ������" + i + "ƪ����");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		finally
		{
			//�ͷ����ݼ�����
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
			//�ͷ�������
			if(stmt  != null)//�ͷ��ڴ�
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
		PreparedStatement stmt = null;//���Ӷ���
		ResultSet rs = null;//���ݼ�
		ArrayList<Article> list = new ArrayList<Article>();//�û�����
		try
		{
			conn = DBHelper.getConnection();//������Ӷ���
			String sql = "SELECT * FROM article";//sql����������û�
			stmt = conn.prepareStatement(sql);//�������Ӷ���
			rs = stmt.executeQuery();//���һ�����ݼ�
			while(rs.next())
			{
				//��ʼ������
				Article article = new Article();
				
				article.setId(rs.getInt("id"));//��������id
				article.setUserid(rs.getInt("userid"));//��������userid
				article.setContent(rs.getString("content"));//��������content
				article.setTitle(rs.getString("title"));//��������title
				article.setDate(rs.getString("date"));//��������date

				list.add(article);//��һƪ���¼��뼯��
			}
			return list;//���ؼ���
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//�ͷ����ݼ�����
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
			//�ͷ�������
			if(stmt  != null)//�ͷ��ڴ�
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
		PreparedStatement stmt = null;//���Ӷ���
		try
		{
			conn = DBHelper.getConnection();//������Ӷ���
			String sql = "DELETE FROM article WHERE id = '" + id + "'";//sql����������û�,idΪString��ʽ������ֱ�Ӽ���sql���
			stmt = conn.prepareStatement(sql);//�������Ӷ���
			String sql2 = "DELETE FROM comment WHERE articleid = '" + id + "'";//ɾ�����µ�ͬʱɾ������
			stmt = conn.prepareStatement(sql2);
			int i = stmt.executeUpdate(sql);
			int j = stmt.executeUpdate(sql2);
			System.out.println(sql);
			System.out.println(sql2);
			System.out.println("�ɹ�ɾ��" + i + "ƪ����");
			System.out.println("�ɹ�ɾ��" + j + "ƪ����");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{
			//�ͷ����ݼ�����
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
			//�ͷ�������
			if(stmt  != null)//�ͷ��ڴ�
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
		PreparedStatement stmt = null;//���Ӷ���
		ResultSet rs = null;//���ݼ�
		String name = null;//���ػ�ȡ���û���
		try
		{
			conn = DBHelper.getConnection();//������Ӷ���
			String sql = "SELECT username FROM user WHERE id =" + uid;//sql����������û�
			stmt = conn.prepareStatement(sql);//�������Ӷ���
			rs = stmt.executeQuery();//���һ�����ݼ�
			while(rs.next())
			{
				name = rs.getString("username");//����õ�username��ֵ��String name
		        //System.out.println(name);
			}
			return name;//���ؼ���
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		finally
		{
			//�ͷ����ݼ�����
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
			//�ͷ�������
			if(stmt  != null)//�ͷ��ڴ�
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


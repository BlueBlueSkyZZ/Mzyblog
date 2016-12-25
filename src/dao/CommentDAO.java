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
		PreparedStatement stmt = null;//���Ӷ���
		ResultSet rs = null;//���ݼ�
		ArrayList<Comment> list = new ArrayList<Comment>();//�û�����
		try
		{
			conn = DBHelper.getConnection();//������Ӷ���
			String sql = "SELECT * FROM comment";//sql����������û�
			stmt = conn.prepareStatement(sql);//�������Ӷ���
			rs = stmt.executeQuery();//���һ�����ݼ�
			while(rs.next())
			{
				//��ʼ������
				Comment comment = new Comment();
				
				comment.setId(rs.getInt("id"));//��������id
				comment.setArticleid(rs.getInt("articleid"));//��������articleid
				comment.setContent(rs.getString("content"));//��������content
				comment.setUesrid(rs.getInt("userid"));//��������title
				comment.setDate(rs.getString("date"));//��������date

				list.add(comment);//��һƪ���¼��뼯��
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
	
	
	public void addComToDB(int articleid, int userid, String content)// �����������ݵ����ݿ�
	{
		Connection conn = null;
		PreparedStatement stmt = null;// ���Ӷ���
		try
		{
			conn = DBHelper.getConnection();// ������Ӷ���
			
			String sql = "INSERT INTO comment VALUES(NULL, ?, ?, ?, NULL)";// sql���ע���û�
			stmt = conn.prepareStatement(sql);// �������Ӷ���,ʹ��PreparedStatement�������ӿ�ά����
			stmt.setInt(1, articleid);
			stmt.setInt(2, userid);
			stmt.setString(3, content);
			int i = stmt.executeUpdate();
			System.out.println("�ɹ������" + i + "��");
			
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
	
	public void deleteComment(String commentid)
	{
		Connection conn = null;
		PreparedStatement stmt = null;//���Ӷ���
		try
		{
			conn = DBHelper.getConnection();//������Ӷ���
			String sql = "DELETE FROM comment WHERE id = '" + commentid + "'";//sql����������û�,idΪString��ʽ������ֱ�Ӽ���sql���
			stmt = conn.prepareStatement(sql);//�������Ӷ���
			
			int i = stmt.executeUpdate(sql);	
			System.out.println(sql);

			System.out.println("�ɹ�ɾ��" + i + "ƪ����");
			
			
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
	
	public String reviewer(int uid)
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

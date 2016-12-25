package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;
import entity.User;;

public class LoginDAO {

	//������е���Ʒ��Ϣ
		public ArrayList<User> getAllUser()
		{
			Connection conn = null;
			PreparedStatement stmt = null;//���Ӷ���
			ResultSet rs = null;//���ݼ�
			ArrayList<User> list = new ArrayList<User>();//�û�����
			try
			{
				conn = DBHelper.getConnection();//������Ӷ���
				String sql = "select * from user";//sql����������û�
				stmt = conn.prepareStatement(sql);//�������Ӷ���
				rs = stmt.executeQuery();//���һ�����ݼ�
				while(rs.next())
				{
					//��ʼ������
					User user = new User();
					
					user.setId(rs.getInt("id"));//�����û�id
					user.setUsername(rs.getString("username"));//�����û�����
					user.setPassword(rs.getString("password"));//�����û�����
					/*item.setName(rs.getString("name"));
					item.setCity(rs.getString("city"));
					item.setNumber(rs.getInt("number"));
					item.setPrice(rs.getInt("price"));
					item.setPicture(rs.getString("picture"));*/
					//user.getUsername()
					list.add(user);//��һ����Ʒ���뼯��
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
}

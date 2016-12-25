package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBHelper;

public class RegDAO {

	public void addUserToDB(String username, String password)// �����û����ݵ����ݿ�
	{
		Connection conn = null;
		PreparedStatement stmt = null;// ���Ӷ���
		try
		{
			conn = DBHelper.getConnection();// ������Ӷ���
			
			String sql = "INSERT INTO user VALUES(NULL, ?, ?)";// sql���ע���û�
			stmt = conn.prepareStatement(sql);// �������Ӷ���,ʹ��PreparedStatement�������ӿ�ά����
			stmt.setString(1, username);
			stmt.setString(2, password);
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
}

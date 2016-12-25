package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBHelper;

public class RegDAO {

	public void addUserToDB(String username, String password)// 增加用户数据到数据库
	{
		Connection conn = null;
		PreparedStatement stmt = null;// 连接对象
		try
		{
			conn = DBHelper.getConnection();// 获得连接对象
			
			String sql = "INSERT INTO user VALUES(NULL, ?, ?)";// sql语句注册用户
			stmt = conn.prepareStatement(sql);// 创建连接对象,使用PreparedStatement方法增加可维护性
			stmt.setString(1, username);
			stmt.setString(2, password);
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
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;
import entity.User;;

public class LoginDAO {

	//获得所有的商品信息
		public ArrayList<User> getAllUser()
		{
			Connection conn = null;
			PreparedStatement stmt = null;//连接对象
			ResultSet rs = null;//数据集
			ArrayList<User> list = new ArrayList<User>();//用户集合
			try
			{
				conn = DBHelper.getConnection();//获得连接对象
				String sql = "select * from user";//sql语句获得所有用户
				stmt = conn.prepareStatement(sql);//创建连接对象
				rs = stmt.executeQuery();//获得一个数据集
				while(rs.next())
				{
					//初始化对象
					User user = new User();
					
					user.setId(rs.getInt("id"));//设置用户id
					user.setUsername(rs.getString("username"));//设置用户名称
					user.setPassword(rs.getString("password"));//设置用户密码
					/*item.setName(rs.getString("name"));
					item.setCity(rs.getString("city"));
					item.setNumber(rs.getInt("number"));
					item.setPrice(rs.getInt("price"));
					item.setPicture(rs.getString("picture"));*/
					//user.getUsername()
					list.add(user);//把一个商品加入集合
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
}

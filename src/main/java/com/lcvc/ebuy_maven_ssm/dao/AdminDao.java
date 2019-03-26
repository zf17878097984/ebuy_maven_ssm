package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	/**
	 * 根据账户名和密码去数据库查询，进行登录判断
	 * @param username 账户名
	 * @param password 密码
	 * @return true表示登录成功,false表示登录失败
	 */
	public Admin getAdmin(String username,String password){
		Admin admin=null;//null表示找不到账户
		Connection conn=DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select * from admin where username=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs=pstmt.executeQuery();
			if(rs.next()){//如果能够从数据库找到记录
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return admin;
	}


	/*public Admin getAdmin(String username){
		Admin admin=null;

		Connection conn=DBHelper.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select * from admin where username=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);

			rs=pstmt.executeQuery();
			if(rs.next()){//如果能够从数据库\
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConn(conn,pstmt,rs);
		}
		return admin;
	}*/

	
	
/*public static void main(String[] args) {
		AdminDao adminDao=new AdminDao();
		//System.out.println(adminDao.login("admin", "123"));
		//System.out.println(adminDao.login("user", "123"));
	System.out.println(adminDao.login("user", "123456"));
	System.out.println(adminDao.getAdmin("user"));
	System.out.println(adminDao.getAdmin("asd"));
	}*/
}
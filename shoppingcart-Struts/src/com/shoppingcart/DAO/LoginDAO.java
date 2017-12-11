package com.shoppingcart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.User;

public class LoginDAO {
Connection con;
	
	public LoginDAO(){
		try {
			Class.forName(JDBCConnection.DRIVER); 
			con = DriverManager.getConnection(JDBCConnection.URL, JDBCConnection.USERNAME, JDBCConnection.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public User getUser(String username){
		User user=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from login where username = ?");
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				//System.out.println(rs.getString("username"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.shoppingcart.services;

import java.sql.*;

import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.User;

public class LoginService {
	Connection con;
	
	public LoginService(){
		try {
			Class.forName(JDBCConnection.DRIVER); 
			con = DriverManager.getConnection(JDBCConnection.URL, JDBCConnection.USERNAME, JDBCConnection.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public User validate(String username){
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

package com.shoppingcart.services;

import java.sql.*;

import javax.servlet.RequestDispatcher;

import com.shoppingcart.DAO.LoginDAO;
import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.User;

public class LoginService {
	
	public Boolean validate(String username,String password){
		
		LoginDAO logindao=new LoginDAO();
		User user=logindao.getUser(username);
		
		if(user!=null && user.getPassword().equals(password)){
			//request.getSession().setAttribute("user", user.getUsername());
			//request.setAttribute("page", request.getParameter("page"));
			return true;
		}
		else 
			return false;
	}
}

package com.shoppingcart.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.model.User;
import com.shoppingcart.services.LoginService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String nextpage;
		LoginService loginservice=new LoginService();
		User user=loginservice.validate(username);
		
		if(user!=null && user.getPassword().equals(password)){
			request.getSession().setAttribute("user", user);
			request.setAttribute("page", request.getParameter("page"));
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/CartServlet");
			rd.forward(request, response);
			
		}
		else{
			request.setAttribute("invalid", "Invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}

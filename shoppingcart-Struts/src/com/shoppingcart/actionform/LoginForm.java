package com.shoppingcart.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
	
	
	private String username;
	private String password;

	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	public synchronized String getPassword() {
		return password;
	}

	public synchronized void setPassword(String password) {
		this.password = password;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors aerrors=new ActionErrors();
		if(username==""){
			aerrors.add("username_e", new ActionMessage("msg1"));
			return aerrors;
		}
		if(password==""){
			aerrors.add("password_e", new ActionMessage("msg2"));
			return aerrors;
		}
		return null;
		
	}

	
}

package com.shoppingcart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shoppingcart.actionform.LoginForm;
import com.shoppingcart.services.LoginService;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		LoginForm lf=(LoginForm)form;
		
		LoginService loginservice=new LoginService();
		Boolean result=loginservice.validate(lf.getUsername(),lf.getPassword());
		
		if(result){
		request.getSession().setAttribute("user",lf.getUsername());
		return mapping.findForward("success");
		}
		else{
		request.setAttribute("invalid", "Invalid credentials");
		return mapping.findForward("failure");
		}
	}

	
	
}

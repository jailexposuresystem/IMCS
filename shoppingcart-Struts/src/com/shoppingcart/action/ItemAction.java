package com.shoppingcart.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shoppingcart.model.Item;
import com.shoppingcart.services.ItemService;

public class ItemAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		String page;
		page=request.getParameter("page");
		System.out.println("execute");
		if(page!=null && page.equals("login")){
			ItemService itemservice=new ItemService();
			List<Item> items=itemservice.getItems();
			
			request.getSession().setAttribute("items", items);
			return mapping.findForward("items");
		}
		return null;
	}
	
}

package com.shoppingcart.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.shoppingcart.actionform.CartForm;
import com.shoppingcart.model.CartItem;
import com.shoppingcart.model.Item;
import com.shoppingcart.services.ItemService;

public class CartAction extends DispatchAction{

	private Map<Item,Integer> cartItems ;
	
	
	
	public ActionForward addToCart(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CartForm cartForm = (CartForm) form;
        System.out.println("addtocart");
        
        if(request.getSession().getAttribute("cartitems") != null){
			cartItems = (Map<Item,Integer>)request.getSession().getAttribute("cartitems");
		}else{
			cartItems = new HashMap<Item,Integer>();
		}
			for(Item item: (List<Item>) request.getSession().getAttribute("items")){
				Integer quantity;
				if(request.getParameter(Integer.toString(item.getId())) != null){
					if(request.getParameter("q" +Integer.toString(item.getId()) ) == ""){
						 quantity = 1;
					}else{
					 quantity =Integer.parseInt(request.getParameter("q" +Integer.toString(item.getId()) ));
					}
					cartItems.put(item,quantity);
				}
			}
			if(cartItems.size() != 0){
				request.getSession().setAttribute("cartitems", cartItems);
				System.out.println("items"+ cartItems.size());
		
			}
			
        return mapping.findForward("success");
    }

    public ActionForward checkout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	 CartForm cartForm = (CartForm) form;
    	 System.out.println("checkout");
    	 
    	 HashMap<Item,Integer> hm = (HashMap<Item,Integer>) request.getSession().getAttribute("cartitems");
		 List<CartItem> cartList =	ItemService.calculatePrices(hm);
		 Double total = ItemService.calculateTotal(cartList);
		 
		 request.setAttribute("cartlist", cartList);
		 request.setAttribute("total", total);

        return mapping.findForward("summary");
    }
    
	public ActionForward Checkout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		System.out.println("Checkout");
		request.getSession().setAttribute("cartitems", null);
		request.setAttribute("total",null);
		request.setAttribute("cartlist",null);
		
        return mapping.findForward("checkout");
    }
	public ActionForward BackToCart(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		System.out.println("BackToCart");
        return mapping.findForward("success");
    }
	public ActionForward helpMethod(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		System.out.println("help");
        return mapping.findForward("help");
    }
    
	
}

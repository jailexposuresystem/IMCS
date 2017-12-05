package com.shoppingcart.controller.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingcart.model.CartItem;
import com.shoppingcart.model.Item;
import com.shoppingcart.model.User;
import com.shoppingcart.services.ItemService;
import com.shoppingcart.services.LoginService;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<Item,Integer> cartItems ;
       

    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page;
		page=request.getParameter("page");
		if(page!=null && page.equals("login")){
			ItemService itemservice=new ItemService();
			List<Item> items=itemservice.getItems();
			
			request.getSession().setAttribute("items", items);
			RequestDispatcher rd=request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		
		}
		else if(page!=null && page.equals("Add")){
			
			
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
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/cart.jsp");
			request.setAttribute("page","login");
			rd.forward(request, response);
		} else if(page!=null && page.equals("Summary")){
			HashMap<Item,Integer> hm = (HashMap<Item,Integer>) request.getSession().getAttribute("cartitems");
		 List<CartItem> cartList =	ItemService.calculatePrices(hm);
		 Double total = ItemService.calculateTotal(cartList);
		 
		 request.setAttribute("cartlist", cartList);
		 request.setAttribute("total", total);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/summary.jsp");
			rd.forward(request, response);
			
		}else if(page!=null && page.equals("Checkout")){
			request.setAttribute("total",null);
			request.setAttribute("cartlist",null);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/thankyou.jsp");
			rd.forward(request, response);
		}
			
			
		
	}

}

package com.shoppingcart.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoppingcart.DAO.ItemDAO;
import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.CartItem;
import com.shoppingcart.model.Item;


public class ItemService {
	
	 
	
	public List<Item> getItems(){
		
		ItemDAO itemdao=new ItemDAO();
		List<Item> items=itemdao.getItems();
		return items;
	}
	
	public static List<CartItem> calculatePrices(HashMap<Item,Integer> hm){
		List<CartItem> cartItems = new ArrayList<CartItem>();
		for(Item item: hm.keySet()){
			Double amount = item.getPrice() * hm.get(item);
			cartItems.add(new CartItem(item.getId(), item.getName(), hm.get(item), amount));
		}
		return cartItems;
		
	}
	
	public static Double calculateTotal(List<CartItem> listCart){
		Double total= 0d;
		for(CartItem item: listCart){
			total = item.getAmount() + total;
			
		}
		return total;
		
	}
	
	
	
	
	
}

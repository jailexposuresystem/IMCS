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

import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.CartItem;
import com.shoppingcart.model.Item;


public class ItemService {
	
	 
	
	Connection con;

	public ItemService(){
		try {
			Class.forName(JDBCConnection.DRIVER); 
			con = DriverManager.getConnection(JDBCConnection.URL, JDBCConnection.USERNAME, JDBCConnection.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Item> getItems(){
		List<Item> items;
		try {
			PreparedStatement ps=con.prepareStatement("select * from item");
			
			
			ResultSet rs=ps.executeQuery();
			items = new ArrayList<Item>();
			while(rs.next()){
				
			items.add(new Item(rs.getInt("ID"),rs.getString("Name"),rs.getDouble("price")));
				
			}
			return items;
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
		
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

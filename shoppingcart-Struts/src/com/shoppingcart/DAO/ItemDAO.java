package com.shoppingcart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.connection.JDBCConnection;
import com.shoppingcart.model.Item;

public class ItemDAO {
	
	Connection con;

	public ItemDAO(){
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

}

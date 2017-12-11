package com.shoppingcart.model;

public class CartItem {
	private Integer id;
	private String name;
	private Integer quantity;
	private Double amount;
	
	public CartItem(Integer id, String name, Integer quantity, Double amount ) {
		
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
	}

	public synchronized Integer getId() {
		return id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized Integer getQuantity() {
		return quantity;
	}

	public synchronized Double getAmount() {
		return amount;
	}
	
	
	
	

}

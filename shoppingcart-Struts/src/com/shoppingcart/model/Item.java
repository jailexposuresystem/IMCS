package com.shoppingcart.model;

public class Item {

	private Integer id;
	private String name;
	private double price;
	
	
	public Item(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public synchronized Integer getId() {
		return id;
	}
	public synchronized void setId(Integer id) {
		this.id = id;
	}
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized double getPrice() {
		return price;
	}
	public synchronized void setPrice(double price) {
		this.price = price;
	}
	
	
	
}

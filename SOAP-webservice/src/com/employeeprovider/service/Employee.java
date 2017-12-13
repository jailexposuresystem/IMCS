package com.employeeprovider.service;

import java.io.Serializable;

public class Employee implements Serializable{
	

	
	private static final long serialVersionUID = -6576634314170090028L;
	private Integer id;
	private String name;
	private String address;
	
	public Employee(){
	}
	
	public Employee(Integer id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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
	public synchronized String getAddress() {
		return address;
	}
	public synchronized void setAddress(String address) {
		this.address = address;
	}
}

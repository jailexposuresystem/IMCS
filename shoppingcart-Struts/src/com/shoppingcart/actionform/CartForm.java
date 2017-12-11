package com.shoppingcart.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class CartForm extends ActionForm{
	
	private Integer id;
	private String name;
	private Integer quantity;
	private Double amount;
	
	
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


	public synchronized Integer getQuantity() {
		return quantity;
	}


	public synchronized void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public synchronized Double getAmount() {
		return amount;
	}


	public synchronized void setAmount(Double amount) {
		this.amount = amount;
	}


@Override
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
	// TODO Auto-generated method stub
	return super.validate(mapping, request);
}
}

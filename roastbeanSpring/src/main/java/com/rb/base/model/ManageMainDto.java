package com.rb.base.model;

public class ManageMainDto {
	
	String product_name;
	int order_qty;
	int order_price;
		
	public ManageMainDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ManageMainDto(String product_name, int order_qty, int order_price) {
		super();
		this.product_name = product_name;
		this.order_qty = order_qty;
		this.order_price = order_price;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getOrder_qty() {
		return order_qty;
	}
	
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	
	public int getOrder_price() {
		return order_price;
	}
	
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
		
		
		
	
} // End

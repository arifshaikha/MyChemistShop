package com.java.order;

public class Order {
	String custName;
	String name;
	int qty;
	Double price;
	
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	Double totalPrice;
	
	public Order()
	{
		custName=" ";
		name=" ";
		qty=0;
		totalPrice=0.0;
		
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [custName=" + custName + ", name=" + name + ", qty=" + qty + ", price=" + price + ", totalPrice="
				+ totalPrice + "]";
	}

	
	
	
	
	
}

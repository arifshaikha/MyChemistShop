package com.java.Chemist;

public class Chemist {
	
	
	String name;
	Double price;
	int stock;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Chemist(String name, Double price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Chemist() {
		name=" ";
		price=0.0;
		stock=0;
	}
	@Override
	public String toString() {
		return "Chemist [name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
	
	
}

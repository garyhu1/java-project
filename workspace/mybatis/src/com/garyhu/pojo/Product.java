package com.garyhu.pojo;

public class Product {

	private int id;
	private String name;
	private float price;
	private Category1 category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public Category1 getCategory() {
		return category;
	}
	public void setCategory(Category1 category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [ id = "+id+", name = "+name+", price = "+price+"]";
	}
}

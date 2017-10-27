package com.garyhu.pojo;

import java.util.Set;

public class User {
	private int id;
	private String name;
	private Set<Product> products;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
}

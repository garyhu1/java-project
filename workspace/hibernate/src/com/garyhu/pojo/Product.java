package com.garyhu.pojo;

import java.util.Set;

public class Product {
	private int id;
	private String name;
	private float price;
	Category category;
	private Set<User> users;
	private int version;
	
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
	
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
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Set<User> getUsers(){
		return users;
	}
}

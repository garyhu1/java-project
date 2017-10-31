package com.garyhu.service;

import java.util.List;

import com.garyhu.pojo.Product;

public interface ProductService {

	List<Product> list();
	
	void add(Product p);
	
	void update(Product p);
	
	void delete(Product p);
	
	Product get(int id);
}

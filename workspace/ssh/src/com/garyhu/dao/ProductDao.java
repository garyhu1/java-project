package com.garyhu.dao;

import com.garyhu.pojo.Product;
import java.util.List;

public interface ProductDao {

	List<Product> list();
	
	void add(Product p);
	
	Product get(int id);
	
	void update(Product p);
	
	void delete(Product p);
}

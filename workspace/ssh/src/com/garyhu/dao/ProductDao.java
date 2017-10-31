package com.garyhu.dao;

import com.garyhu.pojo.Product;
import java.util.List;

public interface ProductDao {

	List<Product> list();
	void add(Product p);
}

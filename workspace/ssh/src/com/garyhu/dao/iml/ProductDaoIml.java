package com.garyhu.dao.iml;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.garyhu.dao.ProductDao;
import com.garyhu.pojo.Product;

public class ProductDaoIml extends HibernateTemplate implements ProductDao {

	@Override
	public List<Product> list() {
		return find("from Product");
	}

	//增
	@Override
	public void add(Product p) {
		save(p);
	}

	//查
	@Override
	public Product get(int id) {
		return (Product)get(Product.class,id);
	}

	//改
	@Override
	public void update(Product p) {
	    super.update(p);
	}

	//删
	@Override
	public void delete(Product p) {
		super.delete(p);
	}

}

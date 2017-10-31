package com.garyhu.service.iml;

import java.util.List;

import com.garyhu.dao.ProductDao;
import com.garyhu.pojo.Product;
import com.garyhu.service.ProductService;

public class ProductServiceIml implements ProductService {

	ProductDao productDao;
	
	
	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Product> list() {
		List<Product> products = productDao.list();
		//没有数据的情况下添加5条数据到数据库中
		if(products.isEmpty()) {
			for(int i = 0;i < 5;i++) {
				Product p = new Product();
				p.setName("xiaomi MI"+(i+1));
				products.add(p);
				productDao.add(p);
			}
		}
		return products;
	}

	//增加
	@Override
	public void add(Product p) {
		productDao.add(p);
	}


	//更新
	@Override
	public void update(Product p) {
		productDao.update(p);
	}

	//删除
	@Override
	public void delete(Product p) {
		productDao.delete(p);
	}

	//获取
	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

}

package com.garyhu.action;

import java.util.List;

import com.garyhu.dao.ProductDao;
import com.garyhu.pojo.Product;

public class ProductAction {

	Product product;
	List<Product> products;
	ProductDao pDao = new ProductDao();
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String add() {
		System.out.println("name:"+product.getName());
		System.out.println("price:"+product.getPrice());
		pDao.add(product);
		return "list";
	}
	
	public String list() {
		products = pDao.listProduct();
		return "listJsp";
	}
	
	public String delete() {
		pDao.delete(product.getId());
		return "list";
	}
	
	public String edit() {
		product = pDao.get(product.getId());
		return "edit";
	}
	
	public String update() {
		pDao.update(product);
		return "list";
	}
}

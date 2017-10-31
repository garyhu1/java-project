package com.garyhu.action;

import java.util.List;

import com.garyhu.pojo.Product;
import com.garyhu.service.ProductService;

public class ProductAction {

	ProductService productService;
	List<Product> products;
	Product product;
			
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductService getProductService() {
		return productService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String list() {
		System.out.println(this);
		products = productService.list();
		return "listJsp";
	}
	
	public String add() {
		productService.add(product);
		return "listProduct";
	}
	
	public String delete() {
		productService.delete(product);
		return "listProduct";
	}
	
	public String update() {
		productService.update(product);
		return "listProduct";
	}
	
	public String edit() {
		product = productService.get(product.getId());
		return "editProduct";
	}
}

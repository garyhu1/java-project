package com.how2java.action;

import java.util.ArrayList;
import java.util.List;

import com.how2java.dao.CategoryDAO;
import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public class ProductAction {

	ProductDAO pdao = new ProductDAO();
	CategoryDAO cdao = new CategoryDAO();
	Product product;
	List<Product> products;
	List<Category> categorys;
	Category category;
	

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public String add() {
		System.out.println(product.getName());
		System.out.println(product.getCategory().getName());
		pdao.add(product);
		return "list";
	}
	public String edit() {
		categorys =cdao.listCategory();
		product =pdao.get(product.getId());
		return "edit";
	}
	public String delete() {
		pdao.delete(product.getId());
		return "list";
	}
	public String update() {
		pdao.update(product);
		return "list";
	}
	public String list() {
		categorys = cdao.listCategory();		
		if(null!=category){
			category = cdao.get(category.getId());
			products = new ArrayList(  category.getProducts());
			return "listJsp";
		}
		else{
			products = pdao.listProduct();
			return "listJsp";			
		}
		
		
		


	}

}

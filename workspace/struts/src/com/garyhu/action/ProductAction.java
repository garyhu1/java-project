package com.garyhu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.garyhu.bean.Category;
import com.garyhu.bean.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	private Product product;
	private List<Product> products;
	private List<Integer> selectedProducts;
	
	private List<Category> categories;
	
	private Date date;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Integer> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<Integer> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

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

	public String show() {
		product  = new Product();
		product.setName("xiaomi");
		return "show";
	}
	
	public String add() {
		System.out.println("name = "+product.getName());
		Map m = ActionContext.getContext().getSession();
		m.put("name", product.getName());
		return "show";
	}
	
	public String list() {
		products = new ArrayList<Product>();
		selectedProducts = new ArrayList<Integer>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("product1");
		Product p2 =  new Product();
		p2.setId(2);
		p2.setName("product2");
		Product p3 = new Product();
		p3.setId(3);
		p3.setName("product3");
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		selectedProducts.add(1);
		selectedProducts.add(2);
		return "list";
	}
	
	public String showList() {
		categories = new ArrayList<>();
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("category1");
		Category c2 = new Category();
		c2.setId(2);
		c2.setName("category2");
		
		categories.add(c1);
		categories.add(c2);
		
		List<Product> products1=new ArrayList();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("product1");
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("product2");
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("product3");
  
        products1.add(p1);
        products1.add(p2);
        products1.add(p3);
         
        List<Product> products2=new ArrayList();
        Product p4 = new Product();
        p4.setId(4);
        p4.setName("product4");
        Product p5 = new Product();
        p5.setId(5);
        p5.setName("product5");
        Product p6 = new Product();
        p6.setId(6);
        p6.setName("product6");
         
        products2.add(p4);
        products2.add(p5);
        products2.add(p6);
         
        c1.setProducts(products1);
        c2.setProducts(products2);
		return "showList";
	}
	
	public String addPage() {
		name="default name";
		return "addPage";
	}
	
	//也可以采用配置文件来设置
//	public void validate() {
//		if(product.getName().length()==0) {
//			addFieldError("product.name","name can't be empty");
//		}
//	}
}

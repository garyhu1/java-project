package com.how2java.action;
 
import java.util.List;
 
import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;
 
public class ProductAction {
 
    ProductDAO pdao = new ProductDAO();
    Product product;
    List<Product> products;
     
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
        pdao.add(product);
        return "list";
    }
    public String edit() {
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
        products = pdao.listProduct();
        return "listJsp";
    }
 
}
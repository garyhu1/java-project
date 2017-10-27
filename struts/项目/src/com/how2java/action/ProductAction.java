package com.how2java.action;
 
import com.how2java.bean.Product;
import com.opensymphony.xwork2.ActionSupport;
 
public class ProductAction extends ActionSupport{
    private Product product;
     
    public String show(){
        product = new Product();
        product.setName("iphone7");
        return "show";
    }
    public String add(){
        return "show";
    }
     
    public void validate(){
        if ( product.getName().length() == 0 ){ 
            addFieldError( "product.name", "name can't be empty" );
        }
    }   
     
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
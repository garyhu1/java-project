package com.garyhu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.garyhu.pojo.Category;
import com.garyhu.pojo.Product;
import com.garyhu.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {
	@Autowired
	Category c;
	@Autowired
	Product p;
	@Autowired
	ProductService ps;
	
	@Test
	public void test() {
		System.out.println("name : "+c.getName());
		System.out.println("名称："+p.getName());
		System.out.println("分类："+p.getCategory().getName());
		ps.doSomeService();
	}
	
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] {"applicationContext.xml"});
//		Category c = (Category)context.getBean("c");
//		System.out.println("name : "+c.getName());
		
//		Product p = (Product)context.getBean("p");
//		System.out.println("名称："+p.getName());
//		System.out.println("分类： "+p.getCategory().getName());
		
//		ProductService ps = (ProductService)context.getBean("s");
//		ps.doSomeService();
//	}
}

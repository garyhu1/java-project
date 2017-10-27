package com.garyhu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.garyhu.pojo.Product;

public class ProductDao {

	/**
	 * 增
	 */
	public void add(Product p) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		s.save(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 根据id获取Product
	 */
	public Product get(int id) {
		Product result = null;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		result = (Product)s.get(Product.class, id);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return result;
	}
	
	/**
	 * 根据id删除Product
	 */
	public void delete(int id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, id);
		s.delete(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 更新
	 */
	public void update(Product p) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		s.update(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 查询
	 */
	public List<Product> listProduct(){
		List<Product> products = new ArrayList<>();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		
//		s.beginTransaction();
		
		Query q = s.createQuery("from Product p");
		products = q.list();
		
//		s.getTransaction().commit();
		s.close();
		sf.close();
		return products;
	}
}

package com.garyhu.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.garyhu.pojo.Product;

public class GetProduct {

	public static void main(String[] args) {
		GetProduct gp = new GetProduct();
//		gp.getProduct();
//		gp.deleteProduct();
//		gp.updateProduct();
//		gp.queryProduct();
//		gp.queryCriteria();
//		gp.getTotal();
//		gp.querySql();
		gp.updatePrice();
	}
	
	public void getProduct() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 7);
		System.out.println("id: "+p.getId()+",name: "+p.getName()+",price: "+p.getPrice());
		System.out.printf("id: %d,name: %s,price: %f", p.getId(),p.getName(),p.getPrice());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void deleteProduct() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 4);
		if(p!=null) {
			s.delete(p);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
	public void updateProduct() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 6);
		if(p!=null) {
			p.setName("xiaomi_modify");
			s.update(p);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 模糊查询
	 */
	public void queryProduct() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		String name = "xiaomi";
//		s.createQuery("from Product p where p.name like ?");
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		List<Product> products = q.list();
//		q.iterate();
		
		for(Product p : products) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 使用criteria查询
	 */
	public void queryCriteria() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		String name = "xiaomi";
		
		Criteria c = s.createCriteria(Product.class);
		c.add(Restrictions.like("name","%"+name+"%"));
		//分页查询
		c.setFirstResult(3);
		c.setMaxResults(5);
		List<Product> ps = c.list();
		
		for(Product p : ps) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void querySql() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		String name = "xiaomi";
		
		String sql = "select * from product_ p where p.name like '%"+name+"%'";
		
		Query q = s.createSQLQuery(sql);
		List<Object[]> list = q.list();
		for(Object[] os : list) {
			for(Object filed : os) {
				System.out.println(filed+"\t");
			}
			System.out.println();
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void getTotal() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "xiaomi";
		Query q = s.createQuery("select count(*) from Product p where p.name like ?");
		q.setString(0,"%"+name+"%");
		//获取查询到的总数
		long total = (long)q.uniqueResult();
		System.out.println("total : "+total);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void updatePrice() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Session s2 = sf.openSession();
		s1.beginTransaction();
		s2.beginTransaction();
		
		Product p1 = (Product)s1.get(Product.class, 8);
		System.out.println("原来价格为："+p1.getPrice());
		
		p1.setPrice(p1.getPrice()+1000);
		
		Product p2 = (Product)s2.get(Product.class, 8);
		p2.setPrice(p2.getPrice()+1000);
		
		Product p = (Product)s1.get(Product.class, 8);
		System.out.println("改变后价格为："+p.getPrice());
		
		s1.getTransaction().commit();
		s2.getTransaction().commit();
		s1.close();
		s2.close();
		sf.close();
	}
}

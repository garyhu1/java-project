package com.garyhu.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.garyhu.pojo.Category;
import com.garyhu.pojo.Product;
import com.garyhu.pojo.User;

public class TestHibernate {
	
	public static void main(String[] args) {
		TestHibernate th = new TestHibernate();
//		th.insert(" iPhone");
		th.setCategory();
//		th.getProducts();
//		th.setUser();
//		th.buyProduct();
//		th.testTransaction();
//		th.testAttrLoad();
	}
	
	public void insert(String name) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s =sf.openSession();
		
		s.beginTransaction();
		
		for(int i = 0;i < 10;i++) {
			Product p = new Product();
			p.setName(name+(i+1));
			p.setPrice(499f*(i+1));
			s.save(p);
		}
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void setCategory() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s =sf.openSession();
		
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("phone");
		s.save(c);
		
		for(int i = 0; i< 10;i++) {
			if((i+1)!=8) {
				Product p = (Product)s.get(Product.class, (i+11));
				if(p!=null) {
					p.setCategory(c);
					s.update(p);
				}
			}
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void getProducts() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 4);
		Set<Product> products = c.getProducts();
		for(Product p : products) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void setUser() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Set<User> users = new HashSet();
		for(int i = 0;i < 3;i++) {
			User u = new User();
			u.setName("user"+(i+1));
			users.add(u);
			s.save(u);
		}
		
		Product p = (Product)s.get(Product.class, 5);
		if(p!=null) {
			p.setUsers(users);
			s.update(p);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void buyProduct() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		User u = (User)s.get(User.class, 3);
		Set<Product> ps = new HashSet();
		for(int i = 5;i < 9;i++) {
			Product p = (Product)s.get(Product.class,i);
			ps.add(p);
		}
		
		u.setProducts(ps);
		s.update(u);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void testTransaction() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p1 = (Product)s.get(Product.class, 1);
		s.delete(p1);
		
		Product p2 = (Product)s.get(Product.class, 2);
		p2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
		s.update(p2);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	/**
	 * 属性的延迟加载: 
	 * 当使用load的方式来获取对象的时候，
	 * 只有访问了这个对象的属性，hibernate才会到数据库中进行查询。
	 * 否则不会访问数据库
	 */
	public void testAttrLoad() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product)s.load(Product.class,1);
		System.out.println("log1");
		System.out.println(p.getName());
		System.out.println("log2");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

}

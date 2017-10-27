package com.garyhu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.garyhu.pojo.Category;

public class TestCategory {

	public static void main(String[] args) {
		TestCategory tc = new TestCategory();
//		tc.deleteCategory();
		tc.testCache();
	}
	
	public void insert() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c= new Category();
		c.setName("Java����˼");
		System.out.println("��ʱp��˲ʱ״̬");
		s.save(c);
		System.out.println("��ʱp�ǳ־�״̬");
		s.getTransaction().commit();
		s.close();
		System.out.println("��ʱp���ѹ�״̬");
		sf.close();
	}
	
	public void deleteCategory() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 4);
		s.delete(c);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public void testCache() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c1 = (Category)s.get(Category.class, 3);
		System.out.println("log1");
		Category c2 = (Category)s.get(Category.class, 3);
		System.out.println("log2");
		
		s.getTransaction().commit();
		s.close();
		
		Session s2 = sf.openSession();
	    s2.beginTransaction();
	    Category c3 = (Category)s2.get(Category.class, 3);
	    System.out.println("log3");
	  
	    s2.getTransaction().commit();
	    s2.close();
		sf.close();
	}
}

package com.how2java.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

public class CategoryDAO {

	public void add(Category p) {
		List<Category> result = new ArrayList();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		s.save(p);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}

	public Category get(int id) {
		Category result = null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		result = (Category) s.get(Category.class, id);

		s.close();
		sf.close();
		return result;
	}

	public void delete(int id) {
		List<Category> result = new ArrayList();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Category p = (Category) s.get(Category.class, id);

		s.delete(p);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}

	public void update(Category p) {
		List<Category> result = new ArrayList();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		s.update(p);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}

	public List<Category> listCategory() {
		List<Category> result = new ArrayList();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from Category p");

		result = q.list();

		s.close();
		sf.close();
		return result;
	}
	
	public static void main(String[] args) {
		
		Category p =new Category();
		p.setName("name1");
		
		
		new CategoryDAO().add(p);
		
		
	}

}

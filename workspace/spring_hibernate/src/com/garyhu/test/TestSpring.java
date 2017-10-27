package com.garyhu.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.garyhu.dao.CategoryDao;
import com.garyhu.pojo.Category;

public class TestSpring {

	public static void main(String[] args) {
		TestSpring ts = new TestSpring();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext.xml"});
		CategoryDao dao = (CategoryDao)context.getBean("dao");
//		ts.testUDNQ(dao);
//		ts.limitQuery(dao);
//		ts.getTotal(dao);
		ts.toQuery(dao);
	}
	
	/**
	 * 测试增删改查
	 */
	public void testUDNQ(CategoryDao dao) {
		//查询数据库
		List<Category> list = dao.find("from Category c");
		for(Category c:list) {
			System.out.println("name : "+c.getName());
		}
		//增加数据
		Category cc = new Category();
		cc.setName("category new");
//		dao.save(cc);
		//删除数据
//		Category c5 = dao.get(Category.class, 5);
//		dao.delete(c5);
		//修改数据
		Category c6 = dao.get(Category.class, 6);
		c6.setName("category6");
		dao.update(c6);
	}
	
	/**
	 * 分页查询
	 */
	public void limitQuery(CategoryDao dao) {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		int start = 5;
		int count = 10;
		List<Category> list = dao.findByCriteria(dc,start,count);
		for(Category c : list){
			System.out.println("name : "+c.getName());
		}
	}
	
	/**
	 * 获取数据总数
	 */
	public void getTotal(CategoryDao dao) {
		List<Long> l = dao.find("select count(*) from Category c");
		long total = l.get(0);
		System.out.println("total: "+total);
	}
	
	/**
	 * 条件查询
	 */
	public void toQuery(CategoryDao dao) {
		List<Category> list = dao.find("from Category c where c.name like ?","%c%");
		for(Category c : list) {
			System.out.println("name : "+c.getName());
		}
		
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.add(Restrictions.like("name","分类"));
		list = dao.findByCriteria(dc);
		
		for(Category c : list) {
			System.out.println("name : "+c.getName());
		}
	}
}

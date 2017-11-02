package com.garyhu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.garyhu.pojo.Category;

/**
 * 测试CRUD
 * @author garyhu
 *
 */
public class TestMybatis {
	public static void main (String[] args) {
		TestMybatis tm = new TestMybatis();
		String resource = "mybatis-config.xml";
		InputStream in = null;
		SqlSession ss= null;
		try {
			in = Resources.getResourceAsStream(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			
		    ss = ssf.openSession();
//		    tm.add(ss);
//		    tm.delete(ss);
//		    tm.get(ss);
//		    tm.update(ss);
//		    tm.list(ss);
//		    tm.likeSelect(ss);
		    tm.selectByIdAndName(ss);
		    
		    ss.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in!=null)
					in.close();
				if(ss!=null)
					ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//查询数据库中所有数据
	public void list(SqlSession ss) {
		List<Category> cs = ss.selectList("listCategory");
	    for(Category c : cs) {
	    	System.out.println("name : "+c.getName());
	    }
	}
	
	//增
	public void add(SqlSession ss) {
		Category c = new Category();
		c.setName("category-6");
		
		ss.insert("addCategory",c);
	}
	
	//删
	public void delete(SqlSession ss) {
		Category c = new Category();
		c.setId(7);
		
		ss.delete("deleteCategory",c);
	}
	
	//条件查询
	public void get(SqlSession ss) {
		Category c = ss.selectOne("getCategory", 4);
		System.out.println("条件查询结果 ： "+c.getName());
	}
	
	//改
	public void update(SqlSession ss) {
		Category c = ss.selectOne("getCategory",3);
		c.setName("修改category名称");
		ss.update("updateCategory",c);
	}
	
	//模糊查询
	public void likeSelect(SqlSession ss) {
		List<Category> cs = ss.selectList("listCategoryByName","cate");
		for(Category c : cs) {
			System.out.println("name : "+c.getName());
		}
	}
	
	//条件加模糊查询
	public void selectByIdAndName(SqlSession ss) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("name", "cate");
		map.put("id", 3);
		
		List<Category> cs = ss.selectList("listCategoryByIdAndName",map);
		for(Category c : cs) {
			System.out.println("name : "+c.getName());
		}
	}
}

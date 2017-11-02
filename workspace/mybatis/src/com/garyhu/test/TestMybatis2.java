package com.garyhu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.garyhu.mapper.CategoryMapper;
import com.garyhu.mapper.CategoryMapper1;
import com.garyhu.mapper.OrderMapper;
import com.garyhu.mapper.ProductMapper;
import com.garyhu.pojo.Category;
import com.garyhu.pojo.Category1;
import com.garyhu.pojo.Order;
import com.garyhu.pojo.OrderItem;
import com.garyhu.pojo.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 测试通过注解的方式进行CRUD
 * @author garyhu
 *
 */
public class TestMybatis2 {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		SqlSession ss =  null;
		try {
			in = Resources.getResourceAsStream(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			ss = ssf.openSession();
			
			CategoryMapper mapper = ss.getMapper(CategoryMapper.class);
			CategoryMapper1 mapper1 = ss.getMapper(CategoryMapper1.class);
			ProductMapper mapper2 = ss.getMapper(ProductMapper.class);
			OrderMapper mapper3 = ss.getMapper(OrderMapper.class);
			
//			add(mapper);
//			get(mapper);
//			update(mapper);
//			delete(mapper);
//			listOne2More(mapper1);
//			listMore2One(mapper2);
//			listOrder(mapper3);
			
			//测试动态SQL语句
//			listDyna(mapper);
//			getDyna(mapper);
//			addDyna(mapper);
//			updateDyna(mapper);
//			deleteDyna(mapper);
			
			//测试分页查询
//			listByPage(mapper,0,5);
			
			//测试分页查询的插件
//			listByPageForPlugin(ss);
			
			//查询总数
//			count(mapper);
			
			ss.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(ss!=null)
				ss.close();
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//删
	public static void delete(CategoryMapper mapper) {
		mapper.delete(13);
		listAll(mapper);
	}
	
	//改
	public static void update(CategoryMapper mapper) {
		Category c = mapper.get(11);
		c.setName("衣服");
		mapper.update(c);
		listAll(mapper);
	}
	
	//根据id进行查询
	public static void get(CategoryMapper mapper) {
		Category c = mapper.get(11);
		System.out.println(c.getName());
	}
	
	//增
	public static void add(CategoryMapper mapper) {
		Category c = new Category();
		c.setName("手机");
		mapper.add(c);
		listAll(mapper);
	}
	
	//查所有数据
	public static void listAll(CategoryMapper mapper) {
		List<Category> cs = mapper.list();
		for(Category c: cs) {
			System.out.println(c.getName());
		}
	}
	
	//一对多的查询
	public static void listOne2More(CategoryMapper1 mapper) {
		List<Category1> cs = mapper.list();
		for(Category1 c : cs) {
			System.out.println(c.getName());
			List<Product> ps = c.getProducts();
			for(Product p : ps) {
				System.out.println("\t"+p.getName());
			}
		}
	}
	
	//多对一的查询
	public static void listMore2One(ProductMapper mapper) {
		List<Product> ps = mapper.list();
		for(Product p : ps) {
			System.out.println(p.getName()+"\t对应的分类是 ： "+p.getCategory().getName());
		}
	}
	
	//测试多对多
	public static void listOrder(OrderMapper mapper) {
		List<Order> os = mapper.list();
		for(Order o : os) {
			System.out.println(o.getCode());
			List<OrderItem> ois = o.getOrderItems();
			for(OrderItem oi : ois) {
				System.out.format("\t%s\t%f\t%d\n", 
						oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
			}
		}
	}
	
	//通过动态SQL语句删除
	public static void deleteDyna(CategoryMapper mapper) {
		mapper.deleteDyna(19);
		listDyna(mapper);
	}
	
	//通过动态SQL语句更新
	public static void updateDyna(CategoryMapper mapper) {
		Category c = mapper.getDyna(14);
		c.setName("修改后的category");
		mapper.updateDyna(c);
		listDyna(mapper);
	}
	
	//通过动态SQL语句添加
	public static void addDyna(CategoryMapper mapper) {
		Category c = new Category();
		c.setName("category6");
		mapper.addDyna(c);
		listDyna(mapper);
	}
	
	//通过动态SQL语句查询
	public static void getDyna(CategoryMapper mapper) {
		Category category = mapper.get(9);
		System.out.println(category.getName());
	}
	
	//通过动态sql语句来实现查询
	public static void listDyna(CategoryMapper mapper) {
		List<Category> cs = mapper.listDyna();
		for(Category c : cs) {
			System.out.println(c.getName());
		}
	}
	
	//分页查询
	public static void listByPage(CategoryMapper mapper,int start,int count) {
		List<Category> cs = mapper.listByPage(start, count);
		for(Category c : cs) {
			System.out.println(c.getName());
		}
	}
	
	//通过插件进行分页查询
	public static void listByPageForPlugin(SqlSession ss) {
		PageHelper.offsetPage(0, 5);
		List<Category> cs = ss.selectList("listCateg");
		for(Category c : cs) {
			System.out.println(c.getName());
		}
		PageInfo pageInfo = new PageInfo<>(cs);
		System.out.println("数据总数： "+pageInfo.getTotal());
		System.out.println(pageInfo);
	}
	
	//查询总数
	public static void count(CategoryMapper mapper) {
		int count = mapper.count();
		System.out.println("总数为 ： "+count);
	}
	
}

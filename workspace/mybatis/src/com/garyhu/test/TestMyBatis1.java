package com.garyhu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.garyhu.pojo.Category1;
import com.garyhu.pojo.Order;
import com.garyhu.pojo.OrderItem;
import com.garyhu.pojo.Product;

/**
 * 测试一对多和多对一以及多对多的关系
 * @author garyhu
 * @Decription:在多对多的时候不存在修改，可以通过删除一条，然后新增一条来达到新增的效果
 */
public class TestMyBatis1 {

	public static void main(String[] args) {
		TestMyBatis1 tm = new TestMyBatis1();
		String resource  = "mybatis-config.xml";
		InputStream in = null;
		SqlSession ss = null;
		try {
			in = Resources.getResourceAsStream(resource);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
			
			ss = ssf.openSession();
//			tm.one2More(ss);
//			tm.more2One(ss);
//			tm.update(ss);
//			tm.addOrderItem(ss);
//			tm.deleteOrderItem(ss);
			tm.more2More(ss);
			
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
	
	//一对多的关系
	public void one2More(SqlSession ss) {
		List<Category1> cs = ss.selectList("list");
		for(Category1 c : cs) {
			System.out.println(c);
			List<Product> ps = c.getProducts();
			for(Product p : ps) {
				System.out.println("\t"+p);
			}
		}
	}
	
	//多对一的关系
	public void more2One(SqlSession ss) {
		List<Product> ps = ss.selectList("listProduct");
		for (Product p : ps) {
            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
        }
	}
	
	//多对一的更新操作
	public void update(SqlSession ss) {
		Category1 c = ss.selectOne("getCate",10);
		
		Product p = ss.selectOne("getPro",5);
		
		p.setCategory(c);
		
		ss.update("updateProduct",p);
	}
	
	//多对多查询数据
	public void more2More(SqlSession ss) {
	     List<Order> os = ss.selectList("listOrder");
	     for(Order o : os) {
	    	 System.out.println("Order : "+o.getId()+"\t"+o.getCode());
	    	 List<OrderItem> ois = o.getOrderItems();
	    	 for(OrderItem oi : ois) {
	    		 System.out.format("\t%s\t%f\t%d\n", 
	    				 oi.getProduct().getName(),oi.getProduct().getPrice(),
	    				 oi.getNumber());
	    	 }
	     }
	}
	
	//添加订单
	public void addOrderItem(SqlSession ss) {
		Order o = ss.selectOne("getOrder",2);
		Product p = ss.selectOne("getPro",5);
		OrderItem oi = new OrderItem();
		oi.setOrder(o);
		oi.setProduct(p);
		oi.setNumber(50);
		
		ss.insert("addOrderItem",oi);
	}
	
	//删除订单
	public void deleteOrderItem(SqlSession ss) {
		OrderItem oi = new OrderItem();
		Order o = ss.selectOne("getOrder",1);
		Product p = ss.selectOne("getPro",9);
		oi.setProduct(p);
		oi.setOrder(o);
		
		ss.delete("deleteOrderItem",oi);
	}
}

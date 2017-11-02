package com.garyhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.garyhu.pojo.Product;

public interface ProductMapper {
	
	//通过cid列出所有的商品
	@Select("select * from product_ where cid=#{cid}")
	public List<Product> listByCategory(int cid);
	
	//列出所有商品的同时列出对应的种类
	@Select("select * from product_")
	@Results({
		@Result(property="category", column="cid", one=@One(select="com.garyhu.mapper.CategoryMapper1.get"))
	})
	public List<Product> list();
	
	//根据id来查询
	@Select("select * from product_ where id = #{id}")
	public Product get(int id);

}

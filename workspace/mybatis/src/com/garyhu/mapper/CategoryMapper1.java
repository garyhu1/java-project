package com.garyhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.garyhu.pojo.Category1;

/**
 * 一对多的注解查询
 * @author garyhu
 *
 */
public interface CategoryMapper1 {

	//列出所有的分类同时列出对应的所有商品
	@Select("select * from category_")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="products", javaType=List.class,column="id",
		  many = @Many(select="com.garyhu.mapper.ProductMapper.listByCategory"))
	})
	public List<Category1> list();
	
	//通过id查询
	@Select("select * from category_ where id = #{id}")
	public Category1 get(int id);
}

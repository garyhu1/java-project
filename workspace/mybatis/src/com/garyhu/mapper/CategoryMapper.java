package com.garyhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.garyhu.pojo.Category;
import com.garyhu.provider.CategoryDynaSqlProvider;

public interface CategoryMapper {
	
	//手写的sql语句
	@Insert("insert into category_ ( name ) values (#{name})")
	public int add(Category category) ;//增
	
	@Delete("delete from category_ where id = #{id}")
	public void delete(int id);//删
	
	@Update("update category_ set name=#{name} where id = #{id}")
	public int update(Category category);//改
	
	@Select("select * from category_ where id = #{id}")
	public Category get(int id);//查
	
	@Select("select * from category_")
	public List<Category> list();//查
	
	//查询总数
	@Select("select count(*) from category_")
	public int count();
	
	//分页查询
	@Select("select * from category_ limit #{start},#{count}")
	public List<Category> listByPage(@Param("start") int start,@Param("count") int count);
	
	
	//动态的SQL语句
	@InsertProvider(type=CategoryDynaSqlProvider.class,method="add")
	public int addDyna(Category category);//增
	
	@DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
	public void deleteDyna(int id);//删
	
	@UpdateProvider(type=CategoryDynaSqlProvider.class,method="update")
	public int updateDyna(Category category);//改
	
	@SelectProvider(type=CategoryDynaSqlProvider.class,method="get")
	public Category getDyna(int id);//查
	
	@SelectProvider(type=CategoryDynaSqlProvider.class,method="list")
	public List<Category> listDyna();//查
	
}

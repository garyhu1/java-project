package com.garyhu.provider;

import org.apache.ibatis.jdbc.SQL;

public class CategoryDynaSqlProvider {

	//查询所有
	public String list() {
		return new SQL()
				.SELECT("*")
				.FROM("category_")
				.toString();
	}
	
	//查单个
	public String get() {
		return new SQL()
				.SELECT("*")
				.FROM("category_")
				.WHERE("id=#{id}")
				.toString();
	}
	
	//增
	public String add() {
		return new SQL()
				.INSERT_INTO("category_")
				.VALUES("name", "#{name}")
				.toString();
	}
	
	//改
	public String update() {
		return new SQL()
				.UPDATE("category_")
				.SET("name=#{name}")
				.WHERE("id=#{id}")
				.toString();
	}
	
	//删
	public String delete() {
		return new SQL()
				.DELETE_FROM("category_")
				.WHERE("id=#{id}")
				.toString();
	}
}

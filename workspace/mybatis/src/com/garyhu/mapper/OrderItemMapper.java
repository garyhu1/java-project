package com.garyhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.garyhu.pojo.OrderItem;

public interface OrderItemMapper {

	//根据订单id来查询所有的订单项
	@Select("select * from order_item_ where oid = #{oid}")
	@Results({
		@Result(property="product", column="pid",one=@One(select="com.garyhu.mapper.ProductMapper.get"))
	})
	public List<OrderItem> listByOrder(int oid);
}

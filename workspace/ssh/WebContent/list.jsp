<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>产品列表</title>
   </head>
   <body>
       <table align="center" cellspacing="0" border="1" style="width: 500px;">
       		<tr>
       			<td>编号</td>
       			<td>名称</td>
       			<td>价格</td>
       			<td>编辑</td>
       			<td>删除</td>
       		</tr>
       		<s:iterator value="products" var="p">
       			<tr>
       				<td>${p.id}</td>
       				<td>${p.name}</td>
       				<td>${p.price}</td>
       				<td><a href="editProduct?product.id=${p.id}">edit</a></td>
       				<td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
       			</tr>	
       		</s:iterator>
       </table>
       <form action="addProduct" method="post" align="center" style="margin-top: 20px;">
       		<label>名称 ：<input type="text" name="product.name" /></label><br>
       		<label>价格 ：<input type="text" name="product.price" /></label><br>
       		<input type="submit" value="提交"/>
       </form>
   </body>
</html>
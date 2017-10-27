<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>商品列表</title>
   </head>
   <body>
       <table align="center" border="1" cellspacing="0" width="500px">
       		<tr>
       			<td>id</td>
       			<td>name</td>
       			<td>price</td>
       			<td>edit</td>
       			<td>delete</td>
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
       <br/><br/>
       <form action="addProduct" align="center" method="post">
       		<table align="center" border="1" cellspacing="0">
       			<tr>
       				<td>名称：</td>
       				<td>
       					<input type="text" name="product.name" value=""/>
       				</td>
       			</tr>
       			<tr>
       			    <td>价格： </td>
       			    <td>
       			    	<input type="text" name="product.price" value="0"/>
       			    </td>	
       			</tr>
       			<tr>
       				<td colspan="2" align="center">
       					<input type="submit" value="提交"/>
       				</td>
       			</tr>
       		</table>
       </form>
   </body>
</html>
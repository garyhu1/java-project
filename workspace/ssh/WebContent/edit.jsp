<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>编辑</title>
   </head>
   <body>
       <form action="updateProduct" method="post" align="center">
       		<label>名称 ： <input type="text" name="product.name" value="${product.name}"/></label><br/>
       		<label>价格 ： <input type="text" name="product.price" value="${product.price}"/></label><br/>
       		<input type="hidden" name="product.id" value="${product.id}"/>
       		<input type="submit" value="更新"/>
       </form>
   </body>
</html>
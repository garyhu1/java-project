<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>添加商品</title>
   </head>
   <body>
       <form action="addProduct" method="post" align="center" style="margin-top: 20px;">
       		<label>名称 ： <input type="text" name="name" value=""/></label><br>
       		<label>价格 ： <input type="text" name="price" value=""/></label><br>
       		<input type="submit" value="提交"/>
       </form>
   </body>
</html>
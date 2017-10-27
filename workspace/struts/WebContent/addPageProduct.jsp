<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>添加</title>
   </head>
   <body>
       <form action="addPageProduct" algin="center">
       	  <label>名称： </label><input type="text" name="product.name" value="${param.name}"/><br/><br/>
       	  <input type="submit" value="submit"/>
       </form>
   </body>
</html>
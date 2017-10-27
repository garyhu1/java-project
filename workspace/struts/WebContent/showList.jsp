<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>双重迭代展示</title>
   </head>
   <body>
       <table align="center" border="1" cellspacing="0">
           <tr>
              <td>id</td>
              <td>name</td>
              <td>products</td>
           </tr>
           <s:iterator value="categories" var="c">
           	  <tr>
           	     <td>${c.id}</td>
           	     <td>${c.name}</td>
           	     <td>
           	     	<s:iterator value="#c.products" var="p">
           	     	    ${p.name}<br/>
           	     	</s:iterator>
           	     </td>
           	  </tr>
           </s:iterator>
       </table>
       <s:debug/>
   </body>
</html>
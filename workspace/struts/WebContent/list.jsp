<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>商品表</title>
       <style type="text/css">
       		table {
			    border-collapse: collapse;
			}
			 
			td {
			    border: 1px solid gray;
			}
       </style>
   </head>
   <body>
       ${date}<br/>
       <table align="center">
       	 <tr>
	        <td>id</td>
	        <td>name</td>
	        <td>st.index</td>
	        <td>st.count</td>
	        <td>st.first</td>
	        <td>st.last</td>
	        <td>st.odd</td>
	        <td>st.even</td>
	     </tr>
	     <s:iterator value="products" var="p" status="st">
	     	<tr>
	            <td>${p.id}</td>
	            <td>${p.name}</td>
	            <td>${st.index}</td>
	            <td>${st.count}</td>
	            <td>${st.first}</td>
	            <td>${st.last}</td>
	            <td>${st.odd}</td>
	            <td>${st.even}</td>
	        </tr>
	     </s:iterator>
       </table>
       
       <s:checkboxlist value="selectedProducts" name="product.id"
           list="products" listValue="name" listKey="id"/>
       <br/><br/>
       <s:radio name="product.id" value="2" list="products" listValue="name" listKey="id"/>    
       
       <br/><br/>
       
       <s:select list="products"
            name="product.id"
            label="商品"
            listValue="name"
            listKey="id"
            size="3"
            multiple="true"
            value="selectedProducts"
       />
       <s:debug/>
   </body>
</html>
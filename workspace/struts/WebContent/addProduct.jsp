<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加商品</title>
	</head>
	<body>
	    <s:head/>
	    <s:form action="addProduct" method="post" align="center">
	    	<s:textfield name="product.name" label="名称"/>
	    	<s:submit value="提交"/>
	    </s:form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page isELIgnored="false"%>

<style>
table {
	border-collapse: collapse;
}

td {
	border: 1px solid gray;
}
</style>

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
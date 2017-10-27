<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/19
  Time: 15:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>购物车</title>
        <script src="../js/jquery.min.js"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <script src="../js/bootstrap.min.js"></script>
        <script>
            $(function () {
                $("a").addClass("btn btn-default");
            });
        </script>
    </head>
    <body>
        <div style="margin-top: 44px">
            <h1 align="center">购物车</h1>
        </div>
        <table style="width:800px; margin: 4px auto; " class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
            <tr>
                <td>商品名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
                <td>删除订单项</td>
            </tr>
            <c:forEach items="${items}" var="item" varStatus="st">
                <tr>
                    <td>${item.product.name}</td>
                    <td>${item.product.price}</td>
                    <td>${item.num}</td>
                    <td>${item.num*item.product.price}</td>
                    <td>
                        <a href="/deleteOrderItem?pid=${item.product.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${!empty items}">
                <tr>
                    <td colspan="5" align="center">
                        <a href="createOrder">生成订单</a>
                    </td>
                </tr>
            </c:if>
        </table>
    </body>
</html>

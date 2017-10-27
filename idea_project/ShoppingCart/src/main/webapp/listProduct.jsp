<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/19
  Time: 13:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<script src="../js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("a").addClass("btn btn-default");
    });
</script>
<html>
    <head>
        <title>商品列表</title>
    </head>
    <body>
        <div style="height: 40px"></div>
        <c:if test="${!empty user}">
            <div align="center">当前用户：${user.name}</div>
        </c:if>
        <table style="width:800px; margin: 4px auto; " class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
            <tr>
                <td>编号</td>
                <td>名称</td>
                <td>价格</td>
                <td>购买</td>
            </tr>
            <c:forEach items="${products}" var="product" varStatus="st">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>
                        <form action="/addOrderItem" class="form-inline" role="form" method="post">
                            <label for="num">数量 ：</label>
                            <input class="form-control" name="num" id="num" type="number" min="1"/>
                            <input type="hidden" name="pid" value="${product.id}"/>
                            <button type="submit" class="btn btn-default">购买</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/17
  Time: 16:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>--%>
<%--<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">--%>
<%--<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>--%>
<script src="../js/jquery.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<script src="../js/bootstrap.min.js"></script>
<script>
    $(function () {
        $("a").addClass("btn btn-default btn-xs")
    });
</script>
<html>
    <head>
        <title>英雄列表</title>
    </head>
    <body>
        <table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>hp</td>
                <td>damage</td>
                <td>edit</td>
                <td>delete</td>
            </tr>
            <c:forEach items="${heros}" var="hero" varStatus="st">
                <tr>
                    <td>${hero.id}</td>
                    <td>${hero.name}</td>
                    <td>${hero.hp}</td>
                    <td>${hero.damage}</td>
                    <td><a href="editHero?id=${hero.id}">edit</a></td>
                    <td><a href="deleteHero?id=${hero.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <nav>
            <ul class="pager">
                <li><a href="?start=0">首   页</a></li>
                <li><a href="?start=${pre}">上一页</a></li>
                <li><a href="?start=${next}">下一页</a></li>
                <li><a href="?start=${last}">末   页</a></li>
            </ul>
        </nav>
    </body>
</html>

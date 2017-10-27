<%@ page import="bean.Hero" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/17
  Time: 15:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>EL</title>
    </head>
    <body>
        <%
            Hero hero = new Hero();
            hero.setName("geelan");
            hero.setHp(672);
            request.setAttribute("hero",hero);
            List<String> heros = new ArrayList();
            heros.add("塔姆");
            heros.add("艾克");
            heros.add("巴德");
            heros.add("雷克赛");
            heros.add("卡莉丝塔");
            request.setAttribute("heros",heros);

            request.setAttribute("killNumber",12);
        %>
        <p>英雄名称： ${hero.name}</p>
        <p>英雄血量： ${hero.hp}</p>
        <table width="200px" align="center" border="1" cellspacing="0">
            <tr>
                <td>编号</td>
                <td>英雄</td>
            </tr>
            <c:forEach items="${heros}" var="h" varStatus="st">
                <tr>
                    <td>${st.count}</td>
                    <td>${h}</td>
                </tr>
            </c:forEach>
        </table>
    <%--可以取参:在请求网址后面添加?name=*****--%>
        <p>${param.name}</p>

        <%--eq的用法--%>
        <p>c:if的写法：</p>
        <c:if test="${killNumber>10}">
            <p>超神</p>
        </c:if>
        <c:if test="${!(killNumber>10)}">
            <p>没有超神</p>
        </c:if>
        <p>c:choose的写法：</p>
        <c:choose>
            <c:when test="${killNumber>10}">
                <p>超神</p>
            </c:when>
            <c:otherwise>
                <p>没有超神</p>
            </c:otherwise>
        </c:choose>
        <p>EL表达式eq的写法： </p>
        ${killNumber ge 10 ? "超神":"没有超神"}
    </body>
</html>

<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: garyhu
  Date: 2017/10/17
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>test</title>
    </head>
    <body>
        <c:set var="name" value="garyhu" scope="request"/>
        通过标签获取name: <c:out value="${name}"/><br/>
        <c:remove var="name" scope="request"/>
        通过标签获取name: <c:out value="${name}"/><br/>
        <c:set var="hp" value="${10}" scope="request" />
        <c:out value="${hp}"/>
        <%--没有else判断，可以取反进行判断--%>
        <c:if test="${hp<5}">
            <p>这个英雄已经快挂了</p>
        </c:if>
        <c:if test="${!(hp<5)}">
            <p>该英雄还可以抢救的</p>
        </c:if>
        <%--也可以用与else功能相似的方法--%>
        <c:choose>
            <c:when test="${hp<5}">
                <p>这个英雄马上就要嗝屁了</p>
            </c:when>
            <c:otherwise>
                <p>可以试着抢救下该英雄</p>
            </c:otherwise>
        </c:choose>
    <%--
       配合if使用的还有通过empty进行为空判断
       empty可以判断对象是否为null,字符串长度是否为0，集合长度是否为0
    --%>
        <%
           session.setAttribute("sexy","");
           session.setAttribute("age",null);
           session.setAttribute("items",new ArrayList());
        %>
        <c:if test="${empty sexy}">
            <p>没有性别</p>
        </c:if>
        <c:if test="${empty age}">
            <p>没有年龄</p>
        </c:if>
        <c:if test="${empty items}">
            <p>集合为空</p>
        </c:if>
    <%--<c:forTokens专门用于字符串拆分，并且可以指定多个分隔符--%>
        <c:set var="heros" value="李白,高渐离;吕布!芈月"/>
        <c:forTokens items="${heros}" delims=",;!" var="hero">
            <c:out value="${hero}"/><br/>
        </c:forTokens>
    </body>
</html>

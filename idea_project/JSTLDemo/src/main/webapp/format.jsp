<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/17
  Time: 15:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>格式化</title>
    </head>
    <body>
        <c:set var="pi" value="${3.1415926}"/>
        <c:set var="num" value="${88.8}"/>
        最少两位小数：
        <fmt:formatNumber type="number" value="${num}" minFractionDigits="2"/><br/>
        最多两位小数：
        <fmt:formatNumber type="number" value="${pi}" maxFractionDigits="2"/><br/>
    
    <%--
       <fmt:formatDate 表示格式化日期
        yyyy 表示年份
        MM 表示月份
        dd 表示日期
        E 表示星期几
        
        a 表示是上午还是下午
        HH 表示小时
        mm 表示分钟
        ss 表示秒
        S 表示毫秒
        z 表示时区
    --%>
        <%
            Date date = new Date();
            request.setAttribute("now",date);
        %>
        完整日期：<fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br/>
        完整时间：<fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br/>
        常见格式：<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
    </body>
</html>

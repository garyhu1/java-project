<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/17
  Time: 14:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>测试foeach循环</title>
    </head>
    <body>
        <%
            List<String> heros = new ArrayList();
            heros.add("塔姆");
            heros.add("艾克");
            heros.add("巴德");
            heros.add("雷克赛");
            heros.add("卡莉丝塔");
            request.setAttribute("heros",heros);
        %>
    <%--使用jsp中的for循环进行遍历--%>
        <table width="200px" align="center" cellspacing="0" border="1">
            <tr>
                <td>编号</td>
                <td>英雄</td>
            </tr>
            <%
                for(int i = 0;i<heros.size();i++){
            %>
            <tr>
                <td><%=(i+1)%></td>
                <td><%=heros.get(i)%></td>
            </tr>
            <%}%>
        </table><br/><br/>
    <%--使用jstl中的foreach循环--%>
        <table width="200px" align="center" cellspacing="0" border="1">
            <tr>
                <td>编号</td>
                <td>英雄</td>
            </tr>
            <c:forEach items="${heros}" var="hero" varStatus="st">
                <tr>
                    <td><c:out value="${st.count}"/></td>
                    <td><c:out value="${hero}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>setSession</title>
    </head>
    <body>
        <%
            session.setAttribute("name","garyhu");
        %>
        <a href="getSession.jsp">跳转到getSession页面</a>
    </body>
</html>

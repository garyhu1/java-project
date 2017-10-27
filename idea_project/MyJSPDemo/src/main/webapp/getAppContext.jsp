<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>getAppContext</title>
    </head>
    <body>
        <%
            String name  = (String) application.getAttribute("name");
        %>
        <p>获取的name: <%=name%></p>
    </body>
</html>

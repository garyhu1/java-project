<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/18
  Time: 9:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试Listener</title>
    </head>
    <body>
        <%
            application.setAttribute("test",1);
            application.setAttribute("test",2);
            application.removeAttribute("test");
        %>
        <h1>测试</h1>
    </body>
</html>

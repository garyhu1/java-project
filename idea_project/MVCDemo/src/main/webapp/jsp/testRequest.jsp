<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/18
  Time: 10:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试Request</title>
    </head>
    <body>
        <%
            request.setAttribute("test",1);
            request.setAttribute("test",2);
            request.removeAttribute("test");
        %>
        <p>测试request的监听</p>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/18
  Time: 10:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试Session</title>
    </head>
    <body>
        <%
            session.setAttribute("test",1);
            session.setAttribute("test",2);
            session.removeAttribute("test");
        %>
        <p>测试Session的属性监听</p>
    </body>
</html>

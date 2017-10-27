<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/18
  Time: 10:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>检查在线人数</title>
    </head>
    <body>
        <p>当前在线人数 : <%=application.getAttribute("online-number")%></p>
    </body>
</html>

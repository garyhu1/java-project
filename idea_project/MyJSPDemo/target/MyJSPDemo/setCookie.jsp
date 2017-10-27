<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cookie</title>
    </head>
    <body>
        <%
            Cookie c = new Cookie("name","garyhu");
            c.setMaxAge(60*24*60);
            c.setPath("127.0.0.1");
            response.addCookie(c);
        %>
        <a href="getCookie.jsp">跳转到获取Cookie的页面</a>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>getSession</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String id = session.getId();
        %>
        <p>session中的name: <%=name%></p>
        <p>session中的id: <%=id%></p>
    </body>
</html>

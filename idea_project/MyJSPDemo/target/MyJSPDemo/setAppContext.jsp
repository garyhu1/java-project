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
        <title>setAppContext</title>
    </head>
    <body>
        <%
            application.setAttribute("name","garyhu");
            System.out.println(application==request.getServletContext());
            response.sendRedirect("getAppContext.jsp");
        %>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>getCookie</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            request.setCharacterEncoding("UTF-8");
            if(cookies!=null){
                for (int i = 0; i < cookies.length-1; i++) {
                    System.out.print(cookies[i].getName() + ":" + cookies[i].getValue() + "<br>");
                }
            }
        %>
    </body>
</html>

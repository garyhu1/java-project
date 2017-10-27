<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/16
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试</title>
    </head>
    <body>
        <p>Hello JSP</p>
        <%-- <%@include file="footer.jsp"%> --%><%--不可以传参--%>
        <%--可以传参--%>
        <jsp:include page="footer.jsp">
            <jsp:param name="year" value="2017"/>
        </jsp:include>   
    </body>
</html>

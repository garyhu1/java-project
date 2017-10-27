<%--
  Created by IntelliJ IDEA.
  User: CJY
  Date: 2017/10/17
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>setContext</title>
    </head>
    <body>
        <%--
            page 对象即表示当前对象
            JSP 会被编译为一个Servlet类 ，运行的时候是一个Servlet实例。 page即代表this
        --%>
        <%
            /*表示一次请求。随着本次请求结束，其中的数据也就被回收。*/
            request.setAttribute("name","garyhu");
        %>
        <p>name为<%=request.getAttribute("name")%></p>
        <%--服务器跳转，相当于一次请求--%>
        <%--<jsp:forward page="getContext.jsp"/>--%>
        <%--客户端请求--%>
        <%response.sendRedirect("getContext.jsp");%>
    </body>
</html>

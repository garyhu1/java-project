<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/19
  Time: 14:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>登录</title>
        <script src="../js/jquery.min.js"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <script src="../js/bootstrap.min.js"></script>
        <style type="text/css">
            .my-btn {
                width: 300px;
                display: flex;
                flex-direction: row;
                justify-content: space-between;
            }
        </style>
        <script>
            $(function () {
                $("a").addClass("btn btn-default");
            });
        </script>
    </head>
    <body>
        <form method="post" role="form" style="width: 300px;margin: 44px auto;">
            <label for="name">账户名称 ： </label>
            <input type="text" class="form-control" name="name" id="name"/><br/>
            <label for="password">密码 ： </label>
            <input type="password" class="form-control" name="password" id="password"/><br/>
            <div class="my-btn">
                <button class="btn btn-default " formaction="login">登录</button>
                <button class="btn btn-default ">注册</button>
            </div>
        </form>
    </body>
</html>

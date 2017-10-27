<%--
  Created by IntelliJ IDEA.
  Author: garyhu
  Date: 2017/10/17
  Time: 15:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
    <head>
        <title>fn</title>
    </head>
    <body>
        <c:set var="name" value="jessical"/>
        <c:out value="${fn:substring(name,0 ,5 )}"/><br/>
        ${name}<br/>
        <c:set var="age" value="39" scope="page"/>
        <c:set var="age" value="45" scope="request"/>
        <c:set var="age" value="12" scope="session"/>
        <c:set var="age" value="67" scope="application"/>
        <%--优先级page>request>session>application--%>
        ${age}
    <%--
        fn:contains(string, substring)-->如果参数string中包含参数substring，返回true
        fn:containsIgnoreCase(string, substring)-->如果参数string中包含参数substring（忽略大小写），返回true
        fn:endsWith(string, suffix)-->如果参数 string 以参数suffix结尾，返回true
        fn:escapeXml(string)-->将有特殊意义的XML (和HTML)转换为对应的XML character entity code，并返回
        fn:indexOf(string, substring)-->返回参数substring在参数string中第一次出现的位置
        fn:join(array, separator)-->将一个给定的数组array用给定的间隔符separator串在一起，组成一个新的字符串并返回。
        fn:length(item)-->返回参数item中包含元素的数量。参数Item类型是数组、collection或者String。如果是String类型,返回值是String中的字符数。
        fn:replace(string, before, after)-->返回一个String对象。用参数after字符串替换参数string中所有出现参数before字符串的地方，并返回替换后的结果
        fn:split(string, separator)-->返回一个数组，以参数separator 为分割符分割参数string，分割后的每一部分就是数组的一个元素
        fn:startsWith(string, prefix)-->如果参数string以参数prefix开头，返回true
        fn:substring(string, begin, end)-->返回参数string部分字符串, 从参数begin开始到参数end位置，包括end位置的字符
        fn:substringAfter(string, substring)-->返回参数substring在参数string中后面的那一部分字符串
        fn:substringBefore(string, substring)-->返回参数substring在参数string中前面的那一部分字符串
        fn:toLowerCase(string)-->将参数string所有的字符变为小写，并将其返回
        fn:toUpperCase(string)-->将参数string所有的字符变为大写，并将其返回
        fn:trim(string)-->去除参数string 首尾的空格，并将其返回
    --%>
    </body>
</html>

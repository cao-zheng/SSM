<%--
  Created by IntelliJ IDEA.
  User: 政
  Date: 2018-11-8
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL国际化语言支持的标签--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
    <h1>国际化</h1>
    <fmt:message key="i18n.user"/><br><br>
    <fmt:message key="i18n.password"/><br><br>


<a href="i18n?locale=zh_CN"><fmt:message key="i18n.chinese"/></a>
<a href="i18n?locale=en_US"><fmt:message key="i18n.english"/></a>
</body>
</html>

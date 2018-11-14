<%--
  Created by IntelliJ IDEA.
  User: 政
  Date: 2018-11-14
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>404页面</title>
</head>
<body>
    <h1>404页面，您查找的资源丢失或者不存在</h1>
    <h3>请求地址：${pageContext.errorData.requestURI}</h3>
    <h3>状态码：${pageContext.errorData.statusCode}</h3>
    <h3>servlet名称：${pageContext.errorData.servletName}</h3>
</body>
</html>

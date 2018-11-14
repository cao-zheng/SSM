<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 政
  Date: 2018-11-12
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>单个文件上传</h1>
    <form action="/upload/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="multipartFile"/>
        <input type="submit" value="单个文件的上传"/>
    </form>
    <c:if test="${not empty requestScope.uploadFilePath}">
        <a href="${requestScope.uploadFilePath}">tempFileName</a>
    </c:if>
    <h3>多个文件上传</h3>
    <form action="upload/uploadFileBatch" method="post" enctype="multipart/form-data">
        <input type="file" name="multipartFiles" />
        <input type="file" name="multipartFiles" />
        <input type="file" name="multipartFiles" />
        <input type="submit" value="多个文件的上传" />
    </form>
    <h3>显示多个文件</h3>
    <c:if test="${uploadMap != null }">
        <c:forEach items="${ uploadMap }" var="item">
            <a href="${pageContext.request.contextPath}/upload/${item.value}">${item.key}</a>
            <img src="${pageContext.request.contextPath}/upload/${item.value}" width="200" />
        </c:forEach>
    </c:if>
</body>
</html>

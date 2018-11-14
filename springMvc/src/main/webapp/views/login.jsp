<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basepath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
    <h1>登录页面</h1>
    <form action="login" method="post">
        用户名：<input type="text" name="username"/><br/>
        密码：<<input type="text" name="password"/><br/>
        <<input type="submit" value="登录"/>
    </form>
</body>
</html>
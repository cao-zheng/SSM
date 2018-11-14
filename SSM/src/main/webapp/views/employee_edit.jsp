<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 政
  Date: 2018-11-4
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1: 为什么使用spring form标签?
	可以更快的开发表单页面，而且可以更方便的进行表单值的回显

	2:注意
	可以通过modelAttribute属性指定绑定的模型属性
	若没有指定该属性，则默认从request域对象中读取command的表单bean
	如果该属性值也不存在，则会发生错误
--%>
    <form:form action="${pageContext.request.contextPath}/emp" method="put" modelAttribute="employee">
        <form:hidden path="empId"/>
        员工姓名  :<form:input path="empName"/><br/>
        <font color="red"><form:errors path="empName"/></font><br/>
        员工性别  :男<form:radiobutton path="gender" value="男"/> 女<form:radiobutton path="gender" value="女"/><br/>
        <font color="red"><form:errors path="gender"/></font><br/>
        员工邮箱  :<form:input path="email"/><br/>
        <font color="red"><form:errors path="email"/></font><br/>
        员工工资  :<form:input path="salary"/><br/>
        <font color="red"><form:errors path="salary"/></font><br/>
        员工职务  :<form:input path="jobTitle"/><br/>
        <font color="red"><form:errors path="jobTitle"/></font><br/>
        员工部门  :<form:select path="deptId" items="${departments}" itemLabel="deptName" itemValue="deptId"/><br/>
        <font color="red"><form:errors path="deptId"/></font><br/>
        <input type="submit" value="保存">
    </form:form>
</body>
</html>

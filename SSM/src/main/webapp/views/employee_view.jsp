<%--
  Created by IntelliJ IDEA.
  User: 政
  Date: 2018-11-2
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" uri="/WEB-INF/page.tld"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="/webjars/jquery/3.2.1/dist/jquery.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SpringMVC String-Date转换器测试：
    <form:form action="/emp/test" method="post">
        <input type="text" name="date" value="">
        <input type="submit">
    </form:form>
    <a href="/emp">添加</a>
    <c:if test="${empty emps}">
        没有员工信息
    </c:if>
    <table>
        <tr>
            <td>员工姓名</td>
            <td>性别</td>
            <td>email</td>
            <td>收入</td>
            <td>职位</td>
            <td>入职时间</td>
            <td>部门</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:if test="${not empty emps}">
            <c:forEach items="${emps}" var="employee">
                <tr>
                    <td>${employee.empName}</td>
                    <td>${employee.gender}</td>
                    <td>${employee.email}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.jobTitle}</td>
                    <td>${employee.createDate}</td>
                    <td>${employee.dept.deptName}</td>
                    <td><a href="/emp/${employee.empId}">edit</a></td>
                    <td><a style="cursor: pointer;color:blue;text-decoration: underline;" onclick="del(${employee.empId})">delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <form id="deleteForm" action="" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
    <p:PageHelper url="/emps" pageNo="${emsPageNum}" pageSize="10" totalCount="${emsTotal}"/>
</body>
</html>
<script>
    function del(id){
        $("#deleteForm").attr("action","/emp/"+id).submit();
    }
</script>

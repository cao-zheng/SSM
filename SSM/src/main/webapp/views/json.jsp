<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Json示例</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsAndcss/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        function getButton(){
            //用ajax调用后端的查询api
            $.ajax({
                url:"${pageContext.request.contextPath}/json/emps/5",
                type:"get",
                data:{},
                dataType:"json",
                success:function(data){
                    var dataHtml ="";

                    if(data != null && data.obj != null && data.obj.length > 0){
                        for(var i=0;i<data.obj.length; i++){
                            dataHtml +="<p>编号 ：" + data.obj[i].empId +
                                "   员工姓名 ：" + data.obj[i].empName +
                                "   员工性别 ：" + data.obj[i].gender +
                                "   员工职务 ：" + data.obj[i].jobTitle + "<p><br>";
                        }
                    }
                    $(showDiv).append(dataHtml);
                },
                error:function(data){
                    $(showDiv).append("<p>查询出错了</p>");
                }
            })
        }

        function delButton(){
            //用ajax调用后端的删除api
            $.ajax({
                url:"${pageContext.request.contextPath}/json/emp/76",
                type:"post",
                data:{
                    _method:"DELETE"
                },
                dataType:"json",
                success:function(data){
                    $(showDiv).append("<p>删除成功 : " +data.msg+ "</p>");
                },
                error:function(data){
                    $(showDiv).append("<p>删除出错了</p>");
                }
            })
        }

        function updateButton(){
            //用ajax调用后端的修改api
            $.ajax({
                url:"${pageContext.request.contextPath}/json/emp",
                type:"post",
                data:{
                    _method:"PUT",
                    empId: 68,
                    empName:"Test修改",
                    gender: "女",
                    email: "er@126.com"
                },
                dataType:"json",
                success:function(data){
                    $(showDiv).append("<p>修改成功 : " +data.msg+ "</p>");
                },
                error:function(data){
                    $(showDiv).append("<p>修改出错了</p>");
                }
            })
        }

        function addButton(){
            //用ajax调用后端的添加api
            $.ajax({
                url:"${pageContext.request.contextPath}/json/emp",
                type:"post",
                data:{
                    empName:"Test添加",
                    gender: "女",
                    email: "add@126.com",
                    salary:13000,
                    jobTitle: "项目经理",
                    deptId:1004
                },
                dataType:"json",
                success:function(data){
                    $(showDiv).append("<p>添加成功 : " +data.msg+ "</p>");
                },
                error:function(data){
                    $(showDiv).append("<p>添加出错了</p>");
                }
            })
        }
    </script>
</head>
<body>
<h1>前端ajax调用Spring MVC JSON 的restful 的API</h1>
<br>

<input type="button" id="getbut" name="getBut" value="查询示例" onclick="getButton()">
<br><br>
<input type="button" id="deletebut" name="deletebut" value="删除示例" onclick="delButton()">
<br><br>

<input type="button" id="updatebut" name="updatebut" value="修改示例" onclick="updateButton()">
<br><br>

<input type="button" id="addbut" name="addbut" value="添加示例" onclick="addButton()">
<br><br>

<div id="showDiv"></div>

</body>
</html>
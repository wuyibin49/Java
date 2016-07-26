<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">@import "one.css"</style>
  </head>
  
  <body> <div class="page">
        <div class="header">
            <div id="title">
                 <h1><a href ="behind/adminhome.jsp">学生选课管理系统</a></h1>
                  <div align="right"><a href="behind/admin_info.jsp">${sessionScope.user.name}</a>，欢迎您! <a href="AdminAction!logout">注销</a></div>
            </div>
        </div>
        <div class="MainContainer">
            <div class="sidebar">
             	<div class="coursemanager">
             		<div >课程管理</div>             	
             		<a href="AdminAction!listcourse?index=1"">所有课程</a><br>             	
             		<a href ="behind/addcourse.jsp">新增课程</a>  <br>               		
             	</div>
             	<div class="studentmanager">
					<div>学生管理</div>
					<a href ="AdminAction!allstudents">所有学生</a><br>  
					<a href="behind/addstudent.jsp">新增学生</a><br>    
					
				</div>

            </div>
            <div  id="main" class="main">
		     <form action="AdminAction!updatecourse?course.id=${single.id}" method="post">
		     <input type="hidden" value="${single.id}">
		 	<table>
		 		<tr>
		 			<td colspan="2" align="center">修改课程</td>
		 		</tr>
		 		
		 		<tr>
		 		<td align="center">课程号</td>
		 		<td align="center"><input type="text" name ="course.cnumber" value="${single.cnumber}" size="40"></td>
		 		</tr>
		 		<tr>
				 	<td align="center">课程名称</td>
		 			<td align="center"><input type="text" name="course.name" value="${single.name}" size="40"></td>
		 		</tr>
		 		<tr>
			 		<td align="center"> 课时</td>
		 			<td align="center"><input type = "text" name ="course.lessonhours" value="${single.lessonhours}" size="40"></td>
		 		</tr>
		 		<tr>
			 		<td align="center">学分</td>
			 		<td align="center"><input type="text" name ="course.lessonpoints" value="${single.lessonpoints}" size="40"></td>
		 		</tr>
		 		
		 		<tr>
			 		<td colspan="2" align="center"><input type="submit"  value = "修改课程"><br></td>
		 		</tr>
		 		
		 	</table>
		</form>
  </div>           
        </div>
    </div>
       
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="one.css">
	

  
  <body>	
    	 <div class="page">
        <div class="header">
            <div id="title">
                <div>   <h1><a href ="front/userhome.jsp">学生选课管理系统</a></h1></div>
                <div align="right"><a href="behind/admin_info.jsp">${sessionScope.user.name}</a>，欢迎您！ <a href="StudentAction!logout">注销</a></div>
            </div>
        </div>
        <div class="MainContainer">
            <div class="sidebar">
             	<div class="coursemanager">
             		<div >课程管理</div>             	
             		<a href="CourseAction!findallcourse">选课</a><br>       	
             		<a href = "StudentAction!selectedcou">已选课程</a><br>                 		
             	</div>             	
            </div>
            <div  id="main" class="main">
               	<table width="80%" border="1">
               			<tr>
               				<td colspan="5" align="center">已选课程</td>
               			</tr>
						<tr>
								<td>课程号</td>
								<td>课程名称</td>
								<td>课时</td>
								<td>学分</td>
								<td>删除</td>
						</tr>
						<s:iterator value="#session.set"  id="set">
							<tr> 
							<td><s:property value="#set.cnumber"/></td>
							<td><s:property value="#set.name"/></td>
							<td><s:property value="#set.lessonhours"/></td>
							<td><s:property value="#set.lessonpoints"/></td>
							<td><s:a action="StudentAction!deletecourse?course.id=%{#set.id}">delete</s:a></td>
							</tr>
						</s:iterator>
				</table>
            </div>           
        </div>
    </div>
  <!-- 
  <h2 > <a href="front/userhome.jsp">学生选课</a></h2><h2 > <a href="StudentAction4!logout">注销</a></h2>
	<h3>已选课程</h3>
	<table width="80%" border="1">
	<tr>
			<td>课程号</td>
			<td>课程名称</td>
			<td>课时</td>
			<td>学分</td>
			<td>删除</td>
	</tr>
	<s:iterator value="#session.set"  id="set">
		<tr> 
		<td><s:property value="#set.cnumber"/></td>
		<td><s:property value="#set.name"/></td>
		<td><s:property value="#set.lessonhours"/></td>
		<td><s:property value="#set.lessonpoints"/></td>
		<td><s:a action="StudentAction2!deletecourse?course.id=%{#set.id}">delete</s:a></td>
		</tr>
	</s:iterator>
	</table>
	 -->
  </body>
</html>

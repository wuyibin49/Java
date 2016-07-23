<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<link rel="stylesheet" type="text/css" href="one.css">
	
  </head>
  
  <body>
    	 <div class="page">
        <div class="header">
            <div id="title">
                <div>   <h1><a href ="front/userhome.jsp">学生选课管理系统</a></h1></div>
                <div align="right"><a href="behind/admin_info.jsp">${sessionScope.user.name}</a>，欢迎您！ <a href="StudentAction4!logout">注销</a></div>
            </div>
        </div>
        <div class="MainContainer">
            <div class="sidebar">
             	<div class="coursemanager">
             		<div >课程管理</div>             	
             		<a href="listcourse">选课</a><br>             	
             		<a href = "StudentAction3!selectedcou">已选课程</a><br>               		
             	</div>             	
            </div>
            <div  id="main" class="main">
                 <table width="80%" border="1">
                 		<tr>
                 			<td colspan="5" align="center">课程列表</td>
                 		</tr>
						<tr>
								<td>课程号</td>
								<td>课程名称</td>
								<td>课时</td>
								<td>学分</td>
								<td>选课</td>
						</tr>
						<s:iterator value="#request.list"  id="list">
							<tr> 
							<td><s:property value="#list.cnumber"/></td>
							<td><s:property value="#list.name"/></td>
							<td><s:property value="#list.lessonhours"/></td>
							<td><s:property value="#list.lessonpoints"/></td>
							<s:hidden value="#list.id"></s:hidden>
							<td><s:a href="StudentAction1!selectcourse?course.id=%{#list.id}">选课</s:a></td>
							</tr>
						</s:iterator>
				</table>
            </div>           
        </div>
    </div>
    <!-- 
 <a href="StudentAction4!logout">注销</a>
  	<h3>课程</h3>
  	<s:a action="listcourse">所有课程</s:a>
   <table width="80%" border="1">
	<tr>
			<td>课程号</td>
			<td>课程名称</td>
			<td>课时</td>
			<td>学分</td>
			<td>选课</td>
	</tr>
	<s:iterator value="#request.list"  id="list">
		<tr> 
		<td><s:property value="#list.cnumber"/></td>
		<td><s:property value="#list.name"/></td>
		<td><s:property value="#list.lessonhours"/></td>
		<td><s:property value="#list.lessonpoints"/></td>
		<s:hidden value="#list.id"></s:hidden>
		<td><s:a href="StudentAction1!selectcourse?course.id=%{#list.id}">选课</s:a></td>
		</tr>
	</s:iterator>
	</table>
	 -->
  </body>
</html>

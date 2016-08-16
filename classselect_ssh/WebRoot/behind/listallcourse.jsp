<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">@import "one.css"</style>
  
  <body>	

	   <div class="page">
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
             		<a href="AdminAction!searchcourse?index=1"">所有课程</a><br>             	
             		<a href ="behind/addcourse.jsp">新增课程</a>  <br>               		
             	</div>
             	<div class="studentmanager">
					<div>学生管理</div>
					<a href ="AdminAction!allstudents">所有学生</a><br>  
					<a href="behind/addstudent.jsp">新增学生</a><br>    
					
				</div>

            </div>
            <div  id="main" class="main">
            <div>
            	<form action="AdminAction!searchcourse">
            		课程名：<input type="text" name="course.name" >
	            	课程号：<input type="text" name="course.cnumber">
	            	学分：<input type="text"  name="course.lessonpoints">
	            	<input type="submit" value="搜索">
            	</form>
            </div>
				<table >
					<tr class="tabletitle">
						<td>课程号</td>
						<td>课程名称</td>
						<td>课时</td>
				   		<td>学分</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<s:iterator value="#request.alllist"  id="list">
					<tr> 
						<td><s:property value="#list.cnumber"/></td>
						<td><s:property value="#list.name"/></td>
						<td><s:property value="#list.lessonhours"/></td>
						<td><s:property value="#list.lessonpoints"/></td>
						<td> <s:a href="CourseAction!getsinglecourse?course.id=%{#list.id}">修改</s:a></td>
						<td><s:a action="AdminAction!delete?course.id=%{#list.id}">删除</s:a></td>
					</tr>
					</s:iterator>
				</table>
				<ul style="margin-left: 35%;">
				<li style="display: inline;">
				<span style="font-size: 20px;">第${currentpage}/${count}共</span>
				<a href="AdminAction!listcourse?index=1" style="font-size: 25px;">首页</a>
				<c:if test="${currentpage-1>0}">
				<a href="AdminAction!listcourse?index=${currentpage-1}" style="font-size: 25px;">上一页</a>
				</c:if>
				</li>
				<li style="display: inline;">
				<c:set var="pageCount" value="${count}"/>
				
					<c:forEach var="i" begin="1" step="1" end="${pageCount}">
						<a href="AdminAction!listcourse?index=${i}"  style="font-size: 25px;"><c:out value="${i}"></c:out></a>
					</c:forEach>
				</li>
				<li style="display: inline;">
				<c:if test="${currentpage<pageCount}">
				<a href="AdminAction!listcourse?index=${currentpage+1}" style="font-size: 25px;">下一页</a></c:if>
				<a href="AdminAction!listcourse?index=${pageCount}" style="font-size: 25px;">尾页</a>
				</li>
				<li style="display: inline;">
				<form action="" style="display: inline;font-size: 20px;"><span>第<input type="text" name="index" size="1">页</span><input type="submit" value="GO"></form>
				</li>
				
				</ul>
	           </div>           
        </div>
    </div>
  </body>
</html>

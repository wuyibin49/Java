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
	
	<link rel="stylesheet" type="text/css" href="one.css">
	

  
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
             		<a href="AdminAction!listcourse">所有课程</a><br>             	
             		<a href ="behind/addcourse.jsp">新增课程</a>  <br>               		
             	</div>
             	<div class="studentmanager">
					<div>学生管理</div>
					<a href ="AdminAction!allstudents">所有学生</a><br>  
					<a href="behind/addstudent.jsp">新增学生</a><br>    
					
				</div>
				 </div>
            <div  id="main" class="main">
				<table width="80%" border="1">
					<tr><td colspan="5" align="center">所有学生信息</td></tr>
					<tr>
							<td>学号</td>
							<td>姓名</td>
							<td>年龄</td>
							<td>生日</td>
							<td>删除</td>
					</tr>
					<s:iterator value="#request.students"  id="list">
						<tr> 
						<td><s:property value="#list.snumber"/></td>
						<td><s:property value="#list.name"/></td>
						<td><s:property value="#list.age"/></td>
						<td><s:property value="#list.birthday"/></td>
						<td><s:a action="AdminAction!deletestudent?student.id=%{#list.id}">delete</s:a></td>
						</tr>
					</s:iterator>
					</table>
				<ul style="margin-left: 35%">
					<li style="display: inline;">
						第${currentpage}/${count}共
						<a href="AdminAction!allstudents?index=1" style="font-size: 25px;">首页</a>
						<c:if test="${currentpage>1}">
							<a href="AdminAction!allstudents?index=${currentpage-1}" style="font-size: 25px;">上一页</a>
						</c:if>						
						<c:forEach var="i" step="1" begin="1" end="${count}">
							<a href="AdminAction!allstudents?index=${i}" style="font-size: 25px;">${i}</a>
						</c:forEach>
						<c:if test="${currentpage<count}">
							<a href="AdminAction!allstudents?index=${currentpage+1}" style="font-size: 25px;">下一页</a>
						</c:if>
						<a href="AdminAction!allstudents?index=${count}" style="font-size: 25px;">尾页</a>
					</li>
					<li style="display: inline;">
						<form action="AdminAction!allstudents" style="display: inline;">
							<span>第</span>
							<input type="text" name="index" size="1">
							<span>页</span>
							<input type="submit" value="GO"> 
						</form>
					</li>
				</ul>
	           </div>           
        </div>
    </div>
	
	
  </body>
</html>

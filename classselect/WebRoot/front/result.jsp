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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  
  <body>	
	
	<table width="80%" border="1">
	<tr>
			<td>课程号</td>
			<td>课程名称</td>
			<td>课时</td>
			<td>学分</td>
			<td>删除</td>
	</tr>
	<s:iterator value="#request.list"  id="list">
		<tr> 
		<td><s:property value="#list.cnumber"/></td>
		<td><s:property value="#list.name"/></td>
		<td><s:property value="#list.lessonhours"/></td>
		<td><s:property value="#list.lessonpoints"/></td>
		<td><s:a action="AdminAction!deletecourse?course.id"/>delete</td>
		</tr>
	</s:iterator>
	</table>

  </body>
</html>

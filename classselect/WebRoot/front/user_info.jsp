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
  <h2 > <a href="front/userhome.jsp">学生选课</a></h2><h2 > <a href="StudentAction4!logout">注销</a></h2>
	用户名: <s:property value="#session.student.name"/><br>
	密码: <s:property value="%{#session.student.password}"/><br>
	学号:<s:property value="#session.student.snumber"/><br>
	年龄:<s:property value="#session.student.age"/><br>
	选课:<s:property value="#session.student.courses[0].cnumber"/><br>

  </body>
</html>

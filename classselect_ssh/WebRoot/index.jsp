<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body >
  	<div id="backgroundpic" style="position: absolute;z-index: -1"><img src="pic/死神.jpg" height="100%" width="100%"/></div>
  	<h2><font color="white" style="font: strong">学生选课系统</font></h2>
  	<div style="position: relative;left:45%;top: 50%">
   	<a href="login.jsp"  ><font color="white">普通用户登录</font> </a>
   	<a href="adminlogin.jsp"><font color="white">管理员登录</font></a>
	<a href="register.jsp"><font color="white">注册</font></a>
	</div>
	<!-- 
	<a href = "courses.jsp">课程</a>
	<a href  ="front/addcourse.jsp">添加课程</a>
   -->
  </body>
</html>

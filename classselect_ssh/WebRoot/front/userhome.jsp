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
	
	<link rel="stylesheet" type="text/css" href="one.css">

	
  </head>
  
  <body>
  	 <div class="page">
        <div class="header">
            <div id="title">
                <div>   <h1><a href ="front/userhome.jsp">学生选课管理系统</a></h1></div>
                <div align="right"><a href="front/user_info.jsp">${sessionScope.user.name}</a>，欢迎您！ <a href="StudentAction!logout">注销</a></div>
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
                <img alt="failed" src="pic/dead.png">
            </div>           
        </div>
    </div>
    <!-- 
   	<h2 > <a href="front/userhome.jsp">学生选课</a></h2><h2 > <a href="StudentAction4!logout">注销</a></h2>
   	<a href="front/selectcourses.jsp">选课</a>
  
   	<a href = "StudentAction3!selectedcou">已选课程</a>
   	<a href = "front/user_info.jsp">个人信息</a>
 -->
  </body>

  </body>
</html>


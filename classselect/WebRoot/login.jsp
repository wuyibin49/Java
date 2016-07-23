<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML>
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

  </head>
  
  <body>
  <div style="position: absolute;z-index: -1;width: 100%;height: 100%;" ><img src="pic/死神.jpg" ></div>
  <div >
 		<form action="login" method="post">
 		<table   style="position:fixed;top: 38%;left: 46%;background-color: grey" >
 		<tr><td align="center" colspan="2" style="color: white;font-size: 20px">用户登录</td></tr>
 			<tr>
				<td align="center"><input type="radio"  name="type"  value="普通用户" checked="checked"><font color="white" size="1px">普通用户</font><input type="radio"  name="type"  value="管理员"><font color="white" size="1px">管理员</font>
				</td>
			</tr>
 			
 			<tr >
 				<!--  <td style="color: white">用户名:</td>-->
 				<td ><input type="text"  name = "name" maxlength="20" size="22"  style="height: 30px" placeholder="请输入用户名"></td>
 			</tr>
 			<tr>
 					<!--<td style="color: white" >密&nbsp;码:</td>-->
 				<td><input type="password" name ="password" maxlength="20" size="22" style="height: 30px" placeholder="请输入密码"></td>
 			</tr>
 			<tr>
 				<td colspan="2" align="center"><input type="submit" value ="登录" style="height: 30px;width: 100%"></td>
 			</tr>
 		</table>
 		</form>
	 </div>
 <!-- 
  <font  style="" color="white" >普通用户登录</font>
  <form action="login" method="post">
  	<font color="white">用户名:</font><input type="text" name = "name"><br>
  	<font color="white">密&nbsp;码:</font><input type="password" name ="password"><br>
  	<input type="submit" value ="login"><br>
  </form>
 -->
  
  </body>
</html>

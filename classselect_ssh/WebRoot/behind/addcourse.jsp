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
	<style type="text/css">@import "one.css"</style>
	<script type="text/javascript">
		function checkcourse(){
			
		}
		
	</script>
  </head>
 

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
             		<a href="AdminAction!searchcourse?index=1">所有课程</a><br>             	
             		<a href ="behind/addcourse.jsp">新增课程</a>  <br>               		
             	</div>
             	<div class="studentmanager">
					<div>学生管理</div>
					<a href ="AdminAction!allstudents">所有学生</a><br>  
					<a href="behind/addstudent.jsp">新增学生</a><br>    
					
				</div>

            </div>
            <div  id="main" class="main">
            
			<form action="CourseAction!addcourse" method="post">
				<table >
						<tr><td colspan="2" align="center">新增课程</td></tr>
						 <tr> 
						 <td width="150px" align="center">课 程 号</td>
						 <td align="center"><input type="text" name ="cnumber" size="40"></td>
						 </tr>
						  <tr>
						  <td width="150px" align="center">课程名称</td>
						  <td align="center"><input type="text" name="name" size="40"></td>
						  </tr>
						  <tr>
						   <td width="150px" align="center">课&nbsp;&nbsp;时 </td>
						 <td align="center">  <input type = "text" name ="lessonhours" size="40"> </td>
						  </tr>
						  <tr>
						 <td width="150px" align="center">学&nbsp;&nbsp;分</td>
						 <td align="center"> <input type="text" name ="lessonpoints" size="40"> </td>
						  </tr>
						   <tr >
						  <td colspan="2" align="center">  <input type="submit"  value = "新增课程" > </td> 
						   </tr>
					</table>
				 </form> 
            </div>           
        </div>
    </div>
       
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  ${message }
  	<form action = "${pageContext.request.contextPath }/servlet/LoginServlet" method = "post">
    	用户名：<input type = "text" name = "username">
    	<select>
    		<option name = "flag" value = "0">管理员</option>
    		<option name = "flag" value = "1">普通会员</option>
    		 
    	</select><br/>
    	密码：<input type = "password" name = "password"><br/>
    	<input type = "submit" value = "登录">
   </form>
  </body>
</html>

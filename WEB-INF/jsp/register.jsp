<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <form action = "${pageContext.request.contextPath}/servlet/RegisterServlet" method = "post">
    	用户名：<input type = "text" name = "username"> 
    	
    	${form.errors.username }<br/>
    	密码：<input type = "password" name = "password">${form.errors.password }<br/>
    	确认密码：<input type = "password" name = "password2">${form.errors.password2 }<br/>
    	email:<input type = "text" name = "email">${form.errors.email }<br/>
    	
    	图片验证：<input  type="text" name="client_checkcode">
						<img src="${pageContext.request.contextPath }/servlet/ImageServlet" height="25px" width="120px" alt="看不清" style="cursor: hand;" onclick="location.href='${pageContext.request.contextPath}/servlet/RegisterUIServlet'">
    	<input type = "submit">
    </form>
  </body>
</html>

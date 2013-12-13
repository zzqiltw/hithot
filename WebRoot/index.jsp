<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
	<title>工大热点</title>
  </head>
  
  <body>
	
	<c:if test="${user!=null }">
  	欢迎您：${user.username }
  	您的邮箱是：${user.email }
  	<a href = "${pageContext.request.contextPath}/servlet/LogoutServlet">Logout</a>
  <br/>
	</c:if>
	<c:if test="${user == null }">
    <a href = "${pageContext.request.contextPath}/servlet/Register">Register</a>
    <a href = "${pageContext.request.contextPath}/servlet/Login">Login</a>
	</c:if>
   <hr/>
   
<c:if test="${user!=null }">
   <a href = "${pageContext.request.contextPath }/servlet/Post">发布一个热点</a>
</c:if>
   <a href = "${pageContext.request.contextPath }/servlet/ViewServlet">查看热点</a><br/>
   <a href = "${pageContext.request.contextPath }/servlet/ViewTodayHIT">查看今日哈工大的新闻</a>
  </body>
</html>

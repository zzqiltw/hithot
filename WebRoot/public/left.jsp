<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  <c:if test="${user!=null }">
  	欢迎您：${user.username }
  	您的邮箱是：${user.email }
  	<a href="${pageContext.request.contextPath}/servlet/LogoutServlet" >Logout</a>
		<br />
	</c:if>
	<c:if test="${user == null }">
		<a href="${pageContext.request.contextPath}/servlet/Register" target = "main">Register</a>
		<a href="${pageContext.request.contextPath}/servlet/Login" target = "main">Login</a>
	</c:if>
	<hr/>
 	<c:if test="${user!=null }">
		<a href="${pageContext.request.contextPath }/servlet/Post" target = "main">发布一个热点</a>
	</c:if>
	<a href="${pageContext.request.contextPath }/servlet/ViewServlet" target = "main">查看热点</a>
	<br />
	<a href="${pageContext.request.contextPath }/servlet/ViewTodayHIT" target = "main">查看今日哈工大的新闻</a>

  </body>
</html>

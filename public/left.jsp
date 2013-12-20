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
		<br />
		<a href="${pageContext.request.contextPath }/servlet/PostImage?method=postui" target = "main">发布一个图片热点</a>
		<br />
	</c:if>
	<br/>
	<a href="${pageContext.request.contextPath }/servlet/ViewServlet" target = "main">查看热点</a>
	<br />
	<a href="${pageContext.request.contextPath }/servlet/PostImage?method=list" target = "main">查看图片热点</a>
		<br />
			<br />
	<a href="${pageContext.request.contextPath }/servlet/ViewTodayHIT" target = "main">查看今日哈工大的新闻</a>
	<br/>
		<br />
	<c:if test="${!empty(admin)}">
		<a href="${pageContext.request.contextPath }/dbbak.jsp"  target="main">数据库备份</a><br/>
	
	    <a href="${pageContext.request.contextPath }/servlet/DbServlet?method=list"  target="main">数据库恢复</a><br/>
	</c:if>
  </body>
</html>

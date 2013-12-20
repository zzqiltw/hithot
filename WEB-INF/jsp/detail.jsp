<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>热点详情</title>
  </head>
  <body>
 		${point.title } <br/>
 		<hr/>
    	作者：${point.author } <br/>
    	时间：${point.postTime }<br/>
    	${point.text }<br/>
    	<c:if test="${!empty(admin) || point.author == user.username}">
    		<a href = "${pageContext.request.contextPath }/servlet/DeletePoint?id=${point.id}">删除</a>
    		<a href = "${pageContext.request.contextPath }/servlet/EditPoint?id=${point.id}">编辑</a>
    	</c:if>
  </body>
</html>

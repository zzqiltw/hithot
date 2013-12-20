<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
  搜索结果为：
	<c:forEach var = "p" items = "${list }">
		<hr/>
    	标题：<a href = "${pageContext.request.contextPath }/servlet/Detail?id=${p.id}">${p.title }</a><br/>
    	作者：${p.author }<br/>
    	时间：${p.postTime }<br/>
    	<c:if test="${!empty(admin) || p.author == user.username}">
    		<a href = "${pageContext.request.contextPath }/servlet/DeletePoint?id=${p.id}">删除</a>
    		<a href = "${pageContext.request.contextPath }/servlet/EditPoint?id=${p.id}">编辑</a>
    	</c:if>
	</c:forEach>
  </body>
</html>

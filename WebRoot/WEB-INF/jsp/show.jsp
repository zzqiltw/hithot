<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import = "domain.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>show</title>
  </head>
  <body>
  
   <c:forEach var = "item" items = "${list}">
   		<hr/>
    	标题：<a href = "${pageContext.request.contextPath }/servlet/Detail?id=${item.id}">${item.title }</a><br/>
    	作者：${item.author }<br/>
    	时间：${item.postTime }<br/>
    	热点内容：${item.text }<br/>
    	<c:if test="${!empty(admin) || item.author == user.username}">
    		<a href = "${pageContext.request.contextPath }/servlet/DeletePoint?id=${item.id}">删除</a>
    		<a href = "${pageContext.request.contextPath }/servlet/EditPoint?id=${item.id}">编辑</a>
    	</c:if>
    </c:forEach>
     <a href = "${pageContext.request.contextPath }/index.jsp">返回首页</a>
  </body>
</html>

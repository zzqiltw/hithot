<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>工大热点</title>
</head>

<frameset rows="22%,*">
	<frame src="${pageContext.request.contextPath}/public/head.jsp" name="head">
	<frameset cols="25%,*">
		<frame src="${pageContext.request.contextPath }/public/left.jsp">
		<frame src="" name="main">
	</frameset>
</frameset>
	
	
</html>

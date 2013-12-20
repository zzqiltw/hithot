<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
</head>
<body style="text-align: center">
	<br />
	<br />

	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
		<caption>
			<h2>图片热点信息</h2>
		</caption>
		<tr>
			<td>作者</td>
			<td>图片名称</td>
			<td>图片</td>
			<td>描述</td>
		</tr>

		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.author }</td>
				<td>${i.description }</td>
					<c:url var="url" value="/images/${i.image}">
					</c:url>
				<td>
					<a href="${url }">查看图片</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />


</body>
</html>


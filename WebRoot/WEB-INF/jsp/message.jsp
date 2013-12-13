<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>消息提示</title>
  </head>
  <body>
    ${message }
    
    <a href = "${pageContext.request.contextPath }/index.jsp">返回首页</a>
<!--     三秒之后自动返回 -->
<!--    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath }/index.jsp"/> -->
  </body>
</html>

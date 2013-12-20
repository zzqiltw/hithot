<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Post</title>
  </head>
  <body>
     <form action = "${pageContext.request.contextPath }/servlet/PostServlet" method = "post">
     	标题：<input type = "text" name = "title"> <br/>
     	内容: <textarea name =  "text" cols = "100" rows = "20" ></textarea>
     	<input type = "submit" value = "发表">
     </form>
      <a href = "${pageContext.request.contextPath }/servlet/ViewServlet">查看热点</a>
      <a href = "${pageContext.request.contextPath }/index.jsp">返回首页</a>
  </body>
</html>

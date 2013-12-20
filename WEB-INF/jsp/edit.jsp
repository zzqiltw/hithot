<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Edit</title>
  </head>
  <body>
     <form action = "${pageContext.request.contextPath }/servlet/EditPoint" method = "post">
     	<input type = "hidden" name = "id" value = "${point.id }">
     	<input type = "hidden" name = "author" value = "${point.author }">
     	标题：<input type = "text" name = "title" value = "${point.title }"> <br/>
     	内容: <textarea name =  "text" cols = "20" rows = "20" >${point.text}</textarea>
     	<input type = "submit" value = "提交编辑">
     </form>
      <a href = "${pageContext.request.contextPath }/servlet/ViewServlet">查看热点</a>
      <a href = "${pageContext.request.contextPath }/index.jsp">返回首页</a>
  </body>
</html>

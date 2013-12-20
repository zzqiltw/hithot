<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
  </head>
  <body>
	 <form action = "${pageContext.request.contextPath }/servlet/PostImage?method=add" method = "post" enctype = "multipart/form-data">
	 	<input type = "hidden" name = "author" value = "${user.username }">
	 	图片: <input type = "file" name = "image"><br/>
	 	图片名称：<input type = "text" name = "name"><br/>
	 	描述:<input type = "text" name = "description"><br/>
	 	<input type = "submit" value = "发布">
 	 </form>
  </body>
</html>

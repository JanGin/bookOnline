<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/manage/CategoryServlet?method=add" method="post">
    	分类名称:<input type="text" name="name"/><br><br>
    	分类描述:<textarea rows="5" cols="40" name="description"></textarea><br><br>
    	<input type="submit" value="确定"/> 
    </form>
  </body>
</html>

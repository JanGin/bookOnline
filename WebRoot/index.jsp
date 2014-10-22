<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>书屋首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
 
    
    <frameset rows="20%,*">
    	<frame src="${pageContext.request.contextPath }/clientJSP/head.jsp" name="head">
    	<frame src="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" name="body">
    </frameset> 
   
</html>

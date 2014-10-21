<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   
  
    <frameset rows="20%,*">
    	<frame src="${pageContext.request.contextPath }/manageJSP/head.jsp " name="head">
    
	    <frameset cols="15%,*">
	    	<frame src="${pageContext.request.contextPath }/manageJSP/left.jsp" name="left">
	    	<frame src="${pageContext.request.contextPath }/manageJSP/body.jsp" name="body">
	    </frameset>
   </frameset>
  
</html>

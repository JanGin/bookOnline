<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>分类信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  

  <body bgcolor="lawngreen" style="text-align: center;">
    
    <br/><br/>
    <h2>分类信息</h2>
    <table border=1 width="60%">
    	<tr>
    		<td>分类名称</td>
    		<td>分类描述</td>
    		<td>操作</td>
    	</tr>
    	
    	 <c:forEach items="${category }" var="list">
		   
		    <tr>
		    <td>${list.name }</td>
		    <td>${list.description }</td>
		    <td>
	    		<a href="">删除</a>
	    		<a href="">修改</a>
	    	</td>
	    	</tr>
		  </c:forEach>
    	
    </table>
  </body>
</html>

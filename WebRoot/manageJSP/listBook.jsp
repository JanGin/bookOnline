<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">
   		#table_{
   			table_layout:auto;
   		}
 
   </style>
    
    <title>查看图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body style="text-align: center;" bgcolor="lawngreen">
    	<table border=1 width="60%" id="table_">
    		<tr>
    			<td>书名</td>
    			<td>作者</td>
    			<td>描述</td>
    			<td>图片</td>
    			<td>售价</td>
				<td>操作</td>
    		</tr>
    		<c:forEach var="book" items="${page.list }">
    			<tr>   		
	    			<td>${book.name }</td>
	    			<td>${book.author }</td>
	    			<td>${book.description }</td>
	    			<td><a href="${pageContext.request.contextPath }/images/${book.image}">查看图片</a></td>
	    			<td>${book.price }</td>
	    			<td><a href="javascript:void(0)">操作</a></td>  	
    			</tr>		 
    		</c:forEach>
    		
    	</table><br>
    	当前第${page.pageNum }页
    	&nbsp; &nbsp;
    
 	   <c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
    	[<a href="${pageContext.request.contextPath }/manage/BookServlet?method=listBook&pageNum=${pageNum }">${pageNum }</a>]
  	   </c:forEach>
       &nbsp; &nbsp;
 	          总共[${page.pageTotal }]页，总[${page.totalRecord }]记录
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
    	#div_1{
    		width:1400px;
    		height:750px;
    	}
    </style>
    <title>书屋首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
  <body style="text-align: center;">
   		<div id="div_1"  style="background-image: url('${pageContext.request.contextPath}/images/2.jpg');">
   			<div id="category" style="float: left;width: 200px;border: 1px solid powderblue;text-align: left;height: 300px;margin-left: 150px">
   				分类列表:<br>
   				<ul>
   					<c:forEach items="${category }" var="category">		
   						<li><a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBookWithCategory&category_id=${category.id }">
   							${category.name }
   							</a>
   						</li>
     				</c:forEach>
   				</ul>
   			</div>
   			<div>
   				<div id="bookANDinfo" style="float: left;margin-left: 100px">
   					<div id="books">
   						<c:forEach var="book" items="${page.list}">
    					<div id="book">
	    					<div id="image" style="float: left">
	    						<img src="${pageContext.request.contextPath }/images/${book.image }" width="83px" height="118px">
	    					</div>
	    					
    						<div id="info" style="float:left;text-align: left;">
    							<ul>
    								<li>书名:${book.name }</li>
    								<li>作者:${book.author }</li>
    								<li>售价:${book.price }</li>
    								<li>
    									<a href="${pageContext.request.contextPath }/client/PurchaseServlet?bookid=${book.id }">购买</a>
    								</li>
    							</ul>
    						</div>
    					</div>
    					<div style="clear: both"></div>
    					<br/>
    				
    				</c:forEach>
   				</div>
   					
   			</div>
   			
   			</div>
   			<div style="clear: both"></div>
   			<div id="page">
   				当前第[${page.pageNum }]页 &nbsp; &nbsp;
    
			    <c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
			    	[<a href="${pageContext.request.contextPath }/client/IndexServlet?pageNum=${pageNum }&category_id=${param.category_id }&method=${param.method }">${pageNum }</a>]
			    </c:forEach>
			    &nbsp; &nbsp;
				    总共[${page.pageTotal }]页，总[${page.totalRecord }]记录
   			</div>
   		</div>
  </body>
</html>

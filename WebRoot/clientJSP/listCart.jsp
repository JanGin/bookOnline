<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<script type="text/javascript">
	
		function emptyCart(){
			var bool = window.confirm("你确定要删除该项么?");
			if (bool){
				window.location.href="${pageContext.request.contextPath }/client/ClearCartServlet";
			}
		}
	
	</script>
	
  </head>
  
  <body style="text-align: center;">
 	<h2> <font color="red">购物车</font></h2><br><br>
 	
    <table border=1 width="80%">
    	<tr>
    		<td>书名</td>
    		<td>作者</td>
    		<td>单价</td>
    		<td>数量</td>   		
    		<td>小计</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach var="map" items="${cart.map }">
	    	<tr>
	    		<td>${map.value.book.name }</td>
	    		<td>${map.value.book.author }</td>
	    		<td>${map.value.book.price }</td>
	    		<td>${map.value.quantity}</td>
	    		<td>${map.value.price}</td>
	    		<!-- 
	    		<td><a href="javascript:deleteBook()">删除</a></td>
	    		 -->
	    		 <td><a href="${pageContext.request.contextPath }/client/DeleteCartItemServlet?bookid=${map.value.book.id}">删除</a></td>
	    	</tr>
    	</c:forEach>
    	
    	<tr>
    		<th colspan="3">总计</th>
    		<th colspan="2">${cart.price }</th>
    		<th><a href="javascript:emptyCart()"><font color="gold">清空购物车</font></a></th>
    	</tr>
    </table>
    <a href="${pageContext.request.contextPath }/client/OrderServlet"><font color="crimson">生成订单</font></a>
  	
  	
  </body>
</html>

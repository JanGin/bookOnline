<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body style="text-align: center;"bgcolor="lawngreen">
    <table border=1 width="70%">
    	<tr>
    		<td>订单号</td>
    		<td>客户</td>
    		<td>下单时间</td>
    		<td>订单状态</td>
    		<td>操作</td>
    	</tr>
    	<c:forEach items="${order }" var="order">
	    	<tr>
	    		<td>${order.id }</td>
	    		<td>${order.user.username }</td>
	    		<td>${order.ordertime }</td>
	    		<td>${order.state == true?'已发货':'未发货' }</td>
	    		<td>
					<a href="${pageContext.request.contextPath }/manage/OrderDetailServlet?orderid=${order.id}">详情</a>
				</td>
	    	</tr>
    	</c:forEach>
    </table>
    
  </body>
</html>

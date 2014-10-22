<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style type="text/css">
  		#form{
  			float:left;
  		}
  	
  	</style>
    
    <title>订单详情显示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body style="text-align: center;" bgcolor="lawngreen"> 
  <h3><font color="">订单详情</font></h3>
    	<table border=1 width="70%">
	    	<tr>
	    		<td>书名</td>
	    		<td>售价</td>
	    		<td>数量</td>
	    		<td>应收货款</td>
	    	</tr>
	    	<c:forEach var="item" items="${order.set }" >
	    		<tr>
	    			<td>${item.book.name}</td>
	    			<td>${item.book.price }</td>
	    			<td>${item.quantity }</td>
	    			<td>${item.price }</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="3">总计</th>
				<th>${order.price }元</th>
			</tr>
    	</table>
    	<br><br>
    	<h3><font color="">收货人信息</font></h3>
    	<table border=1 width="70%">
    		<tr>
	    		<td>用户</td>
	    		<td>电话</td>
	    		<td>地址</td>
	    		<td>手机</td>
	    		<td>邮箱</td>
    		</tr>
    		<tr>
    			<td>${order.user.username }</td>
	    		<td>${order.user.phone }</td>
	    		<td>${order.user.address }</td>
	    		<td>${order.user.cellphone }</td>
	    		<td>${order.user.email }</td>
    		</tr>
    	
    	</table>
    	<br><br><br>
    	<form id="form" action="${pageContext.request.contextPath }/manage/ConfirmGoodsServlet?orderid=${order.id}" method="post">
    		<input type="submit" value="确认发货">
    	</form>
  </body>
</html>

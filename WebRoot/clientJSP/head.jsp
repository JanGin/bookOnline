<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<style type="text/css">
		#headline{
			font-style:oblique;
			font-size:30px;
		}
		#a1{
			
		}
	</style>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body style="text-align: center;">
    <h1 id="headline">青 草 书 屋</h1>
    <br>
    <br>
	    <div style="float: left;margin-right: 200px">
	   		 <a id="a1" href="${pageContext.request.contextPath }/client/IndexServlet?method=getAll" target="body">首页</a>  
	   		 <a href="${pageContext.request.contextPath }/client/CartServlet?userid=${user.id}">查看购物车</a> 
	    </div>
	    <div style="float: right;" >
		    <c:if test="${user == null }">
		   	  <form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
		    	用户名:<input type="text" name="username" style="width: 100px">密码：<input type="password" name="password" style="width: 100px">
		    	<input type="submit" value="登录">
		    	<input type="submit" value="注册" onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath}/clientJSP/register.jsp'">
		  	  </form>	
		  	</c:if>
		  	<c:if test="${user != null }">
		  		欢迎你，${user.username }    <a href="${pageContext.request.contextPath }/client/LogoutServlet" >注销</a>
		  	</c:if>
	  	</div>
  
  </body>
</html>

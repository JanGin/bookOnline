<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post">
    	用户名：<input type="text" name="username"><br/><br/>
    	密码：<input type="text" name="password"><br/><br/>
    	电话：<input type="text" name="phone"><br/><br/>
    	手机：<input type="text" name="cellphone"><br/><br/>
    	住址：<input type="text" name="address"><br/><br/>
    	邮箱： <input type="text" name="email"><br/><br/>
    	<input type="submit" value="注册">
    
    </form>
  </body>
</html>

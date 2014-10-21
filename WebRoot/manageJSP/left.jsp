<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- 
    <script type="text/javascript">
    	function block(varible){
    		var value  = varible.style.display == 'none'? 'block':'none';
    		varible.style.display = value;
    	}
    </script>
    -->
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	

  </head>
  
  <body bgcolor="lawngreen">
  <h3>导航</h3><br><br>

	   <a href="#" target="body" >分类管理</a><br>
	   <a href="${pageContext.request.contextPath }/manageJSP/addCategory.jsp" target="body">添加分类</a><br>
	   <a href="${pageContext.request.contextPath }/manage/CategoryServlet?method=list" target="body">查看分类</a><br><br>

	    <a href="#" target="body">图书管理 </a><br>
		   
			<a href="${pageContext.request.contextPath }/manage/BookServlet?method=addUI" target="body">添加图书</a><br>
			<a href="${pageContext.request.contextPath }/manage/BookServlet?method=listBook" target="body">查看图书</a><br><br>
		
	    <a href="#" target="body">订单管理 </a><br>	
			<a href="${pageContext.request.contextPath }/manage/OrderListServlet?state=true" target="body">查看已发货订单</a><br>
			<a href="${pageContext.request.contextPath }/manage/OrderListServlet?state=false" target="body">查看未发货订单</a><br>
		
  </body>
</html>

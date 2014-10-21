<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加书籍</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
 </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/manage/BookServlet?method=addBook" method="post" enctype="multipart/form-data">
    	<table frame="border" width="60%">		
			<tr>
    			<td>书籍名称</td>
    			<td>
    				<input type="text" name="name">
    			</td>
    		</tr>
    		<tr>
    			<td>作者</td>
    			<td>
    				<input type="text" name="author">
    			</td>
    		</tr>
    		<tr>
    			<td>价格</td>
    			<td>
    				<input type="text" name="price">
    			</td>
    		</tr>
    		<tr>
    			<td>图片</td>
    			<td>
    				<input type="file" name="image">
    			</td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td>
    				<input type="text" name="description">
    			</td>
    		</tr>
    		<tr>
    			<td>分类</td>
    			<td>
    				<select name="category_id">
    				<c:forEach items="${category }" var="category">
    					<option value="${category.id }">${category.name }</option>
    				</c:forEach>	
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="reset" value="清空">
    			</td>
    			<td>
    				<input type="submit" value="确定">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

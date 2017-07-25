<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update users' information</title>
<script src="js/jquery.js"></script>
<script src="js/jquery.tableui.js"></script>
<link href='css/jquery.tableui.css'  rel="stylesheet" type="text/css"/>
<script type="text/javascript">
	$(function(){
		$(".table_solid").tableUI();
	});
</script>
</head>
<body>
			
	<form action="${pageContext.request.contextPath }/Bg_UpdateUserServlet"
		method="post">
	<input type="hidden" name="id" value="${user.id }"/>
	<table class="table_solid" border="0" cellspacing="0">
			<tr>
				<th colspan="2" align="center">update users' information</th>
			</tr>
			<tr>
				<th>admin</th>
				<td><input type="text" name="admin" value="${user.admin }"/></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="text" name="adminpwd" value="${user.adminPwd }"/></td>
			</tr>
			<tr>
				<th>qq</th>
				<td><input type="text" name="qq" value="${user.qq }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="update" />&nbsp;
					<input type="reset" value="reset" /></td>
			</tr>
	
	</table>
	</form>
</body>
</html>
 
  
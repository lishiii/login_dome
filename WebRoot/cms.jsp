	<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manage users' information</title>
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
	<a>管理员 &nbsp</a>
	<%
		Cookie cookies[]=request.getCookies(); //读出用户硬盘上的Cookie，并将所有的Cookie放到一个cookie对象数组里面
		Cookie sCookie=null; 
		for(int i=0;i<cookies.length-1;i++){    //用一个循环语句遍历刚才建立的Cookie对象数组
		sCookie=cookies[i];   //取出数组中的一个Cookie对象
		if(sCookie!=null){
     	if(("admin").equals(sCookie.getName())){      
		      out.print(sCookie.getValue());
		      	}
		  	}
		  }
	%> 
	<a>你好!</a>
	<table class="table_solid" border="0" cellspacing="0">
			<tr>
				<th colspan="5" align="center">manage users' information</th>
			</tr>
			<tr><th>id</th><th>name</th><th>passwrod</th><th>qq</th><th>operation</th></tr>
		<c:forEach items="${users }" var="user" varStatus="varSta">
			<tr>
				<td>${varSta.count }</td>
				<td>${user.admin }</td>
				<td>${user.adminPwd }</td>
				<td>${user.qq }</td>
				<td><a
					href="${pageContext.request.contextPath }/Bg_QueryUserServlet?id=${user.id}">update</a>&nbsp;<a
					href="${pageContext.request.contextPath }/Bg_DeleteUserServlet?id=${user.id}">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
 
  
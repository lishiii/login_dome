<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <h2 style="text-align:center;">XX平台后台登录页面</h2>
    <br><br>
		<form action="${pageContext.request.contextPath }/Bg_LoginUserServlet" method="post">
    <div class="row form-horizontal">
    	<div class="form-group">
    	  <label class="col-sm-2 control-label form-label">用户名:</label>
    	  <div class="col-sm-8">
    	    <input type="text" class="form-control" id="card_name" name="username">
    	  </div>
    	</div>
    	<div class="form-group">
    	  <label class="col-sm-2 control-label form-label">密码:</label>
    	  <div class="col-sm-8">
    	    <input type="password" class="form-control" id="card_name1" name="p">
    	  </div>
    	</div>	
    </div> 
    <div class="row">
    	<div class="form-group btn-group col-md-offset-4">
    		<button class="btn btn-success" onclick="toValidate()">登录</button>
    	</div>
    </div>
    </form>
</body>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/validate.js"></script>
<script>
	function toValidate(){
		var val = new validate({
			rules:{
				card_name:"notEmpty",   
				card_name1:"password",
			},
			submitFun:function(){
				toSubmit();
				location='cms.php'
			}
		})
	}
	
</script>
</html>
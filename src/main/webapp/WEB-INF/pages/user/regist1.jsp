<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线考试系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0); 
	}, false);
	function hideURLbar(){ 
		window.scrollTo(0,1); 
	} 
</script>
<link href="${ctx}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/js/modernizr.custom.js"></script>
<script src="${ctx}/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/js/move-top.js"></script>
<script type="text/javascript" src="${ctx}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
</head>
<body>
<div class="typrography">
    <div class="container">
		<h3 class="bars">用户注册</h3>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">登录账号：</span>
		  <input type="password" class="form-control" placeholder="登录账号" aria-describedby="basic-addon1">
		</div>

		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">登录账号：</span>
		  <input type="text" class="form-control" placeholder="登录账号：" aria-describedby="basic-addon2">
		</div>

		<div class="input-group">
		  <span class="input-group-addon">登录账号</span>
		  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
		</div>
		<div class="input-group input-group-lg">
		  <span class="input-group-addon" id="sizing-addon1">登录账号：</span>
		  <input type="text" class="form-control" placeholder="登录账号" aria-describedby="sizing-addon1">
		</div>

		<div class="input-group">
		  <span class="input-group-addon" id="sizing-addon2">登录账号：</span>
		  <input type="text" class="form-control" placeholder="登录账号" aria-describedby="sizing-addon2">
		</div>

		<div class="input-group input-group-sm">
		  <span class="input-group-addon" id="sizing-addon3">登录账号：</span>
		  <input type="text" class="form-control" placeholder="登录账号" aria-describedby="sizing-addon3">
		</div>
		<p>我已经有一个账户，我要 <code>登录</code></p>
	</div>
</div>
</body>
</html>
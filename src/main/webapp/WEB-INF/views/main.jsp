<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>后台管理中心</title>
<link rel="stylesheet" href="./css/pintuer.css">
<link rel="stylesheet" href="./css/admin.css">
<script src="./js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="./img/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" /> 后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-blue" href="login.do"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>汽车信息管理
		</h2>
		<ul style="display: block">
			<li><a href="./show.do" target="right"><span
					class="icon-caret-right"></span>汽车信息</a></li>
			<li><a href="./form.do" target="right"><span
					class="icon-caret-right"></span>添加汽车</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>权限管理
		</h2>
		<ul>
			<li><a href="module/listmodule.do" target="right"><span
					class="icon-caret-right"></span>模块管理</a></li>
			<li><a href="role/listrole.do" target="right"><span
					class="icon-caret-right"></span>角色管理</a></li>
		</ul>
<h2>
			<span class="icon-pencil-square-o"></span>用户管理
		</h2>
		<ul>
			<li><a href="#" target="right"><span
					class="icon-caret-right"></span>用户信息列表</a></li>
		</ul>

	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="index.jsp" target="right" class="icon-home"> 首页</a>
		</li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="./index.jsp" name="right"
			width="100%" height="100%"></iframe>
	</div>

</body>
</html>
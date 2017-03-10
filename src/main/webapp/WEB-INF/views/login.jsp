<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>官方主页</title>

<!-- load stylesheets -->
<link rel="stylesheet"
	href="http://fonts.useso.com/css?family=Open+Sans:300,400">
<!-- Google web font "Open Sans" -->
<link rel="stylesheet"
	href="font-awesome-4.5.0/css/font-awesome.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" href="css/hero-slider-style.css">
<!-- Hero slider style -->
<link rel="stylesheet" href="css/templatemo-style.css">
<!-- Templatemo style -->
</head>
<body>
	
	<ul class="cd-hero-slider autoplay">
		<li>
			<div class="cd-full-width">
				<div class="tm-slide-content-div">
					<form action="logindo.do" id="newsletter" method="post">
						<i class="fa fa-cloud tm-slide-icon"></i>
						<h2 class="text-uppercase">汽车管理系统</h2>
						<p class="tm-site-description">欢迎进入汽车管理系统</p>
						<div class="form-group">
							<input type="text" class="form-control center-block tm-max-w-400"
								id="input3" placeholder="Enter your username..." name="username"> <input
								type="password" class="form-control center-block tm-max-w-400"
								id="input3" placeholder="check your password..." name="password">
						</div>
						<p class="tm-site-description">${error}</p>
						<button type="submit" class="cd-btn">登录</button>
					</form>
					<br>
					<a href="adduser.do" class="cd-btn">注册用户</a>
					<br>
				</div>
			</div> <!-- .cd-full-width -->
		</li>
	</ul>
	
	

	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/tether.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/hero-slider-script.js"></script>
	<script>
		$(document).ready(
				function() {

					/* Auto play bootstrap carousel 
					 * http://stackoverflow.com/questions/13525258/twitter-bootstrap-carousel-autoplay-on-load
					-----------------------------------------------------------------------------------------*/
					$('.carousel').carousel({
						interval : 3000
					})

					/* Enable swiping carousel for tablets and mobile
					 * http://lazcreative.com/blog/adding-swipe-support-to-bootstrap-carousel-3-0/
					 ---------------------------------------------------------------------------------*/
					if ($(window).width() <= 991) {
						$(".carousel-inner").swipe(
								{
									//Generic swipe handler for all directions
									swipeLeft : function(event, direction,
											distance, duration, fingerCount) {
										$(this).parent().carousel('next');
									},
									swipeRight : function() {
										$(this).parent().carousel('prev');
									},
									//Default is 75px, set to 0 for demo so any distance triggers swipe
									threshold : 0
								});
					}

					/* Handle window resize */
					$(window).resize(
							function() {
								if ($(window).width() <= 991) {
									$(".carousel-inner").swipe(
											{
												//Generic swipe handler for all directions
												swipeLeft : function(event,
														direction, distance,
														duration, fingerCount) {
													$(this).parent().carousel(
															'next');
												},
												swipeRight : function() {
													$(this).parent().carousel(
															'prev');
												},
												//Default is 75px, set to 0 for demo so any distance triggers swipe
												threshold : 0
											});
								}
							});
				});
	</script>
</body>
</html>
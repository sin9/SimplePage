<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=request.getContextPath()%>/">
		<meta charset="utf-8" />
		<title>网页布局</title>
		<link rel="stylesheet" type="text/css" href="statics/css/main.css" />
	</head>

	<body>
		<div class="header">
			<div class="main">
				<a class="logo"></a>
				<ul class="menu">
					<li>
						<a class="selected" href="">首页</a>
					</li>
					<li>
						<a href="sm">上门取车</a>
					</li>
					<li>
						<a href="#">到店取还</a>
					</li>
					<li>
						<a href="#">长租</a>
					</li>
					<li>
						<a href="#">企业租车</a>
					</li>
					<li>
						<a href="#">顺风车</a>
					</li>
					<li>
						<a href="#">门店</a>
					</li>
					<li>
						<a href="#">活动</a>
					</li>
					<li>
						<a href="#">国际租车</a>
					</li>
				</ul>
				<div class="tel">
					<span class="zc-tel"></span>
					<img src="statics/images/zc_gaphone.png" />
				</div>
				<div class="home-center">
					<span class="login">
					<a href="#">登录</a>/<a href="#">注册</a>
				</span>
					<a href="admin">我的神州</a>
				</div>
			</div>
		</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="statics/css/login.css">
<link rel="stylesheet" href="statics/css/style.css" />
<style>
	body{
		background-image: url(statics/images/bodybac8.jpg);
	}
	
</style>
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form" action="/blog/login" method="post">
				<input type="text" placeholder="Username" name="username" id="username">
				<input type="password" placeholder="Password" name="password" id="password">
				<button type="submit" id="login-button">Login</button><br />
				<br />
				没有账号？<a href="/blog/register">注册</a>
				<span class="error" style="color:#761C19;font-weight:bold;margin-left:30px;">${error}</span>
			</form>
			
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
	</div>
</div>

<script type="text/javascript" src="js/jquery-3.1.0.js" ></script>
<script type="text/javascript" src="js/bootstrap.min.js" ></script>


</body>
</html>
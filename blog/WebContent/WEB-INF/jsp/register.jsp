<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<link rel="stylesheet" type="text/css" href="statics/css/login.css">
<link rel="stylesheet" href="statics/css/style.css" />
<style>
	body{
		background-image: url(statics/images/bodybac3.jpg);
	}
	
</style>
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>New</h1>
			
			<form class="form" id="fo" action="/blog/register" method="post">
				<input type="text" placeholder="Username" name="username" class="username">
				<input type="password" placeholder="Password" name="password" class="password">
				<input type="password" placeholder="Confirm Password" name="conpassword" class="conpassword">
				<button type="submit" id="login-button">register</button><br><br>
								<span class="error" style="color:#761C19;font-weight:bold;">${error}</span>
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

<script type="text/javascript" src="statics/js/jquery-3.1.0.js" ></script>
<script type="text/javascript" src="statics/js/bootstrap.min.js" ></script>


</body>
</html>
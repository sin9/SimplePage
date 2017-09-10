<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${artical.title}</title>
		<link rel="stylesheet" href="statics/css/style.css" />
		<script type="text/javascript" src="statics/js/jquery-3.1.0.js" ></script>
		<script type="text/javascript" src="statics/js/bootstrap.js" ></script>
		<link rel="stylesheet" href="statics/css/bootstrap.css" />
		<style>
			body{
				background-image: url(statics/images/bodybac11.jpg); background-repeat:no-repeat; background-attachment:fixed;
			}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/blog/main">SinBlog</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="text-align: center;">
      <ul class="nav navbar-nav">
         <c:if test="${empty sessionScope.user}">
        <li ><a href="/blog/login">Login </a></li>
        <li><a href="/blog/register">Register</a></li>
     <!--  <embed src="bgm.wav" ></embed>-->
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <li ><a href="/blog/personal">${sessionScope.user.uname}</a></li>
        <li><a href="/blog/publish">Publish</a></li>
        <li><a href="/blog/logout">Login out</a></li>
     <!--  <embed src="bgm.wav" ></embed>-->
    </c:if>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<%-- <div class="jumbotron">
  <h1>${artical.title}</h1>
  <p>author：${artical.user_name}</p>
  <p><a class="btn btn-primary btn-lg" href="#" role="button" id="page-detail">Details</a></p>
</div> --%>
<div id="page-artical">
	<h2>${artical.title}</h2>
	<h3>author:${artical.user.uname}</h3>
	<p>${artical.main}</p>
</div>
<!-- <script>
  	$(function(){
  		$("#page-detail").click(function(){
  			$('.jumbotron').fadeToggle();
  			$('#page-artical').fadeToggle();
  	
  	});
  		
  	});
  </script> -->
	</body>
</html>
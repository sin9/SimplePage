
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人文章</title>
		<link rel="stylesheet" href="statics/css/style.css" />
		<script type="text/javascript" src="statics/js/jquery-3.1.0.js" ></script>
		<script type="text/javascript" src="statics/js/bootstrap.js" ></script>
		<link rel="stylesheet" href="statics/css/bootstrap.css" />
	</head>
	<body>
		<div class="personal-image">
			<div class="second-bac">
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
<div class="main-articalname" style="margin-top:150px">
	<h1 style="font-size:100px;color:#fff">My Artical List</h1>
</div>
<!--<div class="main-baccenter"><h1>Summer</h1></div>-->
	</div>
	
</div>
<!-- <div class="main-articalname">
	<h1>My Artical List</h1>
</div>
<hr /> -->
<div class="list-group" style="margin-top:30px">
<c:forEach items="${pager.data}" var="artical">
  <a href="/blog/page?artical=${artical.id}" class="list-group-item">
    <h3 class="list-group-item-heading">${artical.title}</h3>
    <p class="list-group-item-text">
    ${artical.main}
    </p>
  </a>
  
  <a href="/blog/delete?id=${artical.id}" style="float:right;">删除</a>
  <hr>
  </c:forEach>

</div>

			<!--分页 -->
			<app:pager url="main" pager="${pager}"/>
	</body>
</html>

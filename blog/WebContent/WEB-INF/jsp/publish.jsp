<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发表文章</title>
		<link rel="stylesheet" href="statics/css/style.css" />
		<link rel="stylesheet" href="statics/css/bootstrap.css" />
		<script type="text/javascript" src="statics/js/jquery-3.1.0.js" ></script>
		<script type="text/javascript" src="statics/js/bootstrap.js" ></script>
		 <style>
           body{
           	background-image: url(statics/images/bodybac7.jpg);
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
       
        <li ><a href="/blog/personal">${sessionScope.user.uname}</a></li>
        <li><a href="/blog/publish">Publish</a></li>
        <li><a href="/blog/logout">Login out</a></li>
    
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> 

<form id="form1" runat="server" action="/blog/publish" method="post">
<div class="input-group">
  <span class="input-group-addon" id="basic-addon1">@</span>
  <input type="text" class="form-control" placeholder="标题" aria-describedby="basic-addon1" name="title">
</div>
		
		 	
      <div id="sample">
<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
  </script>

  <textarea name="area2" style="width: 50%;height: 400px;">
       请输入正文
</textarea><br /><div class="btn-group" role="group" aria-label="...">
  <button type="submit" class="btn btn-default">submit</button>	<span class="error" style="color:#761C19;font-weight:bold;float:right;">${error}</span>
</div>
</div>

     </form>
	</body>
</html>

<%@page import="cn.sinoutx.blog.model.entity.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib uri="http://gson.cn/app" prefix="app" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sinblog</title>
		<link rel="stylesheet" href="statics/css/skin1.css"  id="cssfile"/>
		<script type="text/javascript" src="statics/js/jquery.min.js" ></script>
		<script type="text/javascript" src="statics/js/jquery.cookies.2.2.0.js" ></script>
		<script type="text/javascript" src="statics/js/bootstrap.js" ></script>
		<link rel="stylesheet" href="statics/css/bootstrap.css" />
		<script type="text/javascript">
        	$(function () {
            var $li = $("#skin li");
            $li.click(function () {
                //当前li元素被选中，添加样式
                $("#" + this.id).addClass("selected")
                									.siblings().removeClass("selected");
                //网页内容换肤（更改样式）
                $("#cssfile").attr("href", "statics/css/" + this.id + ".css");
                //将皮肤设置写入Cookie，设置网页皮肤Cookie，Cookie有效期设置为100个小时
                $.cookies.set('MyCssSkin', this.id, { hoursToLive: 100 });
                //$.cookie("MyCssSkin", this.id, { path: '/', expires: 10 });
                //alert("cookie存进去了");
            });
            //读取Cookie，应用保存的皮肤设置
            var cookie_skin = $.cookies.get('MyCssSkin');//读取保存的Cookie
            //alert("读到cookie了");
            //如果存在Cookie
            if (cookie_skin) {
                //当前li元素选中
                $("#" + cookie_skin).addClass("selected")
                										.siblings().removeClass("selected");
                $("#cssfile").attr("href", "statics/css/" + cookie_skin + ".css");//设置不同皮肤
                $.cookies.set("MyCssSkin", cookie_skin, { path: '/', expires: 10 });//写入到Cookie
            }
        });
       
     
    </script>
	</head>
	<body>
		<div class="main-image">
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
     <div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">更换主题<span class="caret"></span></button>
        <ul class="dropdown-menu"  id="skin">
         <li id="skin2" ><a href="">主题1</a></li>
          <li id="skin3"><a href="">主题2</a></li>
          <li id="skin4"><a href="">主题3</a></li>
          <li id="skin1"><a href="">默认</a></li>
        </ul>
      </div>
    </div><!-- /input-group -->
  </div><!-- /.container-fluid -->
</nav>
<!--<div class="main-baccenter"><h1>Summer</h1></div>-->
	</div>
</div>
<div class="main-articalname">
	<h1>Artical List</h1>
</div>
<hr />
<div class="list-group">
<c:forEach items="${pager.data}" var="artical">
  <a href="/blog/page?artical=${artical.id}" class="list-group-item" style="20px">
    <h3 class="list-group-item-heading">${artical.title}</h3><br/>
    <h4 class="list-group-item-heading">Author:${artical.user.uname}</h4>
    <p class="list-group-item-text">
    <%--  ${fn:substring(artical.main, 0, 80)} --%>
    </p>
  </a>
  <hr>
  </c:forEach>

</div>

			<!--分页 -->
			<app:pager url="main" pager="${pager}"/>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/User_home_page.css" />
	<link rel="stylesheet" href="css/yufeng/header.css" />
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
  </head>
  
  <body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					 aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<img id="web_logo" src="logo2(已去底)%20(1).jpg" />

				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav">

						<li><a href="#">首页</a></li>
						<li><a href="#">|</a></li>
						<li><a href="#">岗位</a></li>
						<li><a href="#">|</a></li>
						<li><a href="#">公司</a></li>
						<li><a href="#">|</a></li>
						<li><a href="#">简历投递</a></li>
						<li><a href="#">|</a></li>
						<li><a href="#">其他</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<img class="img-circle" id="user_head" src="微信图片_20200310131209.jpg" />
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名：Colten
								<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">个人中心</a></li>
								<li><a href="#">收藏中心</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">退出登录</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		<div class="main_body">
			<div class="div_search">
				<div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="岗位 / 公司">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 -->
			</div><!-- /.row -->
		</div>

		<div class="div_title">
			<label class="label label-danger">热门岗位</label>
			<a class="types" href="#">证券</a>
			<a class="types" href="#">C++</a>
			<a class="types" href="#">PHP</a>
			<a class="types" href="#">Web前端</a>
			<a class="types" href="#">UI设计师</a>
			<a class="types" href="#">平面设计师</a>
		</div>

		<div style="width: 100%;height: 400px;">
			<div class="offer_info">
				
				<s:if test="pts!=null">
					<s:iterator value="pts">
					<div class="type">
						<a class="offer_type" href="#"><s:property value="PTname"/></a>
						<s:iterator value="posts">
							<a class="types" href="#"><s:property value="Pname"/></a>
						</s:iterator>
					</div>
					</s:iterator>
				</s:if>
				
			</div>

			<div class="ad_info">
				<div class="row_1">
					<img class="ad_img1" src="adimg2.jpg" />
					<img class="ad_img2" src="adimg3.jpg" />
				</div>
				<div class="row_2">
					<img class="ad_img3" src="adimg4.jpg" />
					<img class="ad_img4" src="adimg5.jpg" />
				</div>
				<div class="row_3">
					<img class="ad_img5" src="adimg1.jpg" />
				</div>
			</div>
		</div>

		<div class="hot_jobs">

			<div class="hot_jobs_title">
				<label>______</label>
				<label>热招职位</label>
				<label>______</label>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="jimg2.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="jimg1.jpg" />
						</div>
						<div class="mid_img2">
							<img src="jimg3.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="jimg5.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="jimg4.jpg" />
						</div>
						<div class="mid_img2">
							<img src="jimg6.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="jimg7.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="jimg9.jpg" />
						</div>
						<div class="mid_img2">
							<img src="jimg8.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="#">网络工程师</a>
						<label>腾讯 | 本科</label>
						<h3>15k - 25k</h3>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div class="panel panel-default">
				<div class="panel-heading"">
			        <div style=" width: fit-content; margin:0 auto;">
					<a href="">联系我们</a>
					&nbsp;|&nbsp;
					<a href="">用户反馈</a>
					&nbsp;|&nbsp;
					<a href="">举报违规行为</a>
					<br>
					<p style="width: fit-content; margin:0 auto;" class="text-warning">吃着苦瓜，告诉自己，生活是甜的</p>
				</div>
				<div style="display: inline-block;">
					友情链接：<a href="">
						<p class="text-info">bootstrap3中文文档</p>
					</a>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
	</body>
</html>

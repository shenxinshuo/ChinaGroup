<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网站头部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="../resource/static/jquery/jquery.min.js"></script>
    <script src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<style>
	#web_logo {
		width:50px;
		height:50px;
		float: left;
	}
	#user_head{
		width: 30px;
		height: 30px;
		margin-top: 10px;
		float: left;
	}
	</style>
  </head>
  
  <body>
    <!-- 网站头部 -->
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
					<img id="web_logo" src="../resource/image/logo2.jpg" />
					<a class="navbar-brand" href="#">精英</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">

						<li><a href="#">首页</a></li>
						<li><a href="#">岗位</a></li>
						<li><a href="#">公司</a></li>
						<li><a href="#">简历投递</a></li>
						<li><a href="#">其他</a></li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<img id="user_head" src="../resource/image/微信图片_20200310131209.jpg" />
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名：Colten
								<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
  </body>
</html>

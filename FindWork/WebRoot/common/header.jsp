<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网站头部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<style>
	#web_logo {
	
		margin-top: 10px;
		width:125px;
		height:50px;
		margin-right: 20px;
		float: left;
	
	}

	#user_head{
	
		width: 40px;
		height: 40px;
		margin-top: 15px;
		float: left;
	
	}

	.form-group{
	
		margin-left: 400px;
	
	}

	.nav li{
	
		margin-top: 10px;
		margin-right: 15px;
		font-size: 17px;
	
	}

	.container-fluid{
	
		height: 70px;
	
	}

	.web_name{
	
		margin-top: 30px;
		margin-left: 10px;
		margin-right: 30px;
		font-weight: bold;
		font-size: 35px;
		color: #269ABC;
		text-decoration: none;
	
	}
	</style>
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
					<img id="web_logo" src="<%=request.getContextPath() %>/resource/image/logo1.jpg" />
		
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
						<img class="img-circle" id="user_head"  />
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户名：Colten
								<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">个人中心</a></li>
								<s:url id="business_showBusinessCenter" action="business_showBusinessCenter" namespace="/">
									<s:param name="business.id">7</s:param>
									<s:param name="currentPage">1</s:param>
								</s:url>
								<li><a href="${business_showBusinessCenter }">企业中心</a></li>
								<li><a href="admin_showAdminCenter.action">管理员中心</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">退出</a></li>
							</ul>
						</li>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
	</body>
</html>

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
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/login.css"/>
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

  </head>
  
  <body>
  	<div class="background">
		<div class="user_login">
			<div class="login_home">
				<s:url id="touristAction" action="touristAction" namespace="/" />
				<a href="${touristAction }">首页</a>
			</div>
			<div class="web_title">
				<img class="web_img" src="resource/image/yufeng/login_title.png"/>
			</div>
			<div class="login_type">
					<div class="row">
  						<div class="col-xs-6">
								<a href="/FindWork/business/businessLogin.jsp">企业登录</a>
  						</div>
 	 					<div class="col-xs-6">
								<a href="/FindWork/user/UserLogin.jsp" style="float:left;">用户登录</a>
 	 					</div>
					</div>
			</div>
			<div class="login_form">
				<s:url id="admin_login" action="admin_login" namespace="/" />
					<form action="${admin_login }" method="post">
					  <div class="form-group">
					    <div class="col-md-12">
							<label for="" style="width:60px">用户名</label>
                        	<label for="" class="text-danger col-md-offset-4">${fieldErrors["adminName"][0] }</label>
                    	</div>
					    <input name="admin.account" type="text" class="form-control" id="exampleInputEmail1" >
					  </div>
					  <div class="form-group">
					    <div class="col-md-12">
					    		<label for="exampleInputPassword1" style="width:60px">密码</label>
					    		<label for="" class="text-danger col-md-offset-4">${fieldErrors["adminPassword"][0] }</label>
                    	</div>
                    
					    <input name="admin.password" type="password" class="form-control" id="exampleInputPassword1" />
					  </div>
					  <div class="form-group-btn">
					  	<button type="submit" class="login">登录</button>
					  </div>
					</form>
				</div>
			</div>
		</div>
  </body>
</html>

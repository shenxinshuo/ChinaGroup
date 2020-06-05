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
    
    <title>企业登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/adminlogin.css"/>
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
					
						<div style="width:20%;margin-left:17.5%;">
 	 						<a href="/FindWork/admin/adminLogin.jsp">管理员登录</a>
 	 					</div>
 	 					<div style="width:25%">
 	 						<a style="font-size:large;font-weight:bold;">企业登录</a>
 	 					</div>
 	 					<div style="width:20%">
 	 						<a href="/FindWork/user/UserLogin.jsp">用户登录</a>
						</div>
					
				</div>
				<div class="login_form" style="width: 100%;height: 210px;">
					<s:url id="business2_login" action="business2_login" namespace="/" />
					<form action="${business2_login }" method="post">
					  <div class="form-group">
					    <div class="col-md-12">
						<label for="" style="width:60px;">企业账号</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["businessName"][0] }</label>
                    </div>  
					    <input name="business.name" type="text" class="form-control" id="exampleInputEmail1" >
					  </div>
					  <div class="form-group">
					    <div class="col-md-12">
						<label for="exampleInputPassword1" style="width:60px;">密码</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["businessPassword"][0] }</label>
                    </div> 
					    <input name="business.password" type="password" class="form-control" id="exampleInputPassword1" >
					  </div>
					  <div class="form-group-btn">
					  	<button type="submit" class="login">登录</button>
					  </div>
					</form>
				</div>
				<div class="register">
					<label>没有账号？</label>
					<a href="<%=request.getContextPath() %>/business/regBusiness.jsp">点击注册</a>
				</div>
			</div>
		</div>
	</body>
</html>

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
    
    <title>求职者登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/yufeng/adminlogin.css"/>
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script language="JavaScript"> 
	if (window.top != window.self) {
  	top.location = "/FindWork/user/UserLogin.jsp";
	}
</script>
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
 	 						<a style="font-size:large;font-weight:bold;">用户登录</a>
 	 					</div>
 	 					<div style="width:20%">
 	 						<a href="/FindWork/business/businessLogin.jsp">企业登录</a>
						</div>
					
				</div>
				<div class="login_form" style="width: 100%;height: 210px;">
					<s:url id="user_login" action="user_login" namespace="/" />
					<form action="${user_login }" method="post">
					  <div class="form-group">
					    <div class="col-md-12">
						<label for="" style="width:60px;">用户名</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["userName"][0] }</label>
                    </div>  
					    <input name="user.name" type="text" class="form-control" id="exampleInputEmail1" >
					  </div>
					  <div class="form-group">
					    <div class="col-md-12">
						<label for="exampleInputPassword1" style="width:60px;">密码</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["userPassword"][0] }</label>
                    </div> 
					    <input name="user.password" type="password" class="form-control" id="exampleInputPassword1" >
					  </div>
					  <div class="form-group-btn">
					  	<button type="submit" class="login">登录</button>
					  </div>
					</form>
				</div>
				<div class="register">
					<label>没有账号？</label>
					<a href="/FindWork/user/userRegister.jsp">点击注册</a>
				</div>
			</div>
		</div>
	</body>
</html>

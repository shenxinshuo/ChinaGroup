<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/register.css" />
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

  </head>
  
  <body>
		<div class="user_register">
			<div class="return_login">
				<a href="login.html">返回登录</a>
			</div>
			<div class="re_title">
				<h2>用户注册</h2>
			</div>
			
			<s:url id="user_register" action="user_register" namespace="/" />
			<form action="${user_register }" method="post">

				<div class="form-group">
					<div class="col-md-12">
						<label for="" style="width:80px;">用户名</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["userName"][0] }</label>
                    </div>  
					
					<input name="user.name" type="text" class="form-control">
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<label for="exampleInputEmail1" style="width:80px;">电子邮箱</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["userEmail"][0] }</label>
                    </div> 
					<input name="user.email" type="text" class="form-control" id="exampleInputEmail1" >
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<label for="exampleInputPassword1" style="width:80px;">密码</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["userPassword"][0] }</label>
                    </div> 
					<input name="user.password" type="password" class="form-control" id="exampleInputPassword1">
				</div>
				<div class="form-group">
					<div class="col-md-12">
						<label for="exampleInputPassword2">确认密码</label>
                        <label for="" class="text-danger col-md-offset-4">${fieldErrors["sPassword"][0] }</label>
                    </div> 
					<input name="spassword" type="password" class="form-control" id="exampleInputPassword2" >
				</div>
				<div class="user_bir">

					<div class="form-group-year">
						<label for="exampleInputEmail1">年</label>
						<select name="ubirthday.byear" class="form-control">
							<option>1999</option>
							<option>2000</option>
							<option>2001</option>
							<option>2002</option>
							<option>2003</option>
							<option>2004</option>
							<option>2005</option>
							<option>2006</option>
							<option>2007</option>
							<option>2008</option>
							<option>2009</option>
							<option>2010</option>
							<option>2011</option>
							<option>2012</option>
							<option>2013</option>
						</select>
					</div>

					<div class="form-group-year">
						<label for="exampleInputEmail1">月</label>
						<select name="ubirthday.bmonth" class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>

					<div class="form-group-year">
						<label for="exampleInputEmail1">日</label>
						<select name="ubirthday.bday" class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>
		
				<div class="form-group-btn">
					<button type="submit" class="register">注册</button>
				</div>
			</form>
		</div>
	</body>
</html>

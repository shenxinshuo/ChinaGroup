<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>收藏中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../resource/static/jquery/jquery.min.js"></script>
<script
	src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="../resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div style="height: 500px;text-align: center;">
	  <form style="margin-top: 40px;" action="/FindWork/account_saveSecurity.action"method="post" >	
	  <font color="green">${message}</font>
	  <font color="red">${errorMessage}</font>
	  <font color="red">${fieldErrors.repwd[0]}</font><br>
	  <font>原密码：</font><input type="password" name="repwd" value="" /><br><br>
	  <font color="red">${fieldErrors.newpwd[0]}</font><br>
	  <font>新密码：</font><input type="password" name="newpwd" value="" /><br><br>
	  <font color="red">${fieldErrors.confirmpwd[0]}</font><br>
	  <font>确认：</font><input type="password" name="confirmpwd" value="" /><br><br>
	   <button type="submit" value="" style="width: 90px;height: 30px;background-color:#169bd5;border: 0px;"><p style="color: white;margin-top: 5px;">确认修改</p></button>
	  <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3>		  
	  </form><br><br>
	  <form action="/FindWork/account_delete.action" method="post">
	  	 <s:if test="#request.repwd2!=null">
	  	     <font color="red">${deleteMessage}</font><br>
	  	 	 <font>密码：</font><input type="password" name="repwd2" value="" /><br><br>
	  	 </s:if>  	
		 <button type="submit" value="" style="width: 90px;height: 25px;background-color:#e1e6f6;border: 0px;"><p style="color: white;margin-top: 2px;">点击注销</p></button>
		</form>
  </div>
</body>
</html>

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
<link href="../css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
</head>

<body>
	
	<div style="height: 500px;text-align: center;">
		<s:form style="margin-top: 40px;" theme="simple" 
			action="/FindWork/myInformation_save.action"
			method="post" namespace="/">
			<font color="green">${message}</font>	
			<font color="red">${fieldErrors.userName[0]}</font>
			<font color="red">${errorMessage}</font>
			<br>		
			<font style="margin-right: 28px;">姓名：</font>			
			<s:textfield  name="user.name" value="%{#request.user.name}"/>			
			
			<br>
			<br>
			<font color="red">${fieldErrors.userTelephone[0]}</font>
			<br> <font style="">联系电话：</font>		
			<s:textfield  name="user.telephone" value="%{#request.user.telephone}"/>
			
			<br>	
			<br>
			<font color="red">${fieldErrors.userEmail[0]}</font>		
			<br> <font style="margin-right: 28px;">邮箱：</font>
			<s:textfield  name="user.email" value="%{#request.user.email}"/>
			<br>
			<br>
			<font color="red">${fieldErrors.userBirthday[0]}</font>			
			<br> <font style="margin-right: 28px;">生日：</font>
			<s:textfield  name="user.birthday" value="%{#request.user.birthday}" />
			<br>
			<br>	
			<font color="red">${fieldErrors.userAddress[0]}</font>
			<br> <font style="margin-right: 28px;">地址：</font>
			<s:textfield  name="user.address" value="%{#request.user.address}"/>
			
			<br>
			<br>
			
			<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)"
				width="80%" color=#987cb9 SIZE=3>
			<s:hidden name="user.id" value="%{#request.user.id}"></s:hidden>
			<s:hidden name="Rid" value="%{#request.Rid}"></s:hidden>
			<s:hidden name="user.password" value="%{#request.user.password}"></s:hidden>
			<s:hidden name="user.imagepath" value="%{#request.user.imagepath}"></s:hidden>
			<s:hidden name="user.create_at" value="%{#request.user.create_at}"></s:hidden>
			<s:hidden name="user.delete_flag" value="%{#request.user.delete_flag}"></s:hidden>
			<s:hidden name="user.comment" value="%{#request.user.comment}"></s:hidden>		
			<s:submit style="width: 60px;height: 30px;background-color:#169bd5;border: 0px;color:white;"
				value="保存">			
			</s:submit>
		</s:form>
	</div>
</body>
</html>

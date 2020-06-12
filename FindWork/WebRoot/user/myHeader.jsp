<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的头像</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../resource/static/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div style="height: 500px;text-align: center;">	
		<font color="green">${message}</font><br><br>
		<img src="/FindWork/myHeader_readHeader.action" style="width: 100px;height: 100px;margin-top: 40px;"/>	
		<form style="margin-top: 40px;" enctype="multipart/form-data" method="post" 
			 action="/FindWork/myHeader_saveHeader.action">
			<font color="red">${fieldErrors.userHeader[0]}</font>
			<br>
			<input type="file" name="Header" style="margin:auto;background-color:#169bd5;color:white"  accept="image/*"/>
			<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)"
				width="80%" color=#987cb9 SIZE=3>
			<button type="submit" value=""
				style="width: 80px;height: 30px;background-color:#169bd5;border: 0px;">
				<p style="color: white;margin-top: 5px;">点击修改</p>
			</button>
		</form>
	</div>
</body>
</html>

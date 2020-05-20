<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<div style="text-align: center;height: 460px;">
		<div style="height: 80%;">
			<s:if test="#request.Businesses==null">
				没有收藏纪录，快去收藏吧
			</s:if>
			<s:iterator id="business" value="#request.Businesses">
				<div style=" width: 95%; height: 30%; background-color: #dae9f0;margin: auto;margin-top: 4px;">
				<span style="color:#169bd5;font-size: 20px;"><b><a
						href="#"><s:property value="#business.name" /></a></b></span> <a href="#"><span
					class="glyphicon glyphicon-remove"
					style="float: right;margin:10px 20px;"></span></a> <br> <span><s:property value="#business.address" /></span><br>
				<span><s:property value="#business.description" /></span><br> 公司详情连接 <span><s:property value="#business.url"/></span>
			   </div>		
			</s:iterator>	  
		</div>
		<div style="height: 20%;">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>

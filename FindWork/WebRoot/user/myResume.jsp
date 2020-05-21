<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>简历中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="../resource/static/jquery/jquery.min.js"></script>
    <script src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link href="../css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  </head>
   
  <body> 
  <div style="height: 500px;">
	<div style=" width: 100%;height: 120px;">		
	<div style="width: 150px;float: left;">	
	<img src="/FindWork/myHeader_readHeader.action" style="width: 100px;height: 100px;margin: 20px;">	
	</div>
	<div style="float:left;margin:20px 10px;">
		<span><s:property value="#user.name"/></span><br>
		<span><s:property value="#user.telephone"/></span><br>
		<span><s:property value="#user.address"/></span><br>
	</div>	
	<div style="float: right; margin-top: 40px; margin-right: 40px;">
		<s:url id="addcv" action="/FindWork/cv/cv_showAdd.action" namespace="/"></s:url>
		<a href="${addcv}" target="_parent"><p class="glyphicon glyphicon-pencil" style="font-size: 20px;">&nbsp;新增用户简历</p></a><br>
	</div>
	</div>
	
	
	<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3>

	<s:if test="#request.cvs==null||#request.cvs.size()==0">
				<div style="margin:100px 200px;">您还没有创建简历，赶快创建属于你的简历吧</div>
	</s:if>
	
	<s:else>
	
	<s:iterator id="cv" value="#request.cvs">
	
	<div style="width: 95%; height: 22%; background-color: #dae9f0;margin:auto;margin-top: 4px;">
	<div style="float: left; width: 80%;margin-top: 10px;margin-left: 20px;">
	<span style="color:#169bd5;font-size: 20px;"><b><a href="${showcv}" target="_parent">" >意向：<s:property value="#cv.want_post"/></a></b></span>
	<br>
	<span>技能：<s:property value="#cv.skill"/></span><br>
	<span><s:property value="#cv.skill"/></span><br>
	希望的工作类型：
	<span><s:property value="#cv.want_joy_type"/></span>
	</div>
	<div style="text-align: center;float: right;margin-top: 10px; margin-right: 20px;">
		<s:url id="showcv" action="/FindWork/cv/cv_show.action?cv.id=%{#cv.id}" namespace="/"></s:url>				
		<s:url id="update" action="/FindWork/cv/cv_showUpdate.action?cv.id=%{#cv.id}" namespace="/"></s:url>
	    <s:url id="delete" action="/FindWork/cv/cv_delete.action?cv.id=%{#cv.id}" namespace="/"></s:url>
		<a href="${showcv}" target="_parent"><p class="glyphicon glyphicon-eye-open" style="">&nbsp;查看简历</p></a><br>
		<a href="${update}" target="_parent"><p class="glyphicon glyphicon-pencil">&nbsp;修改简历</p></a><br>
		<a href="${delete}" target="_parent"><p class="glyphicon glyphicon-trash" style="">&nbsp;删除简历</p></a><br>
	</div>
	</div>
	
	</s:iterator>
	
	</s:else>
	</div>
  </body>
</html>

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
	<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	 <script>
  function myFunction() {
    alert("简历数量已达上限，添加请先删除");
  }
  </script>

  </head>
   
  <body> 
  <div style="height: 500px;">
	<div style=" width: 100%;height: 120px;">		
	<div style="width: 150px;float: left;">	
	<img src="/FindWork/myHeader_readHeader.action" style="width: 100px;height: 100px;margin: 20px 0px 0px 80px;">	
	</div>
	
	<div style="float:left;margin: 40px 0px 0px 50px; text-align: left;">   
		<span style="color: #337ab7; font-weight: 600;">姓名：<s:property value="%{#request.user.name}"/></span><br><br>
		<span style="color: #337ab7; font-weight: 600;">电话：<s:property value="%{#request.user.telephone}"/></span><br>
   </div>	
	<div style="float: right; margin-top: 40px; margin-right: 80px;">
		<s:url id="addcv" action="/FindWork/cv/cv_showAdd.action" namespace="/"></s:url>
		<s:if test="#request.cvs.size()!=4">
	     <a href="${addcv}" target="_parent"><button  style="width: 120px;height: 40px;background-color:#169bd5;border: 0px;"><p  class="glyphicon glyphicon-plus" style="color: white;margin-top: 5px;">&nbsp添加简历</p></button></a>		
		</s:if>
		<s:else>
		<button onclick="myFunction()" value="" style="width: 120px;height: 40px;background-color:#169bd5;border: 0px;"><p  class="glyphicon glyphicon-plus" style="color: white;margin-top: 5px;">&nbsp添加简历</p></button>
		</s:else>
	</div>
	</div>
	
	
	<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=#987cb9 SIZE=3>
		    
	<table style="width: 95%;text-align:center; margin: 30px auto;"   cellspacing=0  >
		<tr style="background-color: #f5f5f5;"><td style="color: #8C8C8C; height: 35px;">求职意向</td>
		<td style="color: #8C8C8C;height: 35px;">工作类型</td>
		<td style="color: #8C8C8C;height: 35px;">工作城市</td>
		<td style="color: #8C8C8C;height: 35px;">最高工资</td><td style="color: #8C8C8C;height: 35px;">操作</td></tr>
		
		<s:if test="#request.cvs==null||#request.cvs.size()==0">
			<tr><td colspan="5">您还没有创建简历，赶快创建属于你的简历吧</td></tr>
		</s:if>		
		<s:else>
	
	   <s:iterator id="cv" value="#request.cvs">
				<s:url id="showcv" action="/FindWork/cv/cv_show.action?cv.id=%{#cv.id}" namespace="/"></s:url>				
		<s:url id="update" action="/FindWork/cv/cv_showUpdate.action?cv.id=%{#cv.id}" namespace="/"></s:url>
	    <s:url id="delete" action="/FindWork/cv/cv_delete.action?cv.id=%{#cv.id}" namespace="/"></s:url>
		
		<tr><td><a href="${showcv}" target="_parent"><s:property value="#cv.want_post"/></a></td> 
		<td><s:property value="#cv.want_joy_type"/></td>
		<td><s:property value="#cv.want_city"/></td>
		<td>
		<s:property value="#cv.want_large_wages"/></td>
		<td>
			<a href="${update}" target="_parent">编辑</a>&nbsp|
			<a href="${delete}" target="_parent">删除</p></a>
		</td></tr>
		
		</s:iterator>
	
	     </s:else>	
	</table>	
	</div>
  </body>
</html>

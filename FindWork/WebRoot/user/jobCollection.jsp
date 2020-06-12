<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>招聘信息收藏夹</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<table class="table2" style="width: 95%;text-align:center;margin-left: 4%; "   cellspacing=0  >
		<tr style="background-color: #f5f5f5;">
		<td style="color: #8C8C8C; height: 30px;font-size: 16px;">招聘标题</td>
		<td style="color: #8C8C8C;height: 30px;font-size: 16px;">公司名称</td>
		<td style="color: #8C8C8C;height: 30px;font-size: 16px;">岗位</td>
		<td style="color: #8C8C8C;height: 30px;font-size: 16px;">最高工资</td>
		<td style="color: #8C8C8C;height: 30px;width:10px"></td>
		</tr>
		
		<s:if test="(#request.advertises==null||#request.advertises.size()==0)&&#request.page.current==1">
				<tr><td colspan="5">没有收藏的招聘信息，快去收藏吧</td></tr>
			
		</s:if>
		<s:else>
			<s:iterator id="advertise" value="#request.advertises">	
		<tr style="height:80px;">
		<td><a href="/FindWork/detailAdvertise.action?advertise.id=${advertise.id }"
				target="_parent" style="font-weight: 600;"><s:property value="#advertise.title" /></a></td> 
		<td><s:property value="#advertise.businessName" /></td>
		<td><s:property value="#advertise.postName" /></td>
		<td><s:property value="#advertise.largeWages" /></td> 	
		<s:url id="delete" action="/FindWork/collection_advertise_deleteAdvertise.action?advertise.id=%{#advertise.id}&&page.current=%{#request.page.current}" namespace="/" /> 
		<td style="width:10px"><a href="${delete}"><span class="glyphicon glyphicon-remove" style="float: right;margin:10px 20px;"></span></a></td>
		</tr>
	    </s:iterator>
	
	</table>	
	<div style="text-align: center;height: 450px;">
		<div style="height: 20%;">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<s:if test="#request.page.haspre">
					<s:url id="prePage"
						action="/FindWork/collection_advertise_showAdvertise.action? page.current=%{page.current-1}"
						namespace="/" />
				</s:if>						
					<s:url id="onePage"
						action="/FindWork/collection_advertise_showAdvertise.action? page.current=1"
						namespace="/" />
				<li><a href="${onePage}" aria-label="Previous"> 首页	</a></li> 
				<li><a href="${prePage}">上一页</a></li>
				<s:if test="#request.page.current!=0">
				   <s:if test="#request.page.current-2>0">
					  <li><a href="/FindWork/collection_advertise_showAdvertise.action? page.current=${page.current-2}"><s:property value="%{page.current-2}"/></a></li>
					</s:if>
					<s:if test="#request.page.current-1>0">
					  <li><a href="/FindWork/collection_advertise_showAdvertise.action? page.current=${page.current-1}"><s:property value="%{page.current-1}"/></a></li>
					</s:if> 	 
  				 	<li><a href="/FindWork/collection_advertise_showAdvertise.action? page.current=${page.current}"><s:property value="#request.page.current"/></a></li>
					</s:if>	
					<s:if test="#request.page.current+1<=#request.page.total">
					  <li><a href="/FindWork/collection_advertise_showAdvertise.action? page.current=${page.current+1}"><s:property value="%{page.current+1}"/></a></li>
					</s:if> 
					<s:if test="#request.page.current+2<=#request.page.total">
					  <li><a href="/FindWork/collection_advertise_showAdvertise.action? page.current=${page.current+2}"><s:property value="%{page.current+2}"/></a></li>
					</s:if> 										
				<s:if test="#request.page.hasnex">
				<s:url id="nextPage"
						action="/FindWork/collection_advertise_showAdvertise.action? page.current=%{page.current+1}"
						namespace="/" />
				</s:if>
					<s:url id="lastPage"
						action="/FindWork/collection_advertise_showAdvertise.action? page.current=%{page.total}"
						namespace="/" />
				<li><a href="${nextPage}">下一页</a></li>
				<li><a href="${lastPage}" aria-label="Next">尾页
				</a></li>
				
			</ul>
			</nav>
			  <div style="float:right;">
				  <span>当前页数：<s:property value="#request.page.current"/>
				  <span>共计页数：<s:property value="#request.page.total"/>
				  </div>
		</div>
		     
		</s:else>
	        	
	</div>
</body>
</html>

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
<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div style="text-align: center;height: 450px;">
		<div style="height: 80%;">
			<s:if test="(#request.Businesses==null||#request.Businesses.size()==0)&&#request.page.current==1">
				<div style="margin:100px auto;">没有收藏的企业，快去收藏吧</div>
			</s:if>
			<s:else>
				<s:iterator id="business" value="#request.Businesses">
					<div
						style=" width: 95%; height: 30%; background-color: #dae9f0;margin: auto;margin-top: 4px;">
						<span style="color:#169bd5;font-size: 20px;"><b><a
								href="/FindWork/business_showBusinessInfo.action?business.id=${business.id }"
								target="_parent"><s:property value="#business.name" /></a></b></span>
								<s:url id="delete"
						action="/FindWork/collection_deleteBusiness.action?business.id=%{#business.id}&&page.current=%{#request.page.current}"
						namespace="/" /> 
								<a href="${delete}">
								<span class="glyphicon glyphicon-remove"style="float: right;margin:10px 20px;"></span>
								</a> 
								<br> 
								<span><s:property
								value="#business.address" /></span><br><s:property
								value="#business.description" /><br> 公司详情连接:<a href="${ business.url}"><s:property
								value="#business.url" /></a>
					</div>
				</s:iterator>
		</div>
		<div style="height: 20%;">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<s:if test="#request.page.haspre">
					<s:url id="prePage"
						action="/FindWork/collection_showBusiness.action? page.current=%{page.current-1}"
						namespace="/" />
				</s:if>
				<s:else>
					<s:url id="prePage"
						action="/FindWork/collection_showBusiness.action? page.current=1"
						namespace="/" />
				</s:else>
				<li><a href="${prePage}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li> 
					<s:if test="#request.page.current!=0">	 
  				 	<li><a href="collection_showBusiness.action? page.current=${page.current}"><s:property value="#request.page.current"/></a></li>
					</s:if>	
					<s:if test="#request.page.current+1<=#request.page.total">
					  <li><a href="collection_showBusiness.action?page.current=${page.current+1}"><s:property value="%{page.current+1}"/></a></li>
					</s:if> 
					<s:if test="#request.page.current+2<=#request.page.total">
					  <li><a href="collection_showBusiness.action? page.current=${page.current+2}"><s:property value="%{page.current+2}"/></a></li>
					</s:if> 										
				<s:if test="#request.page.hasnex">
				<s:url id="nextPage"
						action="/FindWork/collection_showBusiness.action? page.current=%{page.current+1}"
						namespace="/" />
				</s:if>
				<s:else>
					<s:url id="nextPage"
						action="/FindWork/collection_showBusiness.action? page.current=%{page.total}"
						namespace="/" />
				</s:else>
				<li><a href="${nextPage}" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
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

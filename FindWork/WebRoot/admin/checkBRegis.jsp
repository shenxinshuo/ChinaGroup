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
    
    <title>审核企业注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/CheckReInfo.css" />
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />

  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
  
    <div class="Check_div">
			<div class="check_left">
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="#">审核企业</a></li>
					<li role="presentation"><a href="#">审核招聘信息</a></li>
					
				</ul>
			</div>

			<div class="check_right">
				<s:url id="admin_updateCheckFlag" action="admin_updateCheckFlag" namespace="/"/>
				<form class="form-horizontal" action="${admin_updateCheckFlag }" method="post">
					
					<input type="hidden" name="business.id" value="${business.id }"/>
					<div class="form-group">
						<div class="form-inline col-md-12">
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">企业名称</label>
								<input value="${business.name }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">所在城市</label>
								<input value="${business.city }" readonly="readonly" unselectable="on" class="form-control " size="30">
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-inline col-md-12">
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">联系电话</label>
								<input value="${business.telephone }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
							<div class="form-group col-md-6 ">
								<label for="" class="control-label col-md-4">邮箱</label>
								<input value="${business.email }" readonly="readonly" unselectable="on" class="form-control " size="30">
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-inline col-md-12">
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">登录密码</label>
								<input value="${business.password }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
							
						</div>
					</div>

					<div class="form-group">
						<label for="" class="control-label col-md-2">企业地址</label>
						<div class="col-md-9" style="padding: 0;">
							<input value="${business.address }" readonly="readonly" unselectable="on" type="text" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<label for="" class="control-label col-md-2">企业描述</label>
						<div class="col-md-9" style="padding: 0;">
							<textarea placeholder="${business.description }" readonly="readonly" unselectable="on" class="form-control" cols="30" rows="10"></textarea>
						</div>
					</div>

					<div class="form-group">
						<label for="" class="control-label col-md-2">企业详情链接</label>
						<div class="col-md-9" style="padding: 0;">
							<input value="${business.url }" readonly="readonly" unselectable="on" type="text" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<label for="" class="control-label col-md-2">审核备注</label>
						<div class="col-md-9" style="padding: 0;">
							<textarea name="business.comment" placeholder="此处添加审核信息" class="form-control" cols="30" rows="10"></textarea>
						</div>
					</div>
					
					<div class="btn-group" style="float: right;margin-top: 60px;">
						<button type="submit" class="btn btn-primary">审核通过</button>
						<button type="reset" class="btn btn-default">审核失败</button>
					</div>

				</form>
			</div>
		</div>
		
		<!-- 引入底部 -->
    	<jsp:include page="/common/footer.jsp"/>
		<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
    	<script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </body>
</html>

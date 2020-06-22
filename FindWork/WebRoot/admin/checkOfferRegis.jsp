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
    
    <title>My JSP 'checkOfferRegis.jsp' starting page</title>
    
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
					<li role="presentation"><a href="admin_showAdminCenter.action">审核企业</a></li>
					<li role="presentation" class="active"><a>审核招聘信息</a></li>
					<li role="presentation"><a href="blacklist_toCheckComplain.action">处理投诉</a></li>
					<li role="presentation"><a href="roleManager/addRole.jsp">角色管理</a></li>
					<li role="presentation"><a href="post_toAddPost.action">岗位管理</a></li>
				</ul>
			</div>

			<div class="check_right">
				<s:url id="admin_checkAdver" action="admin_checkAdver" namespace="/"/>
				<form class="form-horizontal" action="${admin_checkAdver }">
				
					<input type="hidden" name="advertise.id" value="${advertise.id }"/>
					<div class="form-group">
						<div class="form-inline col-md-12">
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">招聘标题</label>
								<input value="${advertise.title }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">招聘岗位</label>
								<input value="${advertise.postName }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
						</div>
					</div>

					<div class="form-group">
						<div class="form-inline col-md-12">
							<div class="form-group col-md-6">
								<label for="" class="control-label col-md-4">工作种类</label>
								<input value="${advertise.wantJoyType }" readonly="readonly" unselectable="on" type="text" class="form-control" size="25">
							</div>
							<div class="form-group col-md-6 ">
								<label for="" class="control-label col-md-4">截至日期</label>
								<input value="${advertise.deadline }" readonly="readonly" unselectable="on" type="text" class="form-control " size="25">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="" class="control-label col-md-2">岗位简介</label>
						<div class="col-md-9" style="padding: 0;">
							<textarea placeholder="${advertise.ask }" readonly="readonly" unselectable="on" class="form-control" cols="30" rows="10"></textarea>
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

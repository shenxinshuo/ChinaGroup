<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkBRegisList.jsp' starting page</title>
    
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
					<li role="presentation"><a href="admin_showAdverList.action">审核招聘信息</a></li>
					<li role="presentation"><a href="roleManager/addRole.jsp">角色管理</a></li>
					<li role="presentation"><a href="post_toAddPost.action">岗位管理</a></li>
				</ul>
			</div>

			<div class="check_right">
				<table class="table table-hover" style="width: 500px;margin-top: 30px;">
				
					<s:if test="bs!=null">
						<s:iterator value="bs" >
							<tr>
								<th style="width: 400px;"><s:property value="name"/></th>
								<th style="width: 100px;">
									<a href="admin_showBusinessForCheck.action?business.id=<s:property value='id'/>" style="">审核</a>
								</th>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						暂无审核数据
					</s:else>
					
				</table>
				
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				    <li>
				      <a href="admin_showAdminCenter.action?currentPage=1" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				  
				    <s:if test="plist!=null">
						<s:iterator value="plist" id='number'>
							<li><a href="admin_showAdminCenter.action?currentPage=<s:property value='number'/>"><s:property value='number'/></a></li>
						</s:iterator>
					</s:if>
				    
				    <li>
				      <a href="admin_showAdminCenter.action?currentPage=${totalPages }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
		</div>
		
		<!-- 引入底部 -->
    	<jsp:include page="/common/footer.jsp"/>
		<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
    	<script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </body>
</html>

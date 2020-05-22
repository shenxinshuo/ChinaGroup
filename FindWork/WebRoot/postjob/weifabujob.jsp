<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'regBusiness.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=path %>/postjob/css/style.css">
    <link rel="stylesheet" href="<%=path %>/postjob/css/colors/blue.css">
    <link rel="stylesheet" href="<%=path %>/postjob/css/header.css"/>
	<link rel="stylesheet" href="<%=path %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
  </head>
  <script type="text/javascript">
 		function deleteAdvertise(id) {
 			var msg = "确定删除该条未发布的招聘信息吗？"; 
    		if (confirm(msg)==true){
        			 $.ajax({
        			    url:"<%=path %>/deleteAdvertise.action?advertise.id="+id,    //请求的url地址
        			    //dataType:"json",   //返回格式为json
        			    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        			    success:function(req){
        			    	window.location.reload();
        			    	alert("删除成功！");
        			    }
        			 }); 
    		}else{ 
    		} 
		} 
  </script>
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
    
    
    

	<!-- Dashboard Content
	================================================== -->

	<!-- 返回企业中心 -->
	<a href="FindWork/business_showBusinessCenter.action?business.id=7&currentPage=1"><span class="glyphicon glyphicon-chevron-left"></span>返回企业中心</a>
	<div class="dashboard-content-container" data-simplebar>
		<div class="dashboard-content-inner" >
			
			<!-- Dashboard Headline -->
		
	
			<!-- Row -->
			<div class="row">

				<!-- Dashboard Box -->
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0">

						<!-- Headline -->
						<div class="headline">
							<h3><i class="glyphicon glyphicon-folder-close"></i> 待发布招聘信息</h3>
						</div>

						<div class="content">
							<ul class="dashboard-box-list">
								 <!-- <li>
									<div class="job-listing">
										<div class="job-listing-details">
											<div class="job-listing-description">
												<div class="job-listing-footer">
													<ul>
														<li><i class="glyphicon glyphicon-user"></i>aaa</li>
														
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="buttons-to-right always-visible">
										<a href="dashboard-manage-candidates.jsp" class="button ripple-effect"><i class="glyphicon glyphicon-ok"></i> 发布工作 </a>
										<a href="#" class="button gray ripple-effect ico" title="编辑" data-tippy-placement="top"><i class="glyphicon glyphicon-pencil"></i></a>
										<a href="#" class="button gray ripple-effect ico" title="删除" data-tippy-placement="top"><i class="glyphicon glyphicon-trash"></i></a>
									</div>
								</li>  -->
						
									<c:forEach items="${requestScope.list}" var="l" varStatus="ss">
									<li>
											<div class="job-listing">
										<div class="job-listing-details">
											<div class="job-listing-description">
												<div class="job-listing-footer">
													<ul>
														<li><i class="glyphicon glyphicon-user"></i>${l.title}</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="buttons-to-right always-visible">
										<a href="dashboard-manage-candidates.jsp" class="button ripple-effect"><i class="glyphicon glyphicon-ok"></i> 发布工作 </a>
										<a href="<%=path %>/toUpdateAdvertise.action?advertise.id=${l.id}" class="button gray ripple-effect ico" title="编辑" data-tippy-placement="top"><i class="glyphicon glyphicon-pencil"></i></a>
										<a href="#" onclick="javascript:deleteAdvertise(${l.id});" class="button gray ripple-effect ico" title="删除" data-tippy-placement="top"><i class="glyphicon glyphicon-trash"></i></a>
									</div>
									</li>
                        			</c:forEach>
							</ul>
						</div>
					</div>
				</div>

			</div>
			<!-- Row / End -->

			

		</div>
	</div>
	<!-- Dashboard Content / End -->

</div>
<!-- Dashboard Container / End -->

</div>
<!-- Wrapper / End -->

     <!-- 引入底部 -->
		    <jsp:include page="/common/footer.jsp"/>

      <script type="text/javascript" src="<%=path %>/resource/static/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <!-- <script src="../jquery/jquery-3.3.1.min.js"></script>
	<script src="../jquery/jquery-migrate-3.0.0.min.js"></script>
	<script src="jquery/bootstrap-slider.min.js"></script>
	<script src="jquery/bootstrap-select.min.js"></script>  -->

</body>
</html>
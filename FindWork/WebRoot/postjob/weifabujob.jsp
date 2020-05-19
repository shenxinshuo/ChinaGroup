<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
	<link rel="stylesheet" href="css/header.css"/>
    <link rel="stylesheet" href="../resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/colors/blue.css">
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
    
    
    

	<!-- Dashboard Content
	================================================== -->

	<!-- 返回企业中心 -->
	<a href="../business/businessCenter.jsp"><span class="glyphicon glyphicon-chevron-left"></span>返回企业中心</a>
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
								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Logo -->
									<a href="#" class="job-listing-company-logo">
										<!-- 		<img src="images/company-logo-05.png" >
											</a> -->

											<!-- Details -->
											<div class="job-listing-description">
								

												<!-- Job Listing Footer -->
												<div class="job-listing-footer">
													<ul>
														<li><i class="glyphicon glyphicon-user"></i>aaa</li>
														
													</ul>
												</div>
											</div>
										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right always-visible">
										<a href="dashboard-manage-candidates.jsp" class="button ripple-effect"><i class="glyphicon glyphicon-ok"></i> 发布工作 </a>
										<a href="#" class="button gray ripple-effect ico" title="编辑" data-tippy-placement="top"><i class="glyphicon glyphicon-pencil"></i></a>
										<a href="#" class="button gray ripple-effect ico" title="删除" data-tippy-placement="top"><i class="glyphicon glyphicon-trash"></i></a>
									</div>
								</li>

								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Details -->
											<div class="job-listing-description">
												
												<!-- Job Listing Footer -->
												<div class="job-listing-footer">
													<ul>
														<li><i class="glyphicon glyphicon-user"></i> bbb</li>
														
													</ul>
												</div>
											</div>

										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right always-visible">
										<a href="dashboard-manage-candidates.jsp" class="button ripple-effect"><i class="glyphicon glyphicon-ok"></i>  发布工作 </a>
										<a href="#" class="button gray ripple-effect ico" title="编辑" data-tippy-placement="top"><i class="glyphicon glyphicon-pencil"></i></a>
										<a href="#" class="button gray ripple-effect ico" title="删除" data-tippy-placement="top"><i class="glyphicon glyphicon-trash"></i></a>
									
									</div>
								</li>

								<li>
									<!-- Job Listing -->
									<div class="job-listing">

										<!-- Job Listing Details -->
										<div class="job-listing-details">

											<!-- Details -->
											<div class="job-listing-description">
												

												<!-- Job Listing Footer -->
												<div class="job-listing-footer">
													<ul>
														<li><i class="glyphicon glyphicon-user"></i> ccc</li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<!-- Buttons -->
									<div class="buttons-to-right always-visible">
										<a href="dashboard-manage-candidates.jsp" class="button ripple-effect"><i class="glyphicon glyphicon-ok"></i> 发布工作</a>								
										<a href="#" class="button gray ripple-effect ico" title="编辑" data-tippy-placement="top"><i class="glyphicon glyphicon-pencil"></i></a>
										<a href="#" class="button gray ripple-effect ico" title="删除" data-tippy-placement="top"><i class="glyphicon glyphicon-trash"></i></a>
									
									</div>
								</li>

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

     <script type="text/javascript" src="../resource/static/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <!-- <script src="../jquery/jquery-3.3.1.min.js"></script>
	<script src="../jquery/jquery-migrate-3.0.0.min.js"></script>
	<script src="jquery/bootstrap-slider.min.js"></script>
	<script src="jquery/bootstrap-select.min.js"></script>  -->

</body>
</html>
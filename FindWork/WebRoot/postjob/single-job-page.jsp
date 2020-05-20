<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <link rel="stylesheet" href="<%=path %>/postjob/css/header.css">
    <link rel="stylesheet" href="<%=path %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
    



<!-- Titlebar
================================================== -->

<!-- 返回上一步 -->
<a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-chevron-left"></span>返回</a>
<div class="single-page-header" data-background-image="images/single-job.jpg">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="single-page-header-inner">
					<div class="left-side">
						<div class="header-image"><a href="single-company-profile.html"><img src="images/company-logo-03a.png" alt=""></a></div>
						<div class="header-details">
							<h3>${as.title}</h3>
							
							<ul>
								
								<!-- <li><div class="star-rating" data-rating="4.9"></div></li> -->
								<!-- <li><img class="flag" src="images/flags/gb.svg" alt=""> 英国</li> -->
								
							</ul>
						</div>
					</div>
					<!-- <div class="right-side">
						<div class="salary-box">
							<div class="salary-type">平均工资</div>
							<div class="salary-amount">8k+</div>
						</div>
					</div> -->
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Page Content
================================================== -->
<div class="container">
	<div class="row">
		
		<!-- Content -->
		<div class="col-xl-8 col-lg-8 content-right-offset">

			<div class="single-page-section">
				<h3 class="margin-bottom-25">岗位介绍</h3>
				<!-- <p>Leverage agile frameworks to provide a robust synopsis for high level overviews. Iterative approaches to corporate strategy foster collaborative thinking to further the overall value proposition. Organically grow the holistic world view of disruptive innovation via workplace diversity and empowerment.</p>

				<p>Bring to the table win-win survival strategies to ensure proactive domination. At the end of the day, going forward, a new normal that has evolved from generation X is on the runway heading towards a streamlined cloud solution. User generated content in real-time will have multiple touchpoints for offshoring.</p>

				<p>Capitalize on low hanging fruit to identify a ballpark value added activity to beta test. Override the digital divide with additional clickthroughs from DevOps. Nanotechnology immersion along the information highway will close the loop on focusing solely on the bottom line.</p> -->
				<p>${as.ask}</p>
			</div>

			

			<!-- <div class="single-page-section">
				<h3 class="margin-bottom-25">相似职位</h3>

				Listings Container
				<div class="listings-container grid-layout">

						Job Listing
						<a href="#" class="job-listing">

							Job Listing Details
							<div class="job-listing-details">
								Logo
								<div class="job-listing-company-logo">
									<img src="images/company-logo-02.png" alt="">
								</div>

								Details
								<div class="job-listing-description">
									<h4 class="job-listing-company">Coffee</h4>
									<h3 class="job-listing-title">Barista and Cashier</h3>
								</div>
							</div>

							Job Listing Footer
							<div class="job-listing-footer">
								<ul>
									<li> </li>
									<li> </li>
									<li> </li>
									<li> </li>
								</ul>
							</div>
						</a>

						Job Listing
						<a href="#" class="job-listing">

							Job Listing Details
							<div class="job-listing-details">
								Logo
								<div class="job-listing-company-logo">
									<img src="images/company-logo-03.png" alt="">
								</div>

								Details
								<div class="job-listing-description">
									<h4 class="job-listing-company">King </h4>
									<h3 class="job-listing-title">Restaurant Manager</h3>
								</div>
							</div>

							Job Listing Footer
							<div class="job-listing-footer">
								<ul>
									<li> </li>
									<li> </li>
									<li> </li>
									<li> </li>
								</ul>
							</div>
						</a>
					</div>
					Listings Container / End

				</div> -->
		</div>
		

		<!-- Sidebar -->
		<div class="col-xl-4 col-lg-4">
			<div class="sidebar-container">

				<a href="../seeCV/seeCV.html" class="apply-now-button popup-with-zoom-anim">查看已收简历 </a>
					
				<!-- Sidebar Widget -->
				 <div class="sidebar-widget">
					<div class="job-overview">
						<div class="job-overview-headline">工作详情</div>
						<div class="job-overview-inner">
							<ul>
								<!-- <li>
								
									<span>地点：</span>
									<h5></h5>
								</li> -->
								<li>
									
									<span>工作类型：
										<c:choose> 
										<c:when test="${as.wantJoyType==0}">    <!--如果 --> 
											全职
										 </c:when>
										 <c:when test="${as.wantJoyType==1}">    <!--如果 --> 
										   	 实习
										 </c:when>
										 <c:when test="${as.wantJoyType==2}">    <!--如果 --> 
											兼职
										 </c:when>
										 </c:choose>
									</span>
									<h5></h5>
								</li>
								<li>
									
									<span>工资：
										${as.lowWages} - ${as.largeWages}
									</span>
									<h5></h5>
								</li>
								<li>
									
									<span>招聘截止时间：<fmt:formatDate value="${as.deadline}" pattern="yyyy-MM-dd" /></span>
									<h5></h5>
								</li>
							</ul>
						</div>
					</div>
				</div> 

				

					

					

					

			</div>
		</div>

	</div>
</div>


<!-- Wrapper / End -->

   <!-- 引入底部 -->
		    <jsp:include page="/common/footer.jsp"/>
	



 <script type="text/javascript" src="<%=path %>/resource/static/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</body>
</html>
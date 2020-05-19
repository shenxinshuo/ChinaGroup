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
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/colors/blue.css">
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
		
		<!-- 返回企业中心 -->
		<a href="../business/businessCenter.jsp"><span class="glyphicon glyphicon-chevron-left"></span>返回企业中心</a>
			<!-- Row -->
			<div class="row">

				<!-- Dashboard Box -->
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0">

					

						<div class="content with-padding padding-bottom-10">
							<div class="row">

								<div class="col-xl-4">
									<div class="submit-field">
										<h5>招聘标题</h5>
										<input type="text" class="with-border">
									</div>
								</div>
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>招聘岗位</h5>
										<input type="text" class="with-border">
									</div>
								</div>
								
								<div class="dropdown">
									<h5>工作种类</h5>
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    选择工作种类
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">兼职</a></li>
    <li><a href="#">全职</a></li>
    <li><a href="#">实习</a></li>
    <li role="separator" class="divider"></li>
    
  </ul>
</div>


								
							
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>工资</h5>
										<div class="row">
											<div class="col-xl-6">
												<div class="input-with-icon">
													<input class="with-border" type="text" placeholder="Min">
													<i class="currency">最小</i>
												</div>
											</div>
											<div class="col-xl-6">
												<div class="input-with-icon">
													<input class="with-border" type="text" placeholder="Max">
													<i class="currency">最大</i>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>截止日期</h5>
										<input type="text" class="with-border">
									</div>
								</div>


								<div class="col-xl-4">
									<div class="submit-field">
										<h5>标签   </h5>
										<input type="text" class="with-border">										
									</div>
								</div>
								
								

								<div class="col-xl-12">
									<div class="submit-field">
										<h5>岗位简介</h5>
										<textarea cols="30" rows="5" class="with-border"></textarea>
										
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-xl-12" >
					<a href="#" class="button ripple-effect big margin-top-30"> 	<span class="glyphicon glyphicon-plus"></span>	发布招聘</a>
				</div>

			</div>
			<!-- Row / End -->

			

		


		<!-- 引入底部 -->
		    <jsp:include page="/common/footer.jsp"/>



		<!-- <script src="../jquery/jquery-3.3.1.min.js"></script> -->
		<script type="text/javascript" src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../resource/static/jquery/jquery-1.11.2.min.js"></script>





</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.zhbit.findwork.entity.Business"%>
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
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="<%=path %>/postjob/css/style.css">
    <link rel="stylesheet" href="<%=path %>/postjob/css/colors/blue.css">
    <link rel="stylesheet" href="<%=path %>/header/header.css"/>
	<link rel="stylesheet" href="<%=path %>/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<style>
		.text_time{
			width: 207px;
			height: 35px;
			background: #ffffff;
			border:1px solid #56da9e;		
	}
</style>
	<script type="text/javascript" src="<%=path %>/resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/yufeng/pro_cites.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
				for (var i = 0; i < pro.length; i++) {
					$option = $("<option/>");
					$option.attr("value", pro[i]);
					$option.text(pro[i]);
					$("#province").append($option);
					/* document.getElementById("province").append($option); */
				}
				$("#province").change(function() {

					var cities = city[$(this).val()];
					$("#city").empty();
					$("#city").append("<option value=''>请选择</option>");
					for (var i = 0; i < cities.length; i++) {

						$option = $("<option/>");
						$option.attr("value", cities[i]);
						$option.text(cities[i]);
						$("#city").append($option);
					}
				});
			});
	</script>
	<script type="text/javascript" src="<%=path %>/postjob/js/showdate.js"></script>
	<script type="text/javascript">
		
		function check(){
			var data = $("#addForm").serialize();
			var dataArr = $("#addForm").serializeArray();
			for(var i=0;i<dataArr.length;i++){
				if(dataArr[i].name=="advertise.title"){
					if(dataArr[i].value==""){
						alert("招聘标题不能为空");
						return false;
					}
				}
				if(dataArr[i].name=="advertise.postName"){
					if(dataArr[i].value==""){
						alert("招聘岗位不能为空");
						return false;
					}
				}
				if(dataArr[i].name=="advertise.wantJoyType"){
					if(dataArr[i].value=="请选择工作类型"){
						alert("请选择工作种类");
						return false;
					}
				}
				if(dataArr[i].name=="advertise.lowWages"){
					if(dataArr[i].value==""){
						alert("最低工资不能为空");
						return false;
					}
					
				}
				if(dataArr[i].name=="advertise.largeWages"){
					if(dataArr[i].value==""){
						alert("最高工资不能为空");
						return false;
					}
				}
				if(dataArr[i].name=="advertise.deadline"){
					if(dataArr[i].value=="点击选择截止日期"){
						alert("截止日期不能为空");
						return false;
					}
					
				}
				if(dataArr[i].name=="advertise.ask"){
					if(dataArr[i].value==""){
						alert("岗位简介不能为空");
						return false;
					}
				}
			}
			return true;
		}
		
	
		function addAdvertise() {
			var msg = "确定保存？"; 
    		if (confirm(msg)==true){
    			if(check()){
    				/* var formData = $('form[id="addForm"]').serializeObject();
        			console.log(formData); */
        			 $.ajax({
        			    url:"<%=path %>/addAdvertise.action",    //请求的url地址
        			    //dataType:"json",   //返回格式为json
        			    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        			    data:$("#addForm").serialize(),                    
        			    success:function(req){
        			    	window.location.reload();
        			    	alert("发布成功！");
        			    }
        			}); 
    			}
    		}else{ 
    		} 
		}
		
		function updateAdvertise() {
			var msg = "确定修改？"; 
    		if (confirm(msg)==true){
    			if(check()){
    				/* var formData = $('form[id="addForm"]').serializeObject();
        			console.log(formData); */
        			 $.ajax({
        			    url:"<%=path %>/updateAdvertise.action",    //请求的url地址
        			    //dataType:"json",   //返回格式为json
        			    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
        			    data:$("#addForm").serialize(),                    
        			    success:function(req){
        			    	window.location.href=document.referrer;
        			    	alert("修改成功！");
        			    }
        			}); 
    			}
    		}else{ 
    		} 
		}
	</script>
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
		
		<!-- 返回企业中心 -->
		<a href="FindWork/business_showBusinessCenter.action?business.id=<%=((Business)session.getAttribute("LOGINED_USER")).getId() %>&currentPage=1"><span class="glyphicon glyphicon-chevron-left"></span>返回企业中心</a>
			<!-- Row -->
			<div class="row">

				<!-- Dashboard Box -->
				<div class="col-xl-12">
					<div class="dashboard-box margin-top-0">

					
					<form id="addForm">
						<div class="content with-padding padding-bottom-10">
							<div class="row">

								<div class="col-xl-4">
									<div class="submit-field">
										<h5>招聘标题</h5>
										<input name="advertise.title" value="${advertise.title}" type="text" class="with-border">
									</div>
								</div>
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>招聘岗位</h5>
										<%-- <input  name="advertise.postName"  value="${advertise.postName}" type="text" class="with-border"> --%>
										<select  name="advertise.post.Pid"  style="width: 250px;" class="combobox">
										                <c:forEach items="${l}" var="d">
										                    <option value="${d.value}" <c:if test="${d.value==advertise.post.Pid}"> selected</c:if> >
										                            ${d.name}
										                    </option>
										                </c:forEach>
										</select>
									</div>
								</div>
								
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>工作种类</h5>
										
										
										<c:choose> 

										     <c:when test="${isEdit==1}">    <!--如果 --> 
													<select  name="advertise.wantJoyType"  style="width: 250px;" class="combobox">
										                <c:forEach items="${advertiseType}" var="d">
										                    <option value="${d.value}"<c:if test="${d.value==advertise.wantJoyType}"> selected</c:if>>
										                            ${d.name}
										                    </option>
										                </c:forEach>
										            </select>
										 	  </c:when>      
										
										     <c:otherwise>  <!--否则 -->    
														<select  name="advertise.wantJoyType"  value="${advertise.wantJoyType}" style="width: 250px;" class="combobox">
															  <option>请选择工作类型</option>
															  <option value="全职">全职</option>
															  <option value="实习">实习</option>
															  <option value="兼职">兼职</option>
														</select> 
										  	</c:otherwise> 
										
										</c:choose>
									</div>
								</div>
								
								
	<!-- 							<div class="dropdown">
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
</div> -->


								
							
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>工资</h5>
										<div class="row">
											<div class="col-xl-6">
												<div class="input-with-icon">
													<input name="advertise.lowWages"   value="${advertise.lowWages}" class="with-border" type="number" placeholder="Min">
													<i class="currency">最小</i>
												</div>
											</div>
											<div class="col-xl-6">
												<div class="input-with-icon">
													<input name="advertise.largeWages"  value="${advertise.largeWages}" class="with-border" type="number" placeholder="Max">
													<i class="currency">最大</i>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>截止日期</h5>
										<!-- <input type="text" class="with-border"> -->
										<input type="text" id="time" readonly="readonly"  name="advertise.deadline" value="<fmt:formatDate value="${advertise.deadline}" pattern="yyyy-MM-dd" />" onClick="return Calendar('time');" class="text_time"/>
									</div>
								</div>


								<div class="col-xl-4">
									<div class="submit-field">
										<h5>学历背景   </h5>
										<input type="text" name="advertise.educationBackground" value="${advertise.educationBackground}" class="with-border">										
									</div>
								</div>
								
								<div class="col-xl-4">
									<div class="submit-field">
										<h5>地区</h5>
										<div class="row">
											<div class="col-xl-6">
												<div class="input-with-icon">
													<select name="advertise.province" id="province"  class="form-control" style="width:130px;">
				                                        <option value="" >选择省份</option>
				                                    </select>
												</div>
											</div>
											<script type="text/javascript">
												console.log(pro);
											</script>
											<div class="col-xl-6">
												<div class="input-with-icon">
													<select name="advertise.city" id="city"  class="form-control" style="width:130px;">
				                                        <option value="" >选择城市</option>
				                                    </select>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								

								<div class="col-xl-12">
									<div class="submit-field">
										<h5>岗位要求</h5>
										<textarea cols="30" rows="5" name="advertise.ask"  class="with-border"><c:if test="${isEdit==1}">${advertise.ask}</c:if></textarea>
										
									</div>
								</div>

							</div>
						</div>
							<input type="hidden"  name="advertise.id" value="${advertise.id}">
							<input type="hidden"  name="advertise.check" value="${advertise.check}">
							<input type="hidden"  name="advertise.business.id" value="${advertise.business.id}">
							<input type="hidden"  name="advertise.city" value="${advertise.city}">
							<input type="hidden"  name="advertise.businessName" value="${advertise.businessName}">
						</form>
					</div>
				</div>
				<div class="col-xl-12" >
					
						<c:choose> 

										     <c:when test="${isEdit==1}">    <!--如果 --> 
													<a href="#" onclick="javascript:updateAdvertise();" class="button ripple-effect big margin-top-30"> 	<span class="glyphicon glyphicon-plus"></span>	
														保存修改后招聘信息
														</a>
										 	  </c:when>      
										
										     <c:otherwise>  <!--否则 -->    
										     		<a href="#" onclick="javascript:addAdvertise();" class="button ripple-effect big margin-top-30"> 	<span class="glyphicon glyphicon-plus"></span>	
													 保存招聘信息
													 </a>
										  	</c:otherwise> 
										
										</c:choose>
				</div>

			</div>
			<!-- Row / End -->

			

		


		<!-- 引入底部 -->
		    <jsp:include page="/common/footer.jsp"/>



		<!-- <script src="../jquery/jquery-3.3.1.min.js"></script> -->
		<!-- <script src="../jquery/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


	
<%-- <script src="<%=path %>/jquery/jquery-migrate-3.0.0.min.js"></script>
<script src="<%=path %>/jquery/bootstrap-slider.min.js"></script>
<script src="<%=path %>/jquery/bootstrap-select.min.js"></script> --%>
<script type="text/javascript" src="<%=path %>/resource/static/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</body>
</html>
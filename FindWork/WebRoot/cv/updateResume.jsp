<%@page import="com.zhbit.findwork.entity.Cv"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改简历</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/shiping/updateResume.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/yufeng/pro_cites.js"></script>
	<script type="text/javascript">
	
			$(document).ready(function(){
				for (var i = 0; i < pro.length; i++) {
					$option = $("<option/>");
					$option.attr("value", pro[i]);
					if("${cv.live_province}" == pro[i]){
						$option.attr("selected",true);
					}
					$option.text(pro[i]);
					$("#province").append($option);
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
		<script>
			$(document).ready(function() {
				for (var i = 0; i < pro.length; i++) {
					$option = $("<option/>");
					$option.attr("value", pro[i]);
					if("${cv.want_province}" == pro[i]){
						$option.attr("selected",true);
					}
					$option.text(pro[i]);
					$("#province1").append($option);
				}
				$("#province1").change(function() {
					var cities = city[$(this).val()];
					$("#city1").empty();
					$("#city1").append("<option value=''>请选择</option>");
					for (var i = 0; i < cities.length; i++) {
						$option = $("<option/>");
						$option.attr("value", cities[i]);
						$option.text(cities[i]);
						$("#city1").append($option);
					}
				});
			});
		</script>
  </head>
  
  <body>
  <%
  	Cv cv = (Cv)request.getAttribute("cv");
   %>
  	<!-- 引入头部 -->
	<jsp:include page="/common/header.jsp" />
	<!-- 提示信息 -->
    <s:if test="message == null">
    		
    </s:if>
    <s:else>
    	<div class="alert alert-success" role="alert">${message }</div>
    </s:else>
    <s:url id="cv_update" action="cv_update" namespace="/" />
    <form class="form-horizontal" action="${cv_update }" method="post" enctype="multipart/form-data">
    <input type="hidden" name="cv.id" value="${cv.id}">
    	<!-- 修改简历信息页面 -->
	<div class="off_info">
		 	<div>
				<img class="a0" src="cv/image/e1.png" />
		 	 <a href="javascript:history.go(-1)"><span style="font-size: 30px;color: dodgerblue;" class="glyphicon glyphicon-remove"></span>			
			</a></div>
			<div>
				<img class="img1" src="cv/image/u18.png" />
				<img class="img2" src="cv/image/u16.png" />
			</div>
			<div class="a1">
				<span  class="label label-default1">基本信息</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="d-inline-block col-md-12">
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["name"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_low_wages"][0] }</label>
                </div>
            </div>
			<div class="a2">
				<span class="input-group-addon1" >姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
  				<s:textfield name="cv.name" value="%{#request.cv.name}" /> 
  				<span  id="basic-addon2">期望最低工资：</span>
  				<input type="text" name="cv.want_low_wages" value="${cv.want_low_wages }" class="form-control3">
			</div>
			<div class="d-inline-block col-md-12">
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["telephone"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_large_wages"][0] }</label>
                </div>
            </div>
			<div class="a3">
				<span class="input-group-addon1" >联系方式：</span>
  				<s:textfield name="cv.telephone" vlaue="%{#request.cv.telephone}" />
 				<span id="basic-addon2">期望最高工资：</span>
  				<input type="text" name="cv.want_large_wages" value="${cv.want_large_wages}" class="form-control3">
			</div>
			<div class="d-inline-block col-md-12">
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["live_province"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_province"][0] }</label>
                </div>
            </div>
			<div class="a3">
				<span class="input-group-addon1 " >居住省份：</span>
				<select class="form-control2" name="cv.live_province" id="province"   style="width: 100px;">
					<option value="">请选择</option>
				</select>
  				<span  id="basic-addon3">想&nbsp;去&nbsp;的&nbsp;省份：</span>
  				<select class="form-control2" name="cv.want_province" id="province1"  style="width: 100px;" >
					<option value="">请选择</option>
				</select>
			</div>
			<div class="d-inline-block col-md-12">
			 	<div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["live_city"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_city"][0] }</label>
                </div>
             </div>
			<div class="a3">
				<span class="input-group-addon1 " >居住城市：</span>
		 		<select class="form-control2" name="cv.live_city" id="city"   style="width: 100px;">
					<option value="">请选择</option>
					<s:if test="cv.live_city !=null">
						<option value="${cv.live_city }" selected="selected">${cv.live_city }</option>
					</s:if>
				</select>
		 		<span id="basic-addon3">想&nbsp;去&nbsp;的&nbsp;城市：</span>
		 		<select class="form-control2" name="cv.want_city" id="city1"   style="width: 100px;">
					<option value="">请选择</option>
					<s:if test="cv.want_city !=null">
						<option value="${cv.want_city }" selected="selected">${cv.want_city }</option>
					</s:if>
				</select>
			</div>
			<div class="d-inline-block col-md-12">
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["politics_status"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_joy_type"][0] }</label>
                </div>
            </div>
			<div class="a3">
				<span class="input-group-addon1" >政治面貌：</span>
  				<s:textfield name="cv.politics_status" vlaue="%{#request.cv.politics_status}" />
		 		<span id="basic-addon2">期望工作类型：</span>
		 		<s:radio list="{'实习','兼职','全职'}" name="cv.want_joy_type" value="#request.cv.want_joy_type" />
			</div>
			<div class="d-inline-block col-md-12">
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-3">${fieldErrors["education_background"][0] }</label>
                </div>
                <div class="col-md-6">
                	<label for="" class="text-danger col-md-offset-0">${fieldErrors["want_post"][0] }</label>
                </div>
            </div>
			<div class="a3">
				<span class="input-group-addon1">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span>
  				<s:textfield name="cv.education_background" vlaue="%{#request.cv.education_background}" />
		 		<span id="basic-addon2">求&nbsp;职&nbsp;&nbsp;意&nbsp;向&nbsp;&nbsp;&nbsp;：</span>
  				<s:textfield name="cv.want_post" vlaue="%{#request.cv.want_post}" />
			</div>
			<div class="a4">
				<span  class="label label-default1">工作经历</span>
			</div>
			<div class="a5">
				<textarea  class="form-control1" name="cv.experience"  >${request.cv.experience }</textarea>
			</div>
			<div class="a4">
				<span  class="label label-default1">特长、技能</span>
			</div>
			<div class="a5">
				<textarea  class="form-control1" name="cv.skill"  >${request.cv.skill }</textarea>
			</div>
			<div class="a4">
				<span  class="label label-default1">自我介绍</span>
			</div>
			<div class="a5">
				<textarea  class="form-control1" name="cv.self"  >${request.cv.self }</textarea>
			</div>
			<div class="a6">
				<button type="submit" class="submit">保存</button>
			</div>
			<div class="a6"></div>
	</div>
    </form>
		 <div class="a7"></div>
    <!-- 引入底部 -->
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>

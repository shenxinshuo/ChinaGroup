<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'cv.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/shiping/resume.css">
		<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<script type="text/javascript" src="js/yufeng/pro_cites.js"></script>
		<script>
			

			$(document).ready(function() {
				for (var i = 0; i < pro.length; i++) {
					$option = $("<option/>");
					$option.attr("value", pro[i]);
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
	<!-- 引入头部 -->
	<jsp:include page="/common/header.jsp" />
	<!-- 提示信息 -->
    <s:if test="errorMessage == null">
	    		
	</s:if>
	<s:else>
		<div class="alert alert-danger" role="alert">${errorMessage }</div>
	</s:else>
    	
    <!-- 注册表单 -->
    <s:url id="cv_add" action="cv_add" namespace="/" /> 
    <form class="form-horizontal" action="${cv_add }" method="post" enctype="multipart/form-data">
	<!-- 简历信息页面 -->
	<div class="off_info">
	
    		<div>
			<img class="a0" src="cv/image/e1.png" /> 
			<a href="javascript:history.go(-1)"><span style="font-size: 30px;color: dodgerblue;" class="glyphicon glyphicon-remove"></span>
			</a>
			</div>
			<div>
				<img class="img1" src="cv/image/u18.png" /> 
				<img class="img2" src="cv/image/u16.png" />
			</div>
			<div class="a1">
				<span class="label label-default1">基本信息</span>
				<hr width="800px" color="black" size="1" />
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
				<span class="input-group-addon1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
				<s:textfield name="cv.name" class="form-control2" /> 
				<span id="basic-addon2">期望最低工资：</span>
				<input type="text" name="cv.want_low_wages" value="${cv.want_low_wages }" class="form-control3" >
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
				<span class="input-group-addon1">联系方式：</span> 
				<s:textfield name="cv.telephone" class="form-control2" /> 
				<span id="basic-addon2">期望最高工资：</span>
				<input type="text" name="cv.want_large_wages" value="${cv.want_large_wages }" class="form-control3" />
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
				<span class="input-group-addon1">居住省份：</span> 
                <select class="form-control2" name="cv.live_province" id="province"  style="width: 100px;">
					<option value="">请选择</option>
				</select>
				<span id="basic-addon3">想&nbsp;去&nbsp;的&nbsp;省份：</span>
				<select class="form-control2" name="cv.want_province" id="province1"  style="width: 100px;">
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
				<span class="input-group-addon1">居住城市：</span> 
                <select class="form-control2" name="cv.live_city" id="city"  style="width: 100px;">
					<option value="">请选择</option>
				</select>
				<span id="basic-addon3">想&nbsp;去&nbsp;的&nbsp;城市：</span>
				<select class="form-control2" name="cv.want_city" id="city1"  style="width: 100px;">
					<option value="">请选择</option>
				</select>
				<!-- <input type="text" class="form-control2" name="cv.want_province" > -->
				 <%-- <select name="cv.want_province"  class="form-control2">
                	<option value="广东">广东</option>
                	<option value="江西" >江西</option>
                	<option value="湖北" >湖北</option>
                </select> --%>
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
				<span class="input-group-addon1">政治面貌：</span> 
				<s:textfield name="cv.politics_status" class="form-control2" /> 
				<span id="basic-addon2">期望工作类型:</span>
				<s:radio list="{'实习','兼职','全职'}" name="cv.want_joy_type"></s:radio>
				<%-- <select name="cv.want_city"  class="form-control2">
                	<option value="珠海">珠海</option>
                	<option value="深圳" >深圳</option>
                	<option value="武汉" >武汉</option>
                	<option value="南昌" >南昌</option>
                </select> --%>
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
				<s:textfield name="cv.education_background" class="form-control2" />
				<span id="basic-addon2">求&nbsp;职&nbsp;&nbsp;意&nbsp;向&nbsp;&nbsp;&nbsp;：</span>
				<s:textfield name="cv.want_post" class="form-control2" />
			</div>
			<div class="a4">
				<span class="label label-default1">工作经历</span>
			</div>
			<div class="a5">
				<textarea  class="form-control1" name="cv.experience"  >${cv.experience}</textarea>
			</div>
			<div class="a4">
				<span class="label label-default1">特长、技能</span>
			</div>
			<div class="a5">
				<textarea class="form-control1" name="cv.skill" >${cv.skill}</textarea>
			</div>
			<div class="a4">
				<span class="label label-default1">自我介绍</span>
			</div>
			<div class="a5">
				<textarea  class="form-control1" name="cv.self" >${cv.self}</textarea>
			</div>
			<div class="a6">
				<button type="submit" class="submit">保存</button>
				<button type="reset" class="reset">删除</button>
			</div>
			<div class="a6"></div>
	</div>
    </form>
	<div class="a7"></div>
	
	<!-- 引入底部 -->
	<jsp:include page="/common/footer.jsp" />
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/shiping/showResume.css">

  </head>
  
  <body>
   <!-- 引入头部 -->
	<jsp:include page="/common/header.jsp" />
	<!-- 查看简历信息页面 -->
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
			<div class="a2">
				<span class="input-group-addon1" >姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</span>
				<input type="text" class="form-control2" value="${cv.live_province }"  readonly>
				<span  id="basic-addon2">期望最低工资：</span>
				<input type="text" class="form-control2" value="${cv.want_low_wages }"  readonly>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >联系方式：</span>
				<input type="text" class="form-control2" value="${cv.telephone }"  readonly>
				<span id="basic-addon2">期望最高工资：</span>
				<input type="text" class="form-control2" value="${cv.want_large_wages }"  readonly>
				
			</div>
			<div class="a3">
				<span class="input-group-addon1" >居住省份：</span>
				<input type="text" class="form-control2" value="${cv.live_province}"  readonly>
  				<span id="basic-addon2">期望工作类型：</span>
  				<input type="text" class="form-control2" value="${cv.want_joy_type}"  readonly>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >居住城市：</span>
				<input type="text" class="form-control2" value="${cv.live_city}"  readonly>
		 		<span  id="basic-addon2">想&nbsp;去&nbsp;的&nbsp;省份：</span>
		 		<input type="text" class="form-control2" value="${cv.want_province}"  readonly>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >政治面貌：</span>
				<input type="text" class="form-control2" value="${cv.politics_status}"  readonly>
		 		<span id="basic-addon2">想&nbsp;去&nbsp;的&nbsp;城市：</span>
		 		<input type="text" class="form-control2" value="${cv.want_city}"  readonly>
			</div>
			<div class="a3">
				<span class="input-group-addon1">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span>
		 		<input type="text" class="form-control2" value="${cv.education_background}"  readonly>
		 		<span id="basic-addon2">求&nbsp;职&nbsp;&nbsp;意&nbsp;向&nbsp;&nbsp;&nbsp;：</span>
		 		<input type="text" class="form-control2" value="${cv.want_post}"  readonly>
		 		<hr width="800px" color="black" size="1"/>
			</div>
			<div class="a4">
				<span  class="label label-default1">工作经历</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="input-group-addon2">
				<s:property value="cv.experience"  />
			</div>
			<div class="a4">
				<span  class="label label-default1">特长、技能</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="input-group-addon2">
				<s:property value="cv.skill"  />
			</div>
			<div class="a4">
				<span  class="label label-default1">自我介绍</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="input-group-addon2">
				<s:property value="cv.self"  />
			</div>
			<div class="a6"></div>
		 </div>
		 <div class="a7"></div>
	<!-- 引入底部 -->
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>

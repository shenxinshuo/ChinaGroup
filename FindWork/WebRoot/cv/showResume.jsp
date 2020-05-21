<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showResume.jsp' starting page</title>
    
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
				<span style="font-size: 30px;color: dodgerblue;" class="glyphicon glyphicon-remove"></span>
			</div>
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
  				<span  id="basic-addon2">期望最低工资：</span>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >联系方式：</span>
 				<span id="basic-addon2">期望最高工资：</span>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >居住省份：</span>
  				<span id="basic-addon2">期望工作类型:</span>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >居住城市：</span>
		 		<span  id="basic-addon2">想&nbsp;去&nbsp;的&nbsp;省份：</span>
			</div>
			<div class="a3">
				<span class="input-group-addon1" >政治面貌：</span>
		 		<span id="basic-addon2">想&nbsp;去&nbsp;的&nbsp;城市：</span>
			</div>
			<div class="a3">
				<span class="input-group-addon1">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span>
		 		<span id="basic-addon2">求&nbsp;职&nbsp;&nbsp;意&nbsp;向&nbsp;&nbsp;&nbsp;：</span>
		 		<hr width="800px" color="black" size="1"/>
			</div>
			<div class="a4">
				<span  class="label label-default1">工作经历</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="a4">
				<span  class="label label-default1">特长、技能</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="a4">
				<span  class="label label-default1">自我介绍</span>
				<hr width="800px" color="black" size="1"/>
			</div>
			<div class="a6"></div>
		 </div>
		 <div class="a7"></div>
	<!-- 引入底部 -->
	<jsp:include page="/common/footer.jsp" />
  </body>
</html>

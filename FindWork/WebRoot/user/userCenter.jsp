<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
  </head>
   
  <body> 
  <!-- 引入头部  -->
    <jsp:include page="/common/header.jsp"/>
  <div class="wdld11">
		<div class="wdld12">
			<p class="glyphicon glyphicon-th" style="width: 150px;margin: 10px 0px 0px 10px; font-size: 20px;color: white;">个人中心</p>
			<a href="#" style="float: right;margin: 12px 20px ;"><p style="font-size: 20px;color: white;" class="glyphicon glyphicon-share-alt">返回</p></a>
			</div>			
		<div class="wdld13" style="margin-left: 10px;">
			  <ul class="nav nav-pills nav-stacked">
				<li role="presentation"><a href="/FindWork/user/myResume.jsp" target="showCenterOfPersan" class="glyphicon glyphicon-home">&nbsp;个人简历</a></li>
				<li role="presentation"><a href="/FindWork/myInformation_show.action" target="showCenterOfPersan"  class="glyphicon glyphicon-user">&nbsp;我的信息</a></li>
				<li role="presentation"><a href="/FindWork/user/myHeader.jsp" target="showCenterOfPersan"  class="glyphicon glyphicon-picture">&nbsp;我的头像</a></li>
				<li role="presentation"><a href="/FindWork/user/accountSecurity.jsp" target="showCenterOfPersan"  class="glyphicon glyphicon-cloud">&nbsp;账号安全</a></li>
			</ul>
		</div>
		<div class="wdld14">
			<iframe name="showCenterOfPersan" 
			frameborder=0 width=800 height=500
			marginheight=0 marginwidth=0 scrolling=no
			src="/FindWork/user/myResume.jsp"></iframe>
		</div>
	</div>	
	   <!-- 引入底部 -->
    <jsp:include page="/common/footer.jsp"/>	
   
  </body>
</html>
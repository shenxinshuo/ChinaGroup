<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>精英招聘</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/User_home_page.css" />
	<link rel="stylesheet" href="css/yufeng/header.css" />
	<link rel="stylesheet" href="resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
  </head>
  
  <body>
		<!-- 引入头部 -->
    	<jsp:include page="/common/header.jsp"/>

		<div class="main_body">
			<div class="div_search" style="">
				<%-- <div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="岗位 / 公司">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 --> --%>
				
				 <div class="col-lg-6 ">
				    <div class="input-group col-md-8">
				      <input type="text" id="searchName" class="form-control" aria-label="..."  placeholder="岗位 / 公司   点击右方按钮切换搜索方式">
				      <div class="input-group-btn">
				        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">GO! <span class="caret"></span></button>
				        <ul class="dropdown-menu dropdown-menu-right">
				          <li><a id="advertiseSearch" href="" onclick="searchWithAdvertise()">招聘信息</a></li>
				         
				          <li><a id="businessSearch" href="" onclick="searchWithBusiness()">公司</a></li>
				        </ul>
				      </div><!-- /btn-group -->
				    </div><!-- /input-group -->
				  </div><!-- /.col-lg-6 -->
				
			</div><!-- /.row -->
		</div>
		<!-- 根据搜索方式的不同去不同的action搜索 -->
		<!-- 动态设置a标签的href属性，接收用户输入的值 -->
		<script type="text/javascript">
			function searchWithBusiness() {
				var searchName = document.getElementById("searchName").value;
				var requestPath = "business_searchByName.action?currentPage=1&searchName="+searchName;
				//alert(requestPath);
				document.getElementById("businessSearch").href=requestPath;
			}
			function searchWithAdvertise() {
				var searchName = document.getElementById("searchName").value;
				var requestPath = "search_getAdvertisesByPostSearch.action?postName="+searchName;
				//alert(requestPath);
				document.getElementById("advertiseSearch").href=requestPath;
			}		
		</script>
		<div class="div_title">
			<label class="label label-danger">热门岗位</label>
			<a class="types" href="#">证券</a>
			<a class="types" href="#">C++</a>
			<a class="types" href="#">PHP</a>
			<a class="types" href="#">Web前端</a>
			<a class="types" href="#">UI设计师</a>
			<a class="types" href="#">平面设计师</a>
		</div>

		<div style="width: 100%;height: 400px;">
			<div class="offer_info">
				
				<s:if test="pts!=null">
					<s:iterator value="pts">
					<div class="type">
						<label class="offer_type"><s:property value="PTname"/></label>
						<%-- <a class="offer_type" href="#"><s:property value="PTname"/></a> --%>
						<s:iterator value="posts">
							<s:url id="search_getAdvertisesByPostSearch" action="search_getAdvertisesByPostSearch" namespace="/" >
								<s:param name="postName">${Pname }</s:param>
							</s:url>
							<a class="types" href="${search_getAdvertisesByPostSearch }"><s:property value="Pname"/></a>
						</s:iterator>
					</div>
					</s:iterator>
				</s:if>
				
			</div>

			<div class="ad_info">

				<div class="row_1">
				   <a href="${url[1]}" target="_blank" ><img class="ad_img1" src="ad_readHeader.action?ad.position=1" /></a>
				    <a href="${url[2]}" target="_blank" ><img class="ad_img2" src="ad_readHeader.action?ad.position=2" /></a>
				</div>
				<div class="row_2">
					<a href="${url[3]}" target="_blank" ><img class="ad_img3" src="ad_readHeader.action?ad.position=3" /></a>
					<a href="${url[4]}" target="_blank" ><img class="ad_img4" src="ad_readHeader.action?ad.position=4" /></a>
				</div>
				<div class="row_3">
					<a href="${url[5]}" target="_blank" ><img class="ad_img5" src="ad_readHeader.action?ad.position=5" /></a>
				</div>
			</div>
		</div>

		<div class="hot_jobs">

			<div class="hot_jobs_title">
				<label>______</label>
				<label>热门公司</label>
				<label>______</label>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg2.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg1.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg3.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="business_searchByName.action?searchName=腾讯">腾讯</a>
						<label>广东 | 深圳</label>
						<!-- <h3>15k - 25k</h3> -->
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg5.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg4.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg6.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="business_searchByName.action?searchName=远光">远光</a>
						<label>广东 | 珠海</label>
						<!-- <h3>15k - 25k</h3> -->
					</div>
				</div>
			</div>

			<div class="hot_jobs_content">
				<div class="job1">
					<div class="job1_left">
						<img src="resource/image/yufeng/jimg7.jpg" />
					</div>
					<div class="job1_mid">
						<div class="mid_img1">
							<img src="resource/image/yufeng/jimg9.jpg" />
						</div>
						<div class="mid_img2">
							<img src="resource/image/yufeng/jimg8.jpg" />
						</div>
					</div>
					<div class="job1_right">
						<a href="business_searchByName.action?searchName=华为">华为</a>
						<label>中国 | 深圳</label>
						<!-- <h3>15k - 25k</h3> -->
					</div>
				</div>
			</div>
		</div>

		<!-- 引入底部 -->
    	<jsp:include page="/common/footer.jsp"/>
		<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	</body>
</html>

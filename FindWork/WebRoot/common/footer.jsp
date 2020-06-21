<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网站底部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<style type="text/css">
		#footer{
		　　position: fixed;
		　　right: 0;
		　　left: 0;
		　　z-index: 1030;
		　　bottom: 0;
		　　margin-bottom: 0;
		}
	</style>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
    <!-- 网站底部 -->
    <div id="footer">
    	<div class="nav-fixed-bottom">
	        <div class="panel panel-default" style="margin:0px;">
	            <div class="panel-heading">
	                <div style="width: fit-content; margin:0 auto;">
	                    <a href="">联系我们</a> 
	                    &nbsp;|&nbsp;
	                    <a href="">用户反馈</a> 
	                    &nbsp;|&nbsp;
	                    <a href="">举报违规行为</a> 
	                    <br>
	                    <p style="width: fit-content; margin:0 auto;" class="text-warning">吃着苦瓜，告诉自己，生活是甜的</p>
	                </div>
	                <div style="display: inline-block;">
	                    友情链接：<a href="https://www.bootcss.com"><p class="text-info">bootstrap3中文文档</p></a>
	                </div>
	            </div>
	          </div>
	    </div>
    </div>
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePost.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/yufeng/CheckReInfo.css" />
	<script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function js_method (){
			alert("确认删除该广告吗？");
		}
		

	</script>
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    
    
     <!--新增角色-->
    <div class="container col-md-offset-2">
       <jsp:include page="leftMenu.jsp" >
        	<jsp:param value="add" name="currentPage"/>
        </jsp:include>
        <!--面板-->
        <div class="check_right">
				<table class="table table-hover" style="width: 600px;margin-top: 30px;">					
					<s:if test="ads!=null">
						<tr>
						<td style="width: 400px;color:#8C8C8C;">广告标题</td>
						<td style="width: 100px;color:#8C8C8C;">广告位</td>
						<td style="width: 200px;"></td>
					    </tr>					
						<s:iterator value="ads" >
							<tr>
								<th style="width: 100px;"><s:property value="topic"/></th>
								<th style="width: 100px;"><s:property value="position"/></th>	
								<th style="width: 200px;">
									<a  onclick ="js_method()" href="ad_deleteById.action?ad.id=<s:property value='id'/>" style="">删除</a>
									<a href="ad_showChange.action?ad.id=<s:property value='id'/>" style="">修改</a>
								</th>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						暂无广告，请添加
					</s:else>
					
				</table>			
			</div>
        </div>


    </div>
    
    
    
     <jsp:include page="/common/footer.jsp" />
  </body>
</html>

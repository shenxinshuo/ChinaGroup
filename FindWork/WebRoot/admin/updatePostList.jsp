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
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function js_method (){
			alert("确认删除该岗位吗？");
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
				<table class="table table-hover" style="width: 500px;margin-top: 30px;">
				
					<s:if test="posts!=null">
						<s:iterator value="posts" >
							<tr>
								<th style="width: 400px;"><s:property value="Pname"/></th>
								<th style="width: 200px;">
									<a  onclick ="js_method()" href="post_deletePost.action?post.Pid=<s:property value='Pid'/>" style="">删除</a>
									<a href="post_showUpdatePost.action?post.Pid=<s:property value='Pid'/>" style="">修改</a>
								</th>
							</tr>
						</s:iterator>
					</s:if>
					<s:else>
						暂无审核数据
					</s:else>
					
				</table>
				
				<s:if test="posts!=null">
				
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				    <li>
				      <a href="post_toUpdatePost.action?currentPage=1" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				  
				    <s:if test="plist!=null">
						<s:iterator value="plist" id='number'>
							<li><a href="post_toUpdatePost.action?currentPage=<s:property value='number'/>"><s:property value='number'/></a></li>
						</s:iterator>
					</s:if>
				    
				    <li>
				      <a href="post_toUpdatePost.action?currentPage=${totalPages }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
				
				</s:if>
			</div>
        </div>


    </div>
    
    
    
     <jsp:include page="/common/footer.jsp" />
  </body>
</html>

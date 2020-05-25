	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>已收简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="<%=request.getContextPath() %>/css/delue/wangdelue.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
  
     <!--查看简历-->
    <div class="container">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left" style="color: white;"></span> </a>
                    &nbsp;
                    投递到该招聘的简历列表
                </div>
                <div class="panel-body">
                    <div class="page-header">
                        <h1>查看已投递简历 <small> 总数&nbsp;<span class="badge">${count }</span></small></h1>
                      </div>
					
					<table style="width: 95%;text-align:center; margin: 30px auto;"   cellspacing=0  >
		<tr style="background-color: #f5f5f5;"><td style="color: #8C8C8C; height: 35px;">姓名</td>
		<td style="color: #8C8C8C;height: 35px;">学历</td>
		<td style="color: #8C8C8C;height: 35px;">求职意向</td>
		<td style="color: #8C8C8C;height: 35px;">最低工资</td>
		<td style="color: #8C8C8C;height: 35px;">工作类型</td></tr>
		<s:if test="cvs1==null||cvs1.size()==0">
			<tr><td colspan="5">还没有投递的简历，尽请期待。</td></tr>
		</s:if>		
		<s:else>
	
	   <s:iterator id="cv" value="cvs1">
				<s:url id="showcv" action="cv_showCV" namespace="/">
					<s:param name="cv.id">${cv.id }</s:param>
				</s:url>					
		<tr><td><a href="${showcv}" target="_parent"><s:property value="#cv.name"/></a></td> 
		<td><s:property value="#cv.education_background"/></td>
		<td><s:property value="#cv.want_post"/></td>
		<td>
		<s:property value="#cv.want_low_wages"/></td>
		<td>
		<s:property value="#cv.want_joy_type"/></td>
		</tr>
		
		</s:iterator>
	
	     </s:else>	
	</table>
	
	
	<!-- 分页 -->	
		<div style="margin-left:45%">	
		<nav aria-label="Page navigation">
				  <ul class="pagination">
				    <li>
				      <a href="showReceivedCV.action?currentPage=1" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				  
				    <s:if test="plist!=null">
						<s:iterator value="plist" id='number'>
							<li><a href="showReceivedCV.action?currentPage=<s:property value='number'/>"><s:property value='number'/></a></li>
						</s:iterator>
					</s:if>
				    
				    <li>
				      <a href="showReceivedCV.action?currentPage=${totalPages }" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>			
																				                    
                 </div>	                        
                 </div>
            </div>
        </div>

    </div>
    
    <!-- 引入底部 -->
    <jsp:include page="/common/footer.jsp"/>
    <script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>
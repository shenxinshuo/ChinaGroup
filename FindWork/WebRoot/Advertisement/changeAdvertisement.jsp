<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改广告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  
  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    
    
    
    <div class="container col-md-offset-2">
       <jsp:include page="leftMenu.jsp" >
        	<jsp:param value="update" name="currentPage"/>
        </jsp:include>
       
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">修改广告</h3>
                </div>
                <div class="panel-body">
                	<s:if test="errorMessage == null">
                	</s:if>
                	<s:else>
                		<div class="alert alert-danger" role="alert">${errorMessage }</div>
                	</s:else>
                    <form action="changeAD.action" class="form-horizontal" method="post" enctype="multipart/form-data">
                    	 <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.topic[0] }</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">广告标题</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="ad.topic" value="${ad.topic}" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.cost[0] }</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">广告费用</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="ad.cost" value="${ad.cost}" class="form-control">
                            </div>
                        </div>
                         <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.url[0] }</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">广告链接</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="ad.url" value="${ad.url}" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.picture[0] }</label>
                            </div>
                        </div>            
                         <s:hidden name="ad.id" value="%{#request.ad.id}"></s:hidden>                   
                         <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.business[0] }</label>
                            </div>
                         </div>  
                         <div class="form-group">
                            <label for="" class="control-label col-md-2">投资企业</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="businessName" value="${businessName}" class="form-control">
                            </div>
                        </div> 
                         <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors.id[0]}</label>
                            </div>
                         </div>       
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">广告位</label>
                            <select name="ad.position" class="form-control" style="width:200px"> 
                            	<option>--请选择广告位--</option>
									<c:forEach items="${adids}" var="adid">
										<c:choose>
											<c:when test="${ adid == ad.position}">
												<option value="${adid}" selected="selected">第${adid}位</option>
											</c:when>
											<c:otherwise>
												<option value="${adid}">第${adid}位</option>
											</c:otherwise>
										</c:choose>
										
									</c:forEach>
                            </select>
                        </div>      
                        <div class="btn btn-group form-group">
                            <input type="submit" class="btn btn-primary">
                            <input type="reset" class="btn btn-default">
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>
    
    
    
     <jsp:include page="/common/footer.jsp" />
  </body>
</html>

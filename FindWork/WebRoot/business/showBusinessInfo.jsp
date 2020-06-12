<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>展示企业信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="resource/static/jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  
  <body>
   	<jsp:include page="/common/header.jsp"></jsp:include>
   	
   	
   	<script type="text/javascript">
   		//接收举报处理结果
   		
   		if ("${message}" != "") {
   			alert("${message}");
   		}
   	</script>
   	
   	<!-- 显示企业信息 -->
   	<div class="container" style="margin-top: 50px;">
	    <div class="col-md-10 col-md-offset-1">
	        <div class="panel panel-info ">
	            <div class="panel-heading">
	                <a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left"
	                     style="margin-top: 8px;margin-bottom: 8px;"   ></span> </a>
	                展示企业信息	                          
	                      	               	         
	                <button class="btn btn-default" style="float: right;">
	                    <a href="collection_addBusiness.action?business.id=${business.id }">收藏&nbsp;<span class="glyphicon glyphicon-star" style=""></span></a>
	                </button>
	                <button type="button" class="btn btn-default" style="float:right;" data-toggle="modal" data-target="#myModal">
  						举报
					</button>
	                	<!-- 提示信息 -->
	                <p class="text-danger">${errorMessage }</p>
	                <%--  <p class="text-danger">${message }</p> --%>
	            </div>
	            
	            <div class="panel-body">
	            
	               
	                
	                <form class="form-horizontal" action="${business_update }" method="post" enctype="multipart/form-data">
	                    
	                    <input type="hidden" name="business.id" value="${business.id }">
	
	                    <div class="form-group">
	                        <div class="form-inline col-md-12">
	                            <div class="form-group col-md-6">
	                                <label for="" class="control-label col-md-4">企业名称</label>
	                                <input type="text" name="business.name" value="${business.name }" class="form-control" size="25" readonly>
	                                <!-- <p class="control-label col-md-3 text-muted" style="text-align: left;">阿里巴巴</p> -->
	                            </div>
	                            <div class="form-group col-md-6">
	                                <label for="" class="control-label col-md-4">所在城市</label>
	                                
	                                <input type="text" value="${business.city }" class="form-control" size="25" readonly>
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="form-group">
	                        <div class="form-inline col-md-12">
	                            <div class="form-group col-md-6">
	                                <label for="" class="control-label col-md-4">联系电话</label>
	                                <input type="text" name="business.telephone" value="${business.telephone }" class="form-control" size="25" readonly>
	                            </div>
	                            <div class="form-group col-md-6 ">
	                                <label for="" class="control-label col-md-4">邮箱</label>
	                                <input type="text" name="business.email"  value="${business.email }" class="form-control " size="30" readonly>
	                            </div>
	                        </div>
	                    </div>
	
	                    <div class="form-group">
	                        <label for="" class="control-label col-md-2">企业地址</label>
	                        <div class="col-md-9" style="padding: 0;">
	                            <input type="text" name="business.address"  value="${business.address }" class="form-control" readonly>
	                        </div>
	                    </div>
	
	                    
	
	                    <div class="form-group">
	                        <label for="" class="control-label col-md-2">企业描述</label>
	                        <div class="col-md-9" style="padding: 0;">
	                            <textarea name="business.description"  class="form-control" id="" cols="30" rows="10" readonly>${business.description }</textarea>
	                        </div>
	                    </div>
	
	                   
	
	                    <div class="form-group">
	                        <label for="" class="control-label col-md-2">企业详情链接</label>
	                        <div class="col-md-9" style="padding: 0;">
	                            <input type="text" name="business.url" value="${business.url }" class="form-control" readonly>
	                        </div>
	                    </div>
	                    
	                    <div class="form-group">
	                        <div class="form-inline col-md-12">
	                            <div class="form-group col-md-6">
	                                <label for="" class="control-label col-md-4">加入时间</label>
	                                <input type="text" name=""  value="${business.create_at }" class="form-control" size="25" readonly="readonly">
	                            </div>
	                            <div class="form-group col-md-6">
	                                <label for="" class="control-label col-md-4">审核状态</label>
	                                <s:if test="#business.check_flag == 0">
	                                    <s:set name="check_status" value="%{'待审核'}" scope="action"></s:set>
	                                </s:if>
	                                <s:if test="#business.check_flag == 1">
	                                    <s:set name="check_status" value="%{'已通过审核'}" scope="action"></s:set>
	                                </s:if>
	                                <s:if test="#business.check_flag == -1">
	                                    <s:set name="check_status" value="%{'未通过审核'}" scope="action"></s:set>
	                                </s:if>
	                                <input type="text" name=""  value="${check_status }" class="form-control" size="30" readonly="readonly">
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="form-group col-md-11">
	                        <div class="btn-group" style="float: right;">
	                            <a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/toFinAdvertise.action">查看该企业发布的招聘信息</a>
	                            <!-- <button type="reset" class="btn btn-default">重置</button> -->
	                        </div>
	                    </div>
	                    
	                    
	
	                </form>
	            </div>
	        </div>
	    </div>
	
	</div>
   	
   	<!-- 举报弹出框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">举报该企业</h4>
	      </div>
	      <div class="modal-body">
	        <form action="complain_dealBusinessComplain.action" class="form-horizontal" method="post">
	        	<input type="hidden" name="userid" value="${sessionScope.LOGINED_USER.id }">
	        	<input type="hidden" name="businessid" value="${business.id }">
	        	<label>为什么举报该企业</label>
	        	<textarea cols="30" rows="10" name="complainReason" class="form-control"></textarea>
		        <button type="button" class="btn btn-default"  data-dismiss="modal">取消</button>
		        <input type="submit" class="btn btn-primary" value="举报">
	        </form>
	      </div>
	      <div class="modal-footer">
	        
	      </div>
	    </div>
	  </div>
	</div>
	   	
   	
   	<jsp:include page="/common/footer.jsp"></jsp:include>
  </body>
</html>

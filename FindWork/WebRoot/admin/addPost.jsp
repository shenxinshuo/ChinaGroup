<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加岗位</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:include page="/common/header.jsp" />
    
    
     <!--新增角色-->
    <div class="container col-md-offset-2">
       <jsp:include page="leftMenu.jsp" >
        	<jsp:param value="add" name="currentPage"/>
        </jsp:include>
        <!--面板-->
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">新增岗位</h3>
                </div>
                <div class="panel-body">
                	<s:if test="errorMessage == null">
                	</s:if>
                	<s:else>
                		<div class="alert alert-danger" role="alert">${errorMessage }</div>
                	</s:else>
                	<s:url id="post_add" action="post_add" namespace="/"></s:url>
                    <form action="${post_add }" class="form-horizontal" method="post">
                    	 <div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["post.name"][0] }</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">岗位名称</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="post.Pname"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">备注</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="post.Comment"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">备注</label>
                            <select name="ptype" class="form-control" style="width:200px"> 
                            	<option>--请选择部门--</option>
									<c:forEach items="${postTypes}" var="posttype">
										<option value="${posttype.PTid}">${posttype.PTname}</option>
									</c:forEach>
                            </select>
                        </div>
                        <%-- <div class="form-group">
                            <label for="" class="control-label col-md-2">岗位类型</label>
                            <div class="col-md-4" style="padding: 0;">
                                <s:select list="posts" name="" label="班级"   
     								listKey="myClassId" listValue="Pname"  
      								headerKey="0" headerValue="---请选择班级---"> 
                                </s:select>
                            </div>
                        </div> --%>
                        <div class="btn btn-group form-group">
                            <input type="submit" class="btn btn-primary" value="添加">
                            <input type="reset" class="btn btn-default" value="重置">
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>
    
    
    
     <jsp:include page="/common/footer.jsp" />
  </body>
</html>

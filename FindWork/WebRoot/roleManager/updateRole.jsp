<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改系统角色</title>
    
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
        <jsp:include page="/roleManager/leftMenu.jsp" >
        	<jsp:param value="update" name="currentPage"/>
        </jsp:include>
        <!--面板-->
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">修改角色</h3>
                </div>
                <div class="panel-body">
                	<s:if test="errorMessage == null">
                	</s:if>
                	<s:else>
                		<div class="alert alert-danger" role="alert">${errorMessage }</div>
                	</s:else>
                	<s:url id="role_update" action="role_update" namespace="/"></s:url>
                    <form action="${role_update }" class="form-horizontal">
                    	
                    	<div class="col-md-12">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["role.name"][0] }</label>
                            </div>
                        </div>
                        <input type="hidden" name="role.id" value="${role.id }" />
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">角色名</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="role.name" value="${role.name}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">备注</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" name="role.comment" value="${role.comment }" class="form-control">
                            </div>
                        </div>
                        
                        <div class="btn btn-group form-group">
                            <input type="submit" value="修改" class="btn btn-primary">
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

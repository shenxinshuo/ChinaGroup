<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加系统角色</title>
    
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
        	<jsp:param value="add" name="currentPage"/>
        </jsp:include>
        <!--面板-->
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">新增角色</h3>
                </div>
                <div class="panel-body">
                	<s:url id="role_add" action="role_add" namespace="/"></s:url>
                    <form action="${role_add }" class="form-horizontal">
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">角色名</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">备注</label>
                            <div class="col-md-4" style="padding: 0;">
                                <input type="text" class="form-control">
                            </div>
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

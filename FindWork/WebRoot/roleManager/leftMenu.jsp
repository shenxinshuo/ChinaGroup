<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'leftMenu.jsp' starting page</title>
    
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
    
	<div class="btn-group-vertical col-md-2" role="group" aria-label="..." style="margin-bottom: 20px;">
        <a href="<%=request.getContextPath() %>/roleManager/addRole.jsp" class="btn btn-default  ${param.currentPage == 'add' ? 'btn-primary' : '' }">新增角色</a>
        <a href="" class="btn btn-default ${param.currentPage == 'update' ? 'btn-primary' : '' }">修改角色</a>
        <s:url id="role_showAll" action="role_getAllRoles" namespace="/" />
        <a href="${role_showAll }" class="btn btn-default  ${param.currentPage == 'show' ? 'btn-primary' : '' }">查看角色</a>
        <a href="../管理员/审核/CheckReInfoList.html" class="btn btn-default">返回管理员中心</a>
        
    </div>

  </body>
</html>

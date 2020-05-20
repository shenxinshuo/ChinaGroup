<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示所有系统角色</title>
    
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
    
    
      <!--查看角色-->
    <div class="container col-md-offset-2">
       <jsp:include page="/roleManager/leftMenu.jsp" >
        	<jsp:param value="show" name="currentPage"/>
        </jsp:include>
        <!--面板-->
        <div class="col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">查看角色</h3>
                </div>
                <div class="panel-body">
                	<s:if test="message == null">
                	</s:if>
                	<s:else>
                		<div class="alert alert-success" role="alert">${message }</div>
                	</s:else>
                    <table class="table table-striped">
                        <tr>
                            <th>角色ID</th>
                            <th>角色名</th>
                            <th>角色备注</th>
                            <th>角色最后修改时间</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="roles" >
                        	<tr>
	                            <th><s:property value=""/></th>
	                            <td>求职者</td>
	                            <td>找工作</td>
	                            <td>2020-05-16</td>
	                            <th>
	                                <a href="">修改</a>
	                                <a href="">删除</a>
	                            </th>
	                        </tr>
                        </s:iterator>
                        <tr>
                            <th>1</th>
                            <td>求职者</td>
                            <td>找工作</td>
                            <td>2020-05-16</td>
                            <th>
                                <a href="">修改</a>
                                <a href="">删除</a>
                            </th>
                        </tr>
                        <tr>
                            <th>2</th>
                            <td>招聘者</td>
                            <td>提供工作岗位</td>
                            <td>2020-05-16</td>
                            <th>
                                <a href="">修改</a>
                                <a href="">删除</a>
                            </th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>


    </div>
    
    
    
     <jsp:include page="/common/footer.jsp" />
  </body>
</html>

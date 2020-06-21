<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索招聘信息</title>
    
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
    
    
    <!--显示搜索的企业信息-->
    <div class="container">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left" style="color: white;"></span> </a>
                    &nbsp;
                    "..${postName }.."的搜素结果
                </div>
                <div class="panel-body">
                    <div class="page-header">
                        <h1>搜索招聘信息 <small> 总数&nbsp;<span class="badge">${count }</span></small></h1>
                      </div>

            
                      <table class="table table-striped">
                        <tr>
                            <th>#</th>
                            <th>标题</th>
                            <th>岗位</th>
                            <th>最高工资</th>
                             <th>学历</th>
                             <th>招聘类型</th>
                            <th>操作 </th>
                        </tr>
                        <s:iterator value="advertises">
                        	<tr>
                            <td>${id }</td>
                            <td>${title }</td>
                            <td>${postName}</td>
                            <td>${largeWages}</td>
                             <td>${educationBackground}</td>
                            <td>${wantJoyType}</td>
                            <td>
                            	<s:url id="detailAdvertise" action="detailAdvertise" namespace="/">
	                            		<s:param name="advertise.id">${id }</s:param>
	                            	</s:url>
	                            <a href="${detailAdvertise }">查看详情</a>
                            </td>
                        </tr>
                        </s:iterator>
                        
                      </table>
                      
                      <!--分页-->
                      <nav aria-label="Page navigation">
                        <ul class="pagination">
                          <s:url id="advertise_searchByNameFirst" action="search_getAdvertisesByPostSearch" namespace="/">
                          	<s:param name="postName">${postName }</s:param>
                          	<s:param name="currentPage">1</s:param>
                          </s:url>
                          <li>
                            <a href="${advertise_searchByNameFirst }" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <s:url id="advertise_searchByNameDesc" action="search_getAdvertisesByPostSearch" namespace="/">
                          	<s:param name="postName">${postName }</s:param>
                          	<s:param name="currentPage">${currentPage-1 }</s:param>
                          </s:url>
                          <li><a href="${advertise_searchByNameDesc }"> < </a></li>
                          <li><a href="#"><strong>${currentPage }</strong>/${lastPage }</a></li>
                          <s:url id="advertise_searchByNameAdd" action="search_getAdvertisesByPostSearch" namespace="/">
                          	<s:param name="postName">${postName }</s:param>
                          	<s:param name="currentPage">${currentPage+1 }</s:param>
                          </s:url>
                          <li><a href="${advertise_searchByNameAdd }"> > </a></li>
                          <s:url id="advertise_searchByNameLast" action="search_getAdvertisesByPostSearch" namespace="/">
                          	<s:param name="postName">${postName }</s:param>
                          	<s:param name="currentPage">${lastPage }</s:param>
                          </s:url>
                          <li>
                            <a href="${advertise_searchByNameLast }" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                      </nav>
                </div>
            </div>
        </div>

    </div>
    
    
    <jsp:include page="/common/footer.jsp" />
    <script type="text/javascript" src="resource/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </body>
</html>

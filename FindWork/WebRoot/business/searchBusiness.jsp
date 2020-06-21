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
                    "..${searchName }.."的搜素结果
                </div>
                <div class="panel-body">
                    <div class="page-header">
                        <h1>搜索企业信息 <small> 总数&nbsp;<span class="badge">${count }</span></small></h1>
                      </div>

                      <!--显示企业信息列表-->
                      <table class="table table-striped">
                        <tr>
                            <th>#</th>
                            <th>公司名称</th>
                            <th>总部</th>
                            <th style="width: 400px;">基本描述</th>
                            <th>操作 </th>
                        </tr>
                        <s:iterator value="businesses">
                        	<tr>
                            <td>${id }</td>
                            <td>${name}</td>
                            <td>${city}</td>
                            <td>${description }</td>
                            <td>
                            	<s:url id="business_showBusinessInfo" action="business_showBusinessInfo" namespace="/">
                            		<s:param name="business.id">${id }</s:param>
                            	</s:url>
                                <a href="${business_showBusinessInfo }">查看详情</a>
                            </td>
                        </tr>
                        </s:iterator>
                        
                      </table>
                      
                      <!--分页-->
                      <nav aria-label="Page navigation">
                        <ul class="pagination">
                          <s:url id="business_searchByNameFirst" action="business_searchByName" namespace="/">
                          	<s:param name="searchName">${searchName }</s:param>
                          	<s:param name="currentPage">1</s:param>
                          </s:url>
                          <li>
                            <a href="${business_searchByNameFirst }" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <s:url id="business_searchByNameDesc" action="business_searchByName" namespace="/">
                          	<s:param name="searchName">${searchName }</s:param>
                          	<s:param name="currentPage">${currentPage-1 }</s:param>
                          </s:url>
                          <li><a href="${business_searchByNameDesc }"> < </a></li>
                          <li><a href="#"><strong>${currentPage }</strong>/${lastPage }</a></li>
                          <s:url id="business_searchByNameAdd" action="business_searchByName" namespace="/">
                          	<s:param name="searchName">${searchName }</s:param>
                          	<s:param name="currentPage">${currentPage+1 }</s:param>
                          </s:url>
                          <li><a href="${business_searchByNameAdd }"> > </a></li>
                          <s:url id="business_searchByNameLast" action="business_searchByName" namespace="/">
                          	<s:param name="searchName">${searchName }</s:param>
                          	<s:param name="currentPage">${lastPage }</s:param>
                          </s:url>
                          <li>
                            <a href="${business_searchByNameLast }" aria-label="Next">
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
  </body>
</html>

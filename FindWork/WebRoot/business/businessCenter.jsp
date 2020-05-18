<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'regBusiness.jsp' starting page</title>
    
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
  	<!-- 引入头部 -->
    <jsp:include page="/common/header.jsp"/>
  
  	<!-- 企业中心具体页面 -->
  	 <!--企业中心-->
    <div class="container">
        <div class="col-md-8 col-md-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">企业中心</div>
                <div class="panel-body">
                    <div class="page-header">
                        <h1>以往招聘信息 <small> 总数&nbsp;<span class="badge">10</span></small></h1>
                      </div>
                      <!--显示以往的招聘-->
                      <table class="table table-striped">
                        <tr>
                            <th>#</th>
                            <th>岗位</th>
                            <th>学历要求</th>
                            <th>薪资范围</th>
                            <th>截止日期</th>
                            <th>操作 </th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>运维工程师</td>
                            <td>本科</td>
                            <td>10K-15K</td>
                            <td>2020-05-23</td>
                            <td>
                                <a href="../postjob/single-job-page.html">查看详情</a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>java高级工程师</td>
                            <td>研究生</td>
                            <td>25K+</td>
                            <td>2020-05-23</td>
                            <td>
                                <a href="">查看详情</a>
                            </td>
                        </tr>
                      </table>
                      <!--分页-->
                      <nav aria-label="Page navigation">
                        <ul class="pagination">
                          <li>
                            <a href="#" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <li><a href="#">1</a></li>
                          <li><a href="#">2</a></li>
                          <li><a href="#">...</a></li>
                          <li><a href="#">4</a></li>
                          <li><a href="#">5</a></li>
                          <li>
                            <a href="#" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                      </nav>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-info">
                <div class="panel-heading">企业相关信息</div>
                <div class="panel-body">
                    <label for="">企业名称:</label>
                    &nbsp;
                    <span>阿里巴巴</span>
                    <br>
                    <label for="">所在城市:</label>
                    &nbsp;
                    <span>杭州</span>
                    <br>
                    <label for="">联系电话:</label>
                    &nbsp;
                    <span>15019717010</span>
                    <div class="btn btn-group">
                        <div class="btn btn-info"><a href="" style="color: white;">完善资料</a></div>
                    </div>
                    <div class="btn btn-group">
                        <div class="btn btn-info"><a href="../postjob/dashboard-post-a-job.html" style="color: white;">添加招聘信息</a></div>
                    </div>
                    <div class="btn btn-group">
                        <div class="btn btn-info"><a href="../postjob/dashboard-manage-jobs.html" style="color: white;">查看已发布的招聘</a></div>
                    </div>
                    <div class="btn btn-group">
                        <div class="btn btn-info"><a href="../postjob/weifabujob.html" style="color: white;">查看未发布的招聘</a></div>
                    </div>
                </div>
            </div>
        </div>
       

    </div>
    
    <!-- 引入底部 -->
    <jsp:include page="/common/footer.jsp"/>
    
  </body>
</html>

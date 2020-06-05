<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册企业</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="<%=request.getContextPath() %>/resource/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/yufeng/pro_cites.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			for(var i=0; i<pro.length; i++) {
				$option = $("<option>");
				$option.attr("value", pro[i]);
				//console.log(123)
				if ("${business.province}" == pro[i]) {
					$option.attr("selected",true);
				}
				$option.text(pro[i]);
				$("#province").append($option);
			}
			$("#province").change(function() {
				var cities = city[$(this).val()];
				$("#city").empty();
				for (var i=0; i<cities.length; i++) {
					$option = $("<option>");
					$option.attr("value", cities[i]);
					$option.text(cities[i]);
					$("#city").append($option);
				}
			})
		})
	</script>
  </head>
  
  <body>
 
  	<!-- 注册企业 -->
  	 <div class="container" style="margin-top: 50px;">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <a href="<%=request.getContextPath()%>/business/businessLogin.jsp"><span class="glyphicon glyphicon-arrow-left"
                            style="color: white;"></span> </a>
                    注册企业
                </div>
                
                <div class="panel-body">
                
                	<!-- 提示信息 -->
                	<div class="col-md-10 col-md-offset-1"> 
                		<p class="text-danger"><label>${errorMessage }</label></p>
                	</div>
                	
                
                    <!-- 注册表单 -->
                    <s:url id="business_register" action="business_register" namespace="/" />
                    
                    <form class="form-horizontal" action="${business_register }" method="post" enctype="multipart/form-data">

                       <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.name"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.city"][0] }</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">企业名称</label>
                                    <input type="text" name="business.name" value="${business.name }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">所在城市</label>
                                    <select name="business.province" id="province"  class="form-control" style="width:130px;">
                                        <option value="" >选择省份</option>
                                    </select>
                                    <select name="business.city" id="city" class="form-control">
                                        <option value="" >选择城市</option>
                                        <s:if test="business.city != null">
                                        	<option value="${business.city }" selected="selected">${business.city }</option>
                                        </s:if>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.telephone"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.email"][0] }</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">联系电话</label>
                                    <input type="text" name="business.telephone" value="${business.telephone }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 ">
                                    <label for="" class="control-label col-md-4">邮箱</label>
                                    <input type="text" name="business.email"  value="${business.email }" class="form-control " size="30">
                                </div>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-4">${fieldErrors["business.password"][0] }</label>
                            </div>
                            <div class="col-md-6">
                                <label for="" class="text-danger col-md-offset-3">${fieldErrors["business.confirmPassword"][0] }</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">登录密码</label>
                                    <input type="password" name="business.password"  value="${business.password }" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 ">
                                    <label for="" class="control-label col-md-4">确认密码</label>
                                    <input type="password" name="business.confirmPassword" value="${business.confirmPassword }" class="form-control " size="30">
                                </div>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["license"][0] }</label>
                        </div>

                        <!-- <div class="row col-md-offset-2">
                            <div class="col-xs-6 col-md-3">
                                <a href="#" class="thumbnail">
                                    <img src="../seecv/img/ss.jpg" alt="...">
                                </a>
                            </div>
                        </div> -->
                        <div class="form-group">
                            <label for="exampleInputFile" class="control-label col-md-2">上传营业执照</label>
                            <!-- TODO -->
                            <input type="file" name="license" id="exampleInputFile">
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.address"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业地址</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" name="business.address"  value="${business.address }" class="form-control">
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.description"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业描述</label>
                            <div class="col-md-9" style="padding: 0;">
                                <textarea name="business.description"  class="form-control" id="" cols="30" rows="10">${business.description }</textarea>
                            </div>
                        </div>

                        <div class="d-inline-block">
                            <label for="" class="text-danger col-md-offset-2">${fieldErrors["business.url"][0] }</label>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业详情链接</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" name="business.url" value="${business.url }" class="form-control">
                            </div>
                        </div>
                        <div class="btn-group" style="float: right;">
                            <button type="submit" class="btn btn-primary">注册</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </div>
    
    
    <script src="<%=request.getContextPath() %>/resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </body>
</html>

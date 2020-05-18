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
	<link rel="stylesheet" href="../resource/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

  </head>
  
  <body>
  	
  
  	<!-- 注册企业 -->
  	<div class="container" style="margin-top: 50px;">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-primary ">
                <div class="panel-heading">
                    <a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-arrow-left" style="color: white;"></span> </a>
                    注册企业
                </div>
                <div class="panel-body">
                    <!-- 注册表单 -->
                    <form class="form-horizontal">
                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">企业名称</label>
                                        <input type="text" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6" >
                                    <label for="" class="control-label col-md-4">所在城市</label>
                                    <select name="city" id="" class="form-control" >
                                        <option value="shantou">汕头</option>
                                        <option value="zhuhai">珠海</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">联系电话</label>
                                    <input type="text" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 " >
                                    <label for="" class="control-label col-md-4">邮箱</label>
                                    <input type="text" class="form-control " size="30">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-inline col-md-12">
                                <div class="form-group col-md-6">
                                    <label for="" class="control-label col-md-4">登录密码</label>
                                    <input type="text" class="form-control" size="25">
                                </div>
                                <div class="form-group col-md-6 " >
                                    <label for="" class="control-label col-md-4">确认密码</label>
                                    <input type="text" class="form-control " size="30">
                                </div>
                            </div>
                        </div>
                     
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业地址</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业描述</label>
                            <div class="col-md-9" style="padding: 0;">
                               <textarea name="" class="form-control" id="" cols="30" rows="10"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="" class="control-label col-md-2">企业详情链接</label>
                            <div class="col-md-9" style="padding: 0;">
                                <input type="text" class="form-control">
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
    
   <script src="../resource/static/jquery/jquery.min.js"></script>
    <script src="../resource/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </body>
</html>

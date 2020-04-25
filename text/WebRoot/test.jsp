<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
contentType="text/html; charset=utf-8"
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
    显示所有通知通告类型
    <%@  page  import="java.util.*,javabean.*,java.sql.*" %>
    <%
    List <Type>list=new ArrayList<Type>();
    TypeControl tc= new TypeControl();
    String sql="select * from Type";
    list=tc.getType(sql);
    for(int i=0;i<list.size();i++){
    out.print(list.get(i).getTtype()+"<br>");
    }
    
    
    
     %>
  </body>
</html>

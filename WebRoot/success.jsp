<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.luyi.domain.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <%
  	if(request.getSession().getAttribute("exitUser") == null){
  	
   %>
   <h1>您还没有登录，请您先<a href = "/jsp_mvc_demo/login.jsp">登录</a></h1>
   <%
   }else{
   
    %>
    <%
    	User exitUser = (User)request.getSession().getAttribute("exitUser");
     %>
    <h1>恭喜你，登录成功！</h1>
    <h3>您好,<%=exitUser.getUsername() %></h3>
    <%
    }
     %>
    <a href = "/jsp_mvc_demo/LogoutServlet">退出系统</a>
  </body>
</html>

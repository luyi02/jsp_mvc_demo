<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <h1>登录页面</h1>
	<%;
		String msg = "";
		if(request.getAttribute("msg") != null){
			 msg = (String)request.getAttribute("msg");
		}
	 %>
  <span style = "color: red"><%= msg %></span>
    <form action="LoginServlet" method = "post">
    	用户名：<input type = "text" name = "username" / value = "${cookie.remember.value} "><br><br>
    	密码：<input type = "password" name = "password"/><br><br>
    	验证码：<input type = "text" name = "randomCode" size = "6"/>
    	 <img id = "img1" alt="验证码图片" src="/jsp_mvc_demo/RondomCodeImageServlet">
    	 <a href = "javascript:void(0)" onclick = "changeImg()">看不清，换一张</a>
    	 <br><br>
    	记住用户名：<input type = "radio" name = rememberPassword/><br><br>
    	<input type = "submit" value = "登录">
    </form>
  </body>
  <script type="text/javascript">
  	function changeImg(){
  		document.getElementById("img1").src = "/jsp_mvc_demo/RondomCodeImageServlet?time=" + new Date().getTime();
  	}
  </script>
</html>

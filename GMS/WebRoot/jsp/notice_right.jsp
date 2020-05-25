<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control " CONTENT="no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统主页</title>
</head>

<body>
	<br></br>
	<br></br>

<div class="jumbotron">
	<div class="container">
	<% HttpSession session4 = request.getSession();
			String notice=(String)session4.getAttribute("notice");%>
		<h1>公告栏</h1>
		
		<p><%=notice %></p>
	</div>
</div>
	<div class="jumbotron" id="lock">
		<div class="container">
			<h1>▂ ▃  ▅ ▆ ▇ </h1>
		
		</div>
	</div>



</body>
</html>
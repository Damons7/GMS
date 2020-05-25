<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系 统 主 页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
</head>
<body>
<body>
			<% 	HttpSession sessions = request.getSession();
				String iden=(String)sessions.getAttribute("iden"); 
				if(iden.equals("teacher")){
			%>
<jsp:include page="index_teacher.jsp"></jsp:include>
			<%}	else{ %>
	<jsp:include page="index.jsp"></jsp:include><%} %>
		<div class="index_t1">	
		
			<jsp:include page="notice_right.jsp"></jsp:include>
		
		</div>
	
</body>
</body>
</html>

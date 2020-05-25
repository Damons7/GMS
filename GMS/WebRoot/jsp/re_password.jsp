<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修 改 信 息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
</head>
<body>
<body>

<%	HttpSession session1= request.getSession();
			String iden=(String)session1.getAttribute("iden");
			if(iden.equals("teacher")){ %>
				<jsp:include page="index_teacher.jsp"></jsp:include><% }
			else if(iden.equals("student")){%>
					<jsp:include page="index.jsp"></jsp:include><%} %>

	

	<div class="index_t">
		
		<jsp:include page="re_password_right.jsp"></jsp:include>
		
	</div>

</body>
</body>
</html>

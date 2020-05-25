<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control " CONTENT="no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成 绩 信 息</title>
<link rel="stylesheet" type="text/css" href="/big_job/css/register.css">
</head>

<body>
	<br></br>
	<br></br>

	<div class="reg_div1">成 绩 信 息</div>
<a class="dayin"  href="javascript:self.print();">打印成绩</a>
<a class="rank"  href="/big_job/select_scrank_bystu_Servlet.do?school_year=1&term=1">成绩排名</a>
		<label>学期</label><select name="educa" 	 onchange="javascript:location.href=this.value;" >
					<option value="/big_job/sc_select_informationServlet.do?term=1&school_year=1">大一第一学期</option>	
			<option value="/big_job/sc_select_informationServlet.do?term=2&school_year=1">大一第二学期</option>	
			<option value="/big_job/sc_select_informationServlet.do?term=1&school_year=2">大二第一学期</option>	
			<option value="/big_job/sc_select_informationServlet.do?term=2&school_year=2">大二第二学期</option>	
		</select>
	
		<div class="reg_div2">
		<table id="customers3">
			<br></br>
			<c:forEach var="list" items="${list}">				
			<c:choose>
       		<c:when test="${ empty list}">
           	   无数据
       		</c:when>
        	<c:otherwise> 
  
				<tr class="alt">

				<th>课程名 :</th>
				<th>${list.cname}</th>

				<th>分 数 :</th>
				<th>${list.grade}</th>
				
				<th>绩 点 :</th>
				<th>${list.gpa}</th>
				</tr>

		     </c:otherwise>
	    	 </c:choose>
			 </c:forEach>
		</table>

	</div>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课 程 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br>

<div class="reg_div1">课 程 信 息</div>

	<div class="reg_div6">
<c:forEach var="list" items="${list}">	
 <select name="educa" 	 onchange="javascript:location.href=this.value;" >
			<option name="a" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=1&school_year=1">大一第一学期</option>	
			<option name="b" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=2&school_year=1">大一第二学期</option>	
			<option name="c" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=1&school_year=2">大二第一学期</option>	
			<option name="d" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=2&school_year=2">大二第二学期</option>	
			<option name="e" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=1&school_year=3">大三第一学期</option>
			<option name="f" value="/big_job/administrator_coursesServlet.do?sno=${list.sno}&term=2&school_year=3">大三第二学期</option>
		</select>
		</c:forEach>
	    

	    <table  id="customers3" ><br></br> 

		<c:forEach var="list" items="${list}">				
		<c:choose>
        <c:when test="${ empty list}">
              无数据
        </c:when>
        <c:otherwise>     
        <tr class="alt">
		<form action="administrator_courses_deleteServlet.do">
		<input type="hidden" name="cno" value="${list.cno}" readonly>	
		<input type="hidden" name="sno" value="${list.sno}"  readonly>	
		<td>课程名 :</td><td>${list.cname}</td>
		<td>成绩 :</td><td>${list.grade}</td>
		<td>绩点 :</td><td>${list.gpa}</td>
		<td><input type="text" name="update_sc"></td>
		<td><button>修改分数</button></td>
		</form>
		</tr>
	    </c:otherwise>
	    </c:choose>
		</c:forEach>
		</table>

	</div><a href="jsp/index_administrator.jsp">返回</a>
</html>
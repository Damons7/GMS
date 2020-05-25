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

	<div class="reg_div2">
	
		    <table  id="customers" ><br></br> 
			<a href="/courses_select.jsp">返回</a>
		<c:forEach var="list" items="${list}">				
			<c:choose>
       		<c:when test="${ empty list}">
           	   无数据
       		</c:when>
        	<c:otherwise>   
         <tr class="alt">

		<td>课程编号:${list.cno1 }</td>
		<td>课程名 :${list.cname }</td>
		<td>授课老师：${list.tno}</td>
		<td> <a href="/big_job/delete_coursesServlet.do?cno=${list.cno1 }&tno=${list.tno }">删除</a> </td>

		</tr>
			
		   </c:otherwise>
	    	 </c:choose>
			 </c:forEach>
			</table>
	
	</div>
</html>
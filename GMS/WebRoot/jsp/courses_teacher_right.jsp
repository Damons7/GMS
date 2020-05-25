<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本 学 期 学 生 选 课 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br>

<div class="reg_div1">本 学 期 学 生 选 课 信 息</div>
<label>学期</label> <select name="educa" 	 onchange="javascript:location.href=this.value;" >
			<option name="a" value="/big_job/courses_teacherServlet.do?term=1&school_year=1">大一第一学期</option>	
			<option name="b" value="/big_job/courses_teacherServlet.do?term=2&school_year=1">大一第二学期</option>	
			<option name="c" value="/big_job/courses_teacherServlet.do?term=1&school_year=2">大二第一学期</option>	
			<option name="d" value="/big_job/courses_teacherServlet.do?term=2&school_year=2">大二第二学期</option>	
			<option name="e" value="/big_job/courses_teacherServlet.do?term=1&school_year=3">大三第一学期</option>
			<option name="f" value="/big_job/courses_teacherServlet.do?term=2&school_year=3">大三第二学期</option>
		</select>

	<div class="reg_div2">
	
		    <table  id="customers3" ><br></br> 
			<c:forEach var="telist" items="${telist}">				
			
			<tr class="alt">
				<th>课程号 :</th>
				<th>${telist.cno1 }</th>

				<th>课程名 :</td>
				<th>${telist.cname }</th>
				<th>学号 :</td>
				<th>${telist.sno }</th>
				<th>姓 名 :</td>
				<th>${telist.name }</th>
			</tr>
			 </c:forEach>
		</table>

	</div>
</html>


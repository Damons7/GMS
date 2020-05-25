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

	<div class="reg_div1">学 生 成 绩 信 息</div>
	

	<div class="reg_div2">

		<table id="customers3">
			<br></br>			
			 
			<form action="/big_job/add_sc.do">
				<tr class="alt">	
						
				<th>课程名 </th>
				<th>${cname}</th>
	
				<th>课程号  </th>
				<th><input type="text" name="cno" value="${cno}" readonly class="reg_td1"></th>	
			
				<th>学 号 </td>				
				<th><input type="text" name="sno" ></th>
				<th>分 数 :</th>
				<th><input type="text" name="grade" ></th>
				<input type="hidden" name="term" value="${term}" readonly>		
				<input type="hidden" name="school_year" value="${school_year}" readonly>

				<td><button>录入成绩  </button></td>
	</tr>
				</form>

		</table>

	</div>
				
		
</html>


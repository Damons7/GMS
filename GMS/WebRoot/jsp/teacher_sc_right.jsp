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
	<label>学期</label> <select name="educa" 	 onchange="javascript:location.href=this.value;" >
			<option name="a" value="/big_job/teacher_scServlet.do?q=sc&term=1&school_year=1">大一第一学期</option>	
			<option name="b" value="/big_job/teacher_scServlet.do?q=sc&term=2&school_year=1">大一第二学期</option>	
			<option name="c" value="/big_job/teacher_scServlet.do?q=sc&term=1&school_year=2">大二第一学期</option>	
			<option name="d" value="/big_job/teacher_scServlet.do?q=sc&term=2&school_year=2">大二第二学期</option>	
			<option name="e" value="/big_job/teacher_scServlet.do?q=sc&term=1&school_year=3">大三第一学期</option>
			<option name="f" value="/big_job/teacher_scServlet.do?q=sc&term=2&school_year=3">大三第二学期</option>
		</select>

	<div class="reg_div2">
	
	<a href="/big_job/select_sc_rankServlet.do?term=${list2.term}&school_year=${list2.school_year}"  class="reg_a1">成绩排名</a>
	<a href="/big_job/select_teacher_cno.do?term=${list2.term}&school_year=${list2.school_year}&is_open=${is_open}"  class="reg_a2">录入成绩</a>
	<a href="/big_job/teacher_scServlet.do?q=re&term=${list2.term}&school_year=${list2.school_year}"  class="reg_a3">修改</a>

		<table id="customers3">
			<br></br>
			<c:forEach var="list2" items="${list2.list}">				
			<c:choose>
       		 <c:when test="${ empty list2}">
           	   无数据
       		 </c:when>
        	<c:otherwise>   
				<tr class="alt">			
				<th>课程名 </th>
				<th>${list2.cname}</th>
	
				<th>课程号  </th>
				<th>${list2.cno}</th>				
				<th>姓 名 </th>
				<th>${list2.name}</th>				
				<th>学 号 </td>
				<th>${list2.sno}</th>				
				<th>分 数 </td>
				<th>${list2.grade}</th>
				<th>绩 点 </td>
				<th>${list2.gpa}</th>
	
				</form>
						</tr>
	  		 </c:otherwise>
	    	</c:choose>
			</c:forEach>
		</table>

	</div>
					<div>
					
	<ul  class="pagination">
	<!-- 显示上一页 -->

	<c:choose>
     <c:when test="${list2.currentPage<=1}">
          <li><a>上一页</a></li> 
       		 </c:when>
        	<c:otherwise>  
	<li><a href="${pageContext.request.contextPath}/teacher_scServlet.do?q=sc&school_year=${list2.school_year}&term=${list2.term}&page=${list2.currentPage-1}">上一页</a></li>
		 </c:otherwise>
	    	</c:choose>
	    
	<li><span >第${list2.currentPage}页/共 ${list2.totalpage}页</span> 	</li>								
	<!-- 显示下一页 -->
	<c:choose>
     <c:when test="${list2.currentPage>=list2.totalpage}">
         <li><a>下一页</a></li>
       		 </c:when>
        	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/teacher_scServlet.do?q=sc&school_year=${list2.school_year}&term=${list2.term}&page=${list2.currentPage+1}">下一页</a></li>
	 </c:otherwise>
	    	</c:choose>
													
	</ul>	
	</div>
		
</html>
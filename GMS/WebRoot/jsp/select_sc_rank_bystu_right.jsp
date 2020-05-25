  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control " CONTENT="no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成 绩 排 名 信 息</title>
<link rel="stylesheet" type="text/css" href="/big_job/css/register.css">
</head>

<body>
	<br></br>
	<br></br>

	<div class="reg_div1">学 生 成 绩 排 名</div>
	<label>学期</label> <select name="educa" 	 onchange="javascript:location.href=this.value;" >
			<option name="a" value="/big_job/select_scrank_bystu_Servlet.do?school_year=1&term=1">大一第一学期</option>	
			<option name="b" value="/big_job/select_scrank_bystu_Servlet.do?school_year=1&term=1">大一第二学期</option>	
			<option name="c" value="/big_job/select_scrank_bystu_Servlet.do?school_year=2&term=1">大二第一学期</option>	
			<option name="d" value="/big_job/select_scrank_bystu_Servlet.do?school_year=2&term=1">大二第二学期</option>	
			
		</select>

	<div class="reg_div2">
	
	<a href="/big_job/sc_select_informationServlet.do?school_year=1&term=1"  class="reg_a1">返回</a>
		<table id="customers3">
			<br></br>
			<c:forEach var="list4" items="${list4.list}">				
			<c:choose>
       		 <c:when test="${ empty list4}">
           	   无数据
       		 </c:when>
        	<c:otherwise>   
				<tr class="alt">	
				<th>学号  </th>
				<th>${list4.sno}</th>
				<th>总分排名 </th>
				<th>${list4.rank}</th>		
				<th>总分  </td>
				<th>${list4.grade}</th>
		
	
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
     <c:when test="${list4.currentPage<=1}">
          <li><a>上一页</a></li> 
       		 </c:when>
        	<c:otherwise>  
	<li><a href="${pageContext.request.contextPath}/select_scrank_bystu_Servlet.do?term=${list4.term}&school_year=${list4.school_year}&page=${list4.currentPage-1}">上一页</a></li>
		 </c:otherwise>
	    	</c:choose>
	    
	<li><span >第${list4.currentPage}页/共 ${list4.totalpage}页</span> 	</li>								
	<!-- 显示下一页 -->
	<c:choose>
     <c:when test="${list4.currentPage>=list4.totalpage}">
         <li><a>下一页</a></li>
       		 </c:when>
        	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/select_scrank_bystu_Servlet.do?term=${list4.term}&school_year=${list4.school_year}&page=${list4.currentPage+1}">下一页</a></li>
	 </c:otherwise>
	    	</c:choose>
													
	</ul>	
	</div>
</html>

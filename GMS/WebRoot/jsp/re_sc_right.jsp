
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

	<div class="reg_div1"> 修 改 成 绩 </div>

	<div class="reg_div2">

		<table id="customers3">
			<br></br>
			<c:forEach var="list2" items="${list2.list}">				
			<c:choose>
       		 <c:when test="${ empty list2}">
           	   无数据
       		 </c:when>
        	<c:otherwise>   
				<tr class="alt">
						
				<th>课程名 :</th>
				<th>${list2.cname}</th>
				<form action="re_scServlet.do">
				<th>课程号  :</th>
				<th>${list2.cno}</th>
				<input type="hidden" name="cno" value="${list2.cno}" readonly>				
				<th>姓 名 :</th>
				<th>${list2.name}</th>				
				<th>学 号 :</td>
				<th>${list2.sno}</th>
				<input type="hidden" name="sno" value="${list2.sno}"  readonly>			
				<th>分 数 :</td>
				<th>${list2.grade}</th>
	
				<th><input type="text" name="update_sc" class="reg_td2"></th>
				
				<th><button>修改分数</button></th>
				</form>
				</tr>
	  		 </c:otherwise>
	    	</c:choose>
			</c:forEach>
		</table>

	</div>
	
	
	<div >
	<ul class="pagination">
	<!-- 显示上一页 -->

	<c:choose>
     <c:when test="${list2.currentPage<=1}">
          <li><a>上一页</a></li> 
       		 </c:when>
        	<c:otherwise>  
	<li><a href="${pageContext.request.contextPath}/teacher_scServlet.do?q=re&school_year=${list2.school_year}&term=${list2.term}&page=${list2.currentPage-1}">上一页</a></li>
		 </c:otherwise>
	    	</c:choose>
	    
	<li><span >第${list2.currentPage}页/共 ${list2.totalpage}页</span> 	</li>								
	<!-- 显示下一页 -->
	<c:choose>
     <c:when test="${list2.currentPage>=list2.totalpage}">
         <li><a>下一页</a></li>
       		 </c:when>
        	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/teacher_scServlet.do?q=re&school_year=${list2.school_year}&term=${list2.term}&category=${category}&page=${list2.currentPage+1}">下一页</a></li>
	 </c:otherwise>
	    	</c:choose>
													
	</ul>	
	</div>
</html>


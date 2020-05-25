<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.jizhu.javabean.courses_user "%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课 程 表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br> 

<div class="reg_div1">本 学 期 课 程 表</div>
	<label>学期</label> <select name="educa" 	 onchange="javascript:location.href=this.value;" >
			<option name="a" value="/big_job/courses_informationServlet.do?id=3&school_year=3&term=1">大一第一学期</option>	
			<option name="b" value="/big_job/courses_informationServlet.do?id=3&term=2&school_year=1">大一第二学期</option>	
			<option name="c" value="/big_job/courses_informationServlet.do?id=3&term=1&school_year=2">大二第一学期</option>	
			<option name="d" value="/big_job/courses_informationServlet.do?id=3&term=2&school_year=2">大二第二学期</option>	
			<option name="e" value="/big_job/courses_informationServlet.do?id=3&term=1&school_year=3">大三第一学期</option>
			<option name="f" value="/big_job/courses_informationServlet.do?id=3&term=2&school_year=3">大三第二学期</option>
		</select>
	<div class="reg_div2">

		 <table  id="customers" ><br></br> 

	<%
		//获取信息集合
	List<courses_user>co=(List<courses_user>)request.getAttribute("list");
		String cno[]=new String[6];int a=0;
		String cno1=null;
		if(co == null){
			out.print("没有数据 ");
			}else{
		for(courses_user co1:co){
			if(a<=5){
		 		cno[a]= co1.getCname();
				a++;
			}
		}
		//HttpSession session1 = request.getSession();
		//session1.setAttribute("a", a);
	 }%>	

            <tr>
                <th>星期</th>
                <th>星期一</th>
                <th>星期二</th>
                <th>星期三</th>
                <th>星期四</th>
                <th>星期五</th>
            </tr>
            <tr>
                <td rowspan="2">上午</td>
                <td><%=cno[1] %></td>
                <td><%=cno[2] %></td>
                <td><%=cno[3] %></td>
                <td><%=cno[4] %></td>
                <td><%=cno[0] %></td>          
            </tr>
            
            <tr class="alt">
               <td><%=cno[5] %></td>
               <td><%=cno[3] %></td>
               <td><%=cno[2] %></td>
               <td><%=cno[1] %></td>
               <td><%=cno[0] %></td>
            </tr>
          
            <tr class="alt">
               <td rowspan="2">下午</td>
               <td><%=cno[4] %></td> 
               <td><%=cno[5] %></td>
               <td><%=cno[1]%></td>
               <td><%=cno[2] %></td>
               <td><%=cno[3] %></td>  
            </tr>
            <tr>
               <td><%=cno[5] %></td>
               <td><%=cno[1] %></td>
               <td><%=cno[0] %></td>
               <td><%=cno[3]%></td>
 			   <td><%=cno[4] %></td>
            </tr>
			</table>
		
	</div>
</html>

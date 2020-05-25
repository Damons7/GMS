<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@page import="cn.jizhu.javabean.courses_user "%>
 <%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在 线 选 课</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>

	<%
		HttpSession session2 = request.getSession();
		String now_sno = (String)session2.getAttribute("sno");
	 %>
<br></br><br></br>

<div class="reg_div1">在 线 选 课</div>
	<%
		//获取信息集合
	List<courses_user>co=(List<courses_user>)request.getAttribute("list");
	;int a=0;
		
		if(co == null){
			out.print("没有数据 ");
			}else{
		for(courses_user co1:co){
			if(a<=5){
	
				a++;
			}
		}
		HttpSession session1 = request.getSession();
		session1.setAttribute("a", a);
	 }%>

	<div class="reg_div2">
		
		<table  id="customers">  
		<a href="/big_job/courses_informationServlet.do?id=2">已选课程</a>
		<tr class="alt">

		<td>课程编号:1010</td>
		<td>课程名:机器学习</td>
		<td>授课老师:009</td>
		<td> <a href="/big_job/courses_select.do?cno1=1010&sno=<%=now_sno %>&cname=机器学习&te_name=009"> 选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1011</td>
		<td>课程名:离散数学</td>
		<td>授课老师:006</td>
		<td>  <a href="/big_job/courses_select.do?cno1=1011&sno=<%=now_sno %>&cname=离散数学&te_name=006"> 选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1012</td>
		<td>课程名:管理统计学</td>
		<td>授课老师:007</td>
		<td> <a href="/big_job/courses_select.do?cno1=1012&sno=<%=now_sno %>&cname=管理统计学&te_name=007">选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1013</td>
		<td>课程名:phthyon</td>
		<td>授课老师:005</td>
		<td> <a href="/big_job/courses_select.do?cno1=1013&sno=<%=now_sno %>&cname=phthyon&te_name=005"> 选择</a> </td>
		</tr>
				<tr class="alt">

		<td>课程编号:1014</td>
		<td>课程名:算法应用技术</td>
		<td>授课老师:008</td>
		<td> <a href="/big_job/courses_select.do?cno1=1014&sno=04170007&cname=算法应用技术&te_name=008"> 选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1015</td>
		<td>课程名:毛泽东思想</td>
		<td>授课老师:010</td>
		<td> <a href="/big_job/courses_select.do?cno1=1015&sno=04170007&cname=毛泽东思想&te_name=010"> 选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1001</td>
		<td>课程名:AI人工智能</td>
		<td>授课老师:001</td>
		<td> <a href="/big_job/courses_select.do?cno1=1001&sno=<%=now_sno %>&cname=AI人工智能&te_name=001"> 选择</a> </td>
		</tr>
		
		<tr class="alt">

		<td>课程编号:1002</td>
		<td>课程名:javaWeb</td>
		<td>授课老师:002</td>
		<td> <a href="/big_job/courses_select.do?cno1=1002&sno=<%=now_sno %>&cname=javaWeb&te_name=002"> 选择</a> </td>
		</tr>
			
		</table>
	
	</div>
</html>

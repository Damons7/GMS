<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 <%@page import="cn.jizhu.action.re_informationServlet"%>
 <%@page import="cn.jizhu.javabean.EC_user "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个 人 信 息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
	
	<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>


<body>
<br></br><br></br>

<div class="reg_div1">修 改 信 息</div>


	<div class="reg_div2">
	
		<form action="${pageContext.request.contextPath}/re_informationServlet.do"
			method="post" onsubmit="return check()">
			<!-- get:有大小要求，不能超过4kb -->
			<table class="reg_table1">	<br></br> 

	<%
		//获取信息集合
		EC_user re = (EC_user)request.getAttribute("rsUser");
		if(re == null){
			out.print("没有数据 ");
			
		}else{
			
	%>	
		<tr >
			<td class="reg_div1_infor">*学号/教师号: </td> 
			<td class="reg_div1_infor"> ${rsUser.sno }</td>
		</tr>
		<tr></tr>
		<tr >	
			<td class="reg_div1_infor">*姓名: </td>	
			<td class="reg_div1_infor"> ${rsUser.name}</td>
		</tr>
		<tr></tr>
		<tr >	
			<td class="reg_div1_infor">*账号:       </td>	
			<td> <input type="text" name="username" value="<%=re.getLogin_name() %>" readonly class="reg_td1" id="username"></td>	
		</tr>
		<tr></tr>
		<tr >
			<td class="reg_div1_infor">*性别: </td>	
			<td class="reg_div1_infor"> ${rsUser.sex }</td>	
		</tr>
		<tr></tr>
	
		
		
		<tr >
			<td class="reg_div1_infor">*详细地址:</td>	
			<td class="reg_div1_infor"><input type="text" name="address" value=<%= re.getAddress() %> class="reg_td1"></td>
			<td><span class="reg_sp6" id="reg_sp6"></span></td>
		</tr>
		<tr></tr>
		<tr >	
			<td class="reg_div1_infor">*联系电话:</td> 
			<td class="reg_div1_infor"> <input type="text" name="phone"  value=<%=re.getPhone() %> class="reg_td1" id="phone"></td>	
			<td><span class="reg_sp7" id="reg_sp7"></span></td>
		</tr>
		<%
		}
	%>
		<tr>
			<td><button>确定修改</button></td>
		</tr>
			</table>
		</form>	

		
	</div>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个 人 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br>

<div class="reg_div1">个 人 信 息</div>
<a class="reg_a1" href="/big_job/re_informationServlet_test.do?idd=infor"> 修改信息</a>
	<a class="reg_a2" href="/big_job/re_informationServlet_test.do?idd=paw">修改密码</a>

	<div class="reg_div2">
		
	<table  id="customers">  

	
		<tr class="alt">
		<td>*学号/教师职工号: </td> 	<td class="reg_div1_infor">${rsUser.login_name }</td>				</tr>
		<tr >	<td >*姓名: </td>	<td class="reg_div1_infor"> ${rsUser.name }</td>	</tr>
		<tr >	<td >*性别: </td>	<td class="reg_div1_infor"> ${rsUser.sex }</td>		</tr>
		<tr >	<td >*专业: </td>	<td class="reg_div1_infor"> ${rsUser.sdept }</td>		</tr>
		<tr >	<td >*地址: </td>	<td class="reg_div1_infor"> ${rsUser.address }</td>	</tr>
		<tr >	<td>*联系电话: </td> <td class="reg_div1_infor"> ${rsUser.phone}</td>	</tr>
		

	</table>

</div>
	
</html>

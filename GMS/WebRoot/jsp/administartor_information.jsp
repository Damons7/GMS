<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管 理 员 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br>
	
<div class="reg_div1">管 理 员信 息</div>


	<div class="reg_div4">
		<a class="reg_a1" href="/big_job/administartor_re_inforServlet.do?ad=adm_infor"> 修改信息</a>
	<a class="reg_a2" href="/big_job/administartor_re_inforServlet.do?ad=adm_pwd">修改密码</a>
	<a class="reg_a3" href="/big_job/jsp/index_administrator.jsp">返回</a>
	<table  id="customers3">  

	
		<tr class="alt">
		<td>*管理员号: </td> 	<td class="reg_div1_infor">${rsUser.login_name }</td>				</tr>
		<tr >	<td >*姓名: </td>	<td class="reg_div1_infor"> ${rsUser.name }</td>	</tr>
		<tr >	<td >*性别: </td>	<td class="reg_div1_infor"> ${rsUser.sex }</td>		</tr>
		<tr >	<td >*邮箱: </td>	<td class="reg_div1_infor"> ${rsUser.email }</td>		</tr>
		<tr >	<td >*地址: </td>	<td class="reg_div1_infor"> ${rsUser.address }</td>	</tr>
		<tr >	<td>*联系电话: </td> <td class="reg_div1_infor"> ${rsUser.phone}</td>	</tr>
		

	</table>

	</div>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv= "Cache-Control " CONTENT= "no-cache ">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专 业 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
</head>

<body>
<br></br><br></br>

<div class="reg_div1">专 业 信 息</div>

	<div class="reg_div2">
	
	    <table  id="customers1" ><br></br> 
		<a href="jsp/index_administrator.jsp">返回</a>
	     <form action="${pageContext.request.contextPath}/administrator_update_sdept.do"
			method="post" onsubmit="return check()">
	
        <tr class="alt">
		<td>学号:<input type="text"  name="student_sno" readonly value="${UserSdept.sno}"></td>
		<td>姓名 :${UserSdept.name}</td>
		<td>性别：${UserSdept.sex}</td>
		<td>专业：${UserSdept.sdept}</td>	
		<td>*转至专业</td>
		<td><select name="sdept" class="reg_td1" style="text-align:center;text-align-last:center;">
  			  		<option value="软件工程" >软件工程</option>
   				    <option value="信息管理与信息系统">信息管理与信息系统</option>
   					<option value="计算机科学与技术">计算机科学与技术</option>
   				    <option value="网络工程">网络工程</option>
   					<option value="工商管理">工商管理</option>
   					<option value="物流管理">物流管理</option>
   				</select></td>
								
		<td> <input type="submit" name="submit" value="确定转专业"></td>

		</tr>
	  </form>
		</table>

	</div>
</html>
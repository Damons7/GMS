<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/big_job/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>

<title>学生系统-登录</title>
</head>
<body id="body">
	 
	<div id="login_div1">
		<div id="login_div2">
			<form action="${pageContext.request.contextPath}/login.do" method="post"  onsubmit="return check()">
			<table id="login_table">
			<center>
  		<font face="楷体" size="6" color="#000" >登录界面</font>
					
					<tr>

						<td class="l_td3"  >用户</td>
						<td><input type="text" class="l_input1" id="username" name="username"></td>
						<td><span class="reg_sp1" id="reg_sp1"></span></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td class="l_td2">请输入学号/教师职工号/管理员帐号</td>
					</tr>
					<tr>

						<td class="l_td3">密码</td>
						<td><input type="password" class="l_input1"  id="password" name="password"></td>
						<td><span class="reg_sp2" id="reg_sp2"></span></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td class="l_td2">请输入6-16位密碼！</td>
					</tr>
					
					
					<tr>
					<td class="l_td3"  >验证码</td>
					<td><input type="text"  name="checkCode"
						class="l_input2">  &nbsp;  &nbsp;<a href="javascript:show()"><img
							alt="找不到图片" src="/big_job/CheckCode" 
							id="reg_imgid"></a>		
							<a
							href="javascript:show()" id="re_a">换一张</a></td>
				
				</tr>
				
				
					<tr>

						<td></td>
			

						<td ><input type="radio" name="iden" value="administrator" maxlength = "16">管理员
						<input type="radio" name="iden" value="teacher"  maxlength = "16" >教师
						<input type="radio" name="iden" value="student" maxlength = "16">学生    &nbsp;   &nbsp;  &nbsp;  &nbsp;  
						
					<button style="background-color:#e5e8e1;">&nbsp;&nbsp;登   录&nbsp;&nbsp;</button></td>
						<td></td>
					</tr>
					<tr>

						<td></td>
						
						<td></td>
					</tr>
			
			</form>
		</div>
	</div>
			</center>

</body>
</html>
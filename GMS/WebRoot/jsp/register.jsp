<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>

	<div class="reg_div1">个人用户信息</div>

	<div class="reg_div2">

		<form action="${pageContext.request.contextPath}/CheckCodeServlet1"
			method="post" onsubmit="return check()">
	
			<table class="reg_table1">
				<tr>
					<td>*帐号</td>
					<td><input type="text" name="username" class="reg_td1"
						id="username"></td>
					<td><span class="reg_sp1" id="reg_sp1"></span></td>
				</tr>

				<tr>
					<td>*密码</td>
					<td><input type="password" name="password" class="reg_td1"
						id="password"></td>
					<td><span class="reg_sp2" id="reg_sp2"></span></td>
				</tr>
				<tr>
					<td>*确认密码</td>
					<td><input type="password" name="password2" class="reg_td1"
						id="password2"></td>
					<td><span class="reg_sp3" id="reg_sp3"></span></td>
				</tr>
				<tr>
					<td>*真实姓名</td>
					<td><input type="text" name="ni_name" class="reg_td1">
					</td>
					<td><span class="reg_sp4" id="reg_sp4"></span></td>
				</tr>
				<tr>
					<td>*学号</td>
					<td><input type="text" name="sno" class="reg_td1">
					</td>
				
				</tr>
				<tr>	
				<td>*专业</td>
				<td><select name="sdept" class="reg_td1" style="text-align:center;text-align-last:center;">
  			  		<option value="软件工程" >软件工程</option>
   				    <option value="信息管理与信息系统">信息管理与信息系统</option>
   					<option value="计算机科学与技术">计算机科学与技术</option>
   				    <option value="网络工程">网络工程</option>
   					<option value="工商管理">工商管理</option>
   					<option value="物流管理">物流管理</option>
   				</select></td>
				</tr>
				<tr>
					<td>*性别</td>
					<td><input type="radio" name="sex" value="男"
						checked="checked">男 <input type="radio" name="sex"
						value="女">女</td>
					<td><span class="reg_sp5" id="reg_sp5"></span></td>
				</tr>
				<tr>
					<td>*详细地址</td>
					<td><input type="text" name="address" class="reg_td1"></td>
					<td><span class="reg_sp6" id="reg_sp6"></span></td>
				</tr>
				<tr>
					<td>*联系电话</td>
					<td><input type="text" name="phone" class="reg_td1" id="phone"></td>
					<td><span class="reg_sp7" id="reg_sp7"></span></td>
				</tr>
				<tr class="reg_tr">
					<td>*验证码</td>
					<td id="td_1"><input type="text" id="checkCode" name="checkCode"
						class="reg_td1"><a href="javascript:show()"><img
							alt="找不到图片" src="/big_job/CheckCode" class="reg_img"
							id="reg_imgid"></a></td>
					<td><span class="reg_sp8" id="reg_sp8"><a
							href="javascript:show()" id="re_a">看不清,换一张</a></span></td>
				</tr>
			</table>
			<input type="submit" name="submit" value="注册账号">
		</form>
		
	</div>

</body>
</html>
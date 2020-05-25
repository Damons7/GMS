<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系 统 主 页</title>
<title>课 程 信 息</title>
<link rel="stylesheet" type="text/css"href="/big_job/css/register.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath }/css/index.css">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<body>
	<div class="reg_div1">管 理 员 权 限</div>
	<div class="reg_div2">
	<talbe id="customers2">
	
<h2>管理员个人信息</h2>
&nbsp; &nbsp; &nbsp; <button class="btn btn-primary btn-lg" onclick="window.location.href='/big_job/administartor_information.do'">
	个人信息
</button>

<h2>找回密码</h2>
&nbsp; &nbsp; &nbsp; <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	 找回密码
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					用户密码重置/修改
				</h4>
			</div>
			<div class="modal-body">
				注意！需要提供身份证或其他相关证件
			</div>
			<div class="modal-footer">
				<form action="/big_job/administrator_re_information.do">
					<tr>
					<td>*帐号</td>
					<td><input type="text" name="admin_username" 
						></td>
				</tr>

				<tr>
					<td>*密码</td>
					<td><input type="password" name="admin_password"
						></td>
				
				</tr>
			<input class="btn btn-default" type="submit" value="确认修改"></form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->	

		<h2>成绩管理</h2>

&nbsp; &nbsp; &nbsp;<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2">
	成绩管理
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel2">
					学生成绩调整
				</h4>
			</div>
			<div class="modal-body">
				注意！需要提供身份证或其他相关证件
			</div>
			<div class="modal-footer">
				<form action="/big_job/administrator_coursesServlet.do">
					
					<td>*学生学号</td>
					<td><input type="text" name="sno" ></td>
					
			<input class="btn btn-default" type="submit" value="确认"></form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

		<h2>开放成绩管理</h2>

&nbsp; &nbsp; &nbsp;<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal3">
开放成绩管理
</button>

<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
				</button>
				<h5 class="modal-title" id="myModalLabel3">
					2020年-1月6-8日录入成绩
				</h5>
			</div>
			<div class="modal-body">
				请及时通知教师录入/修改成绩
				<p>	​<a class="btn btn-default" href="/big_job/Open_coursesServlet.do?is_open=1" role="button">开放</a>
				​<a class="btn btn-default" href="/big_job/Open_coursesServlet.do?is_open=0"  role="button">关闭</a></p>
			</div>
		
		</div>
	</div>
</div>

		<h2>发布公告</h2>

&nbsp; &nbsp; &nbsp;<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal4">
	发布公告
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel4" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel4">
					公告栏
				</h4>
			</div>
			
			<div class="modal-footer">
				<form action="/big_job/administrator_noticeServlet.do">
					<tr>
					
					<td><input type="text" name="notice" 
						></td>
				</tr>

			<input class="btn btn-default" type="submit" size=100 value="发布"/>
			 <input class="btn btn-default"  type="reset" value="重置" /></form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>


	<h2>退出登录</h2>

&nbsp; &nbsp; &nbsp;<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal5">
	退出登录
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel5" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
				</button>
				
			</div>
			<div class="modal-body">
				确定退出？
			</div>
			<div class="modal-footer">
				<a a class="btn btn-default" href="/big_job/exitServlet.do" role="button">退出 </a>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>
		

	</talbe>
	

</body>
</body>
</html>
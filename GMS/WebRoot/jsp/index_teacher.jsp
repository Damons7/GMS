 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=" cn.jizhu.action.LoginServlet"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>选 课 系 统</title>
<link rel="stylesheet" href="/big_job/wangshang/vendor/simple-line-icons/simple-line-icons.css">
<link rel="stylesheet" href="/big_job/wangshang/vendor/font-awesome/fontawesome-all.min.css">
<link rel="stylesheet" href="/big_job/wangshang/css/styles.css">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="sidebar-fixed header-fixed">
        <a >
            <img src="/big_job/img/pic_login_ok.gif"  class="avatar avatar-sm" alt="logo">
        </a>

        <ul class="nav nav-tabs pull-right">
         
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="/big_job/img/login_head.jpg" class="avatar avatar-sm" alt="logo">
                    <span class="small ml-1 d-md-down-none"></span>
                </a>
		 <ul class="dropdown-menu pull-right">
    
                <li class="fa fa-bell"> <a href="/big_job/select_informationServlet.do?idd=infor" class="dropdown-item">  个人信息 </a></li>            
      	 <li class="fa fa-bell"> <a href="/big_job/re_informationServlet_test.do?idd=paw" class="dropdown-item">  修改密码 </a></li> 
                <li class="fa fa-bell"> <a href="/big_job/exitServlet.do" onclick="if(confirm('确定退出？')==false) return false;"  class="dropdown-item"> 退出 </a></li> 
              
             </li>
         </ul>
         
        </ul>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">系 统 菜 单 栏</li>

  						<li class="nav-item nav-dropdown">
                        <a href="/big_job/jsp/teacher_head.jsp" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 系统首页 <i class="fa fa-caret-left"></i>
                        </a>

                        
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="/big_job/select_informationServlet.do?id=teacher" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> 个人信息 <i class="fa fa-caret-left"></i>
                        </a>

                        
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="/big_job/teacher_scServlet.do?q=sc&school_year=1&term=1" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-energy"></i> 成绩管理<i class="fa fa-caret-left"></i>
                        </a>

                       
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="/big_job/courses_teacherServlet.do?term=1&school_year=1" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-graph"></i> 学生选课信息<i class="fa fa-caret-left"></i>
                        </a>

                       
                    </li>


                    <li class="nav-item">
                        <a href="/big_job/student_noticeServlet.do?iden=teacher" class="nav-link">
                            <i class="icon icon-grid"></i>公告栏
                        </a>
                    </li>    
                
</ul>
            </nav>
      
        </div>
     </div>
     
</body>
</html>

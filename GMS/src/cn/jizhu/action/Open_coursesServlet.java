package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.courses_userService;
import cn.jizhu.service.impl.EC_userServiceImpl;
import cn.jizhu.service.impl.administratorServiceImpl;
import cn.jizhu.service.impl.courses_userServiceImpl;

public class Open_coursesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String is_open = request.getParameter("is_open");
		administratorService Service= new administratorServiceImpl();//实例化service对象
		int a=Service.is_open_sc(is_open);
		String b=Service.select_open_sc();
		if(b.equals("1")) {
			response.getWriter().append("<script>alert('系统已开放！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}else {
			response.getWriter().append("<script>alert('系统已关闭！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}
	/*
		HttpSession session = request.getSession();
		String iden=(String)session.getAttribute("iden");
				
		
			if(iden.equals("student"))
			{
				if((String)session.getAttribute("select")==null)
				{
					response.sendRedirect("/big_job/courses_informationServlet.do?id=1");
				}
				else{
				String select1=(String)session.getAttribute("select");
				if(select1.equals("no")) 
				{
					response.getWriter().append("<script>alert('系统未开放！');window.location.href='/big_job/jsp/head.jsp'</script>");	
				}
				else if(select1.equals("yes"))
				{
					response.sendRedirect("/big_job/courses_informationServlet.do?id=1");
				}
				
				}
			}
			else {
			String select = request.getParameter("select");
		session.setAttribute("select", select);
		
		if(select.equals("yes")&&iden.equals("administrator")) {
		
			response.getWriter().append("<script>alert('系统已开放！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}else if(select.equals("no")&&iden.equals("administrator")){
			response.getWriter().append("<script>alert('系统已关闭！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}
			}	*/	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


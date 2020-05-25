 package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;

import cn.jizhu.*;
public class re_scServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				HttpSession session = request.getSession();
				String term=(String)session.getAttribute("term");
				String school_year=(String)session.getAttribute("school_year");
try{
		double grade=Double.parseDouble( request.getParameter("update_sc"));
	
		String sno = request.getParameter("sno");
		String cno=request.getParameter("cno");
	
		//String term=request.getParameter("term");
	//	String school_year=request.getParameter("school_year");
	
		sc_user user = new sc_user();
		user.setCno(cno);
		user.setGrade(grade);
		user.setSno(sno);
		sc_userService service = new sc_userServiceImpl();
		int a = service.re_sc(user);
	
		if(a!=0) {
			response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year="+school_year+"&term="+term+"'</script>");
		}else {
			response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year="+school_year+"&term="+term+"'</script>");
		}	
}
catch(Exception e)
{
	response.getWriter().append("<script>alert('输入有误！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year="+school_year+"&term="+term+"'</script>");
	
}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
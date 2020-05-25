package cn.jizhu.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;
import cn.jizhu.util.Get_sc_gpa;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add_sc extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				HttpSession session = request.getSession();
				//String term=(String)session.getAttribute("term");		
			//	String scType=(String)session.getAttribute("scType");
				String school_year= request.getParameter("school_year");
				String term= request.getParameter("term");
			
		String sno = request.getParameter("sno");
		String cno = request.getParameter("cno");
		double grade=Double.parseDouble( request.getParameter("grade"));
		sc_user user = new sc_user();
		user.setGrade(grade);
		user.setSno(sno);
		user.setCno(cno);
System.out.println("的撒"+user.getCno());
		sc_userService service = new sc_userServiceImpl();
		int a = service.add_sc(user,term,school_year);

		if(a!=0) {
			response.getWriter().append("<script>alert('录入成功！');window.location.href='/big_job/select_teacher_cno.do?term="+term+"&school_year="+school_year+"'</script>");
		}else {
			response.getWriter().append("<script>alert('录入失败！');window.location.href='/big_job/select_teacher_cno.do?term="+term+"&school_year="+school_year+"'</script>");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

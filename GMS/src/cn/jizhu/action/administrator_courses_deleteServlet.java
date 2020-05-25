package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.courses_user;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.sc_userService;

import cn.jizhu.service.impl.administratorServiceImpl;
import cn.jizhu.service.impl.sc_userServiceImpl;


public class administrator_courses_deleteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {  
        doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String sno = request.getParameter("sno");
		String cno=request.getParameter("cno");
		HttpSession session = request.getSession();
		//String term=request.getParameter("term");
	//	String school_year=request.getParameter("school_year");
		String term=(String)session.getAttribute("term");
		String school_year=(String)session.getAttribute("school_year");
	
		try{
			double grade=Double.parseDouble( request.getParameter("update_sc"));
			sc_user user = new sc_user();
			user.setCno(cno);
			user.setGrade(grade);
			user.setSno(sno);
			sc_userService service = new sc_userServiceImpl();
			
			int a = service.re_sc(user);
		
			if(a!=0) {
				response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/administrator_coursesServlet.do?sno="+user.getSno()+"&term=1&school_year=1'</script>");
			}else {
				response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/administrator_coursesServlet.do?sno="+user.getSno()+"&term=1&school_year=1'</script>");
			}	
	}
	catch(Exception e)
	{
		response.getWriter().append("<script>alert('输入有误！');window.location.href='/big_job/administrator_coursesServlet.do?sno="+sno+"&term=1&school_year=1'</script>");
		
	}
		
		
	}


}


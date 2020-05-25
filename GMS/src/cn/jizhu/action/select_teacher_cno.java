package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

public class select_teacher_cno extends HttpServlet {

    
	 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {  
        doPost(request, response);  
    }  

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
    	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
	
		
	/*	HttpSession session = request.getSession();
		String tno = (String) session.getAttribute("tno");
		sc_user scuser=new sc_user();
		//scuser.setTno(tno);	
		sc_userService seService= new sc_userServiceImpl();
		List<sc_user> scuser1=seService.select_teacher_cno(tno);
		System.out.print("绿："+scuser1);  
		request.setAttribute("select_cno", scuser1);
		request.getRequestDispatcher("/jsp/add_sc.jsp").forward(request, response);*/
		String school_year= request.getParameter("school_year");
		String term  = request.getParameter("term");
		HttpSession session = request.getSession();
		String tno=(String)session.getAttribute("tno");
		sc_userService seService= new sc_userServiceImpl();
		sc_user sc=new sc_user();
		sc=seService.select_teacher_cno(tno,school_year,term);
		String is_open=seService.select_open_sc();
		request.setAttribute("cno", sc.getCno());
		request.setAttribute("cname", sc.getCname());
		request.setAttribute("term", term);
		
		session.setAttribute("term", term);
		session.setAttribute("school_year", school_year);
		request.setAttribute("school_year", school_year);
			
		
		 if(!school_year.equals("3"))
			 response.getWriter().append("<script>alert('该学年已结束，无法继续操作 ！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year=1&term=1'</script>");
		 else if(is_open.equals("0"))
			response.getWriter().append("<script>alert('系统未开放！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year=1&term=1'</script>");
		 else if(is_open.equals("1"))
			request.getRequestDispatcher("/jsp/add_sc.jsp").forward(request, response);
		
	
    }

}
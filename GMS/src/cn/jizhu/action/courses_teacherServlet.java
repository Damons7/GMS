package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.courses_user;
import cn.jizhu.service.courses_userService;
import cn.jizhu.service.impl.courses_userServiceImpl;

public class courses_teacherServlet extends HttpServlet {

	   public courses_teacherServlet()  
	    {  
	        super();  
	    }  

		    public void init() throws ServletException  
		    {}  
 
		    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
		    {  
		        doPost(request, response);  
		    }  

		    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  

				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String school_year= request.getParameter("school_year");
				String term  = request.getParameter("term");
				HttpSession session = request.getSession();	
				String tno = (String) session.getAttribute("tno");
				courses_userService teService= new courses_userServiceImpl();//实例化service对象
				List<courses_user> telist = teService.findCoursesByteacher(tno,school_year,term);
				request.setAttribute("telist", telist);				
		    	request.getRequestDispatcher("/jsp/courses_teacher.jsp").forward(request, response);}
		    public void destroy()  
		    {  
		        super.destroy();  
		    }  
}


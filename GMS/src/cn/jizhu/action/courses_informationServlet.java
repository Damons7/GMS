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

public class courses_informationServlet extends HttpServlet {

	   public courses_informationServlet()  
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
				HttpSession session = request.getSession();		
				String now_sno = (String) session.getAttribute("sno");	
				String school_year= request.getParameter("school_year");
				String term  = request.getParameter("term");
				courses_userService seService= new courses_userServiceImpl();//实例化service对象
				List<courses_user> sclist = seService.findCoursesByuser(now_sno,school_year,term);
				request.setAttribute("list", sclist);
				String id = request.getParameter("id");
				if(id.equals("1")){
		    	request.getRequestDispatcher("/jsp/courses_select.jsp").forward(request, response);}
				else if(id.equals("3"))
				{
					request.getRequestDispatcher("/jsp/courses_information.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/jsp/delete_courses.jsp").forward(request, response);}
		    }        
 
		    public void destroy()  
		    {  
		        super.destroy();  
		    }  
}

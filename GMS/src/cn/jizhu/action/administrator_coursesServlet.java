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
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.administratorService;

import cn.jizhu.service.impl.administratorServiceImpl;



public class administrator_coursesServlet extends HttpServlet {
	   public administrator_coursesServlet()  
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
				String school_year= request.getParameter("school_year");
				String term = request.getParameter("term");
				String now_sno = request.getParameter("sno");
				session.setAttribute("admin_sno", now_sno);
				if(now_sno.length()!=8)
					response.getWriter().append("<script>alert('输入错误！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
				else{
			
				System.out.print("sno="+now_sno);
				if(school_year==null)
				{
					school_year="1";
				}
				if(term==null)
				{
					term="1";
				}
			
				administratorService seService1= new administratorServiceImpl();//实例化service对象
				List<sc_user> sclist1 = seService1.findCourses(now_sno,school_year,term);	
				request.setAttribute("list", sclist1);	
					request.getRequestDispatcher("/jsp/administrator_re_courses.jsp").forward(request, response);
    
		    }}
		 
		    public void destroy()  
		    {  
		        super.destroy();  
		    }  

}


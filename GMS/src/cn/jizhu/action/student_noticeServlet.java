package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.impl.administratorServiceImpl;

public class student_noticeServlet extends HttpServlet {

	   public student_noticeServlet()  
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
				String iden = request.getParameter("iden");
				
				administratorService service = new administratorServiceImpl();
				String notice1 = service.select_notice();
				HttpSession session = request.getSession();
				session.setAttribute("iden", iden);
				session.setAttribute("notice", notice1);
				if(notice1==null) {
					response.getWriter().append("<script>alert('无数据！');window.location.href='/big_job/jsp/head.jsp'</script>");
				}else {
					request.getRequestDispatcher("/jsp/notice.jsp").forward(request, response);
				}
				
		    }
		  
		  
		    public void destroy()  
		    {  
		        super.destroy();  
		    }  

}


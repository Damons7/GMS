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
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.impl.EC_userServiceImpl;
import cn.jizhu.service.impl.administratorServiceImpl;

public class administrator_noticeServlet extends HttpServlet {
	   public administrator_noticeServlet()  
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
		
				String notice1 = request.getParameter("notice");
				String notice=new String(notice1.getBytes("ISO-8859-1"),"UTF-8");
				administratorService service = new administratorServiceImpl();
				int a = service.notice(notice);
				if(a!=0) {
					response.getWriter().append("<script>alert('发布成功！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
				}else {
					response.getWriter().append("<script>alert('发布失败！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
				}
				
		    }
		  
		    public void destroy()  
		    {  
		        super.destroy();  
		    }  

}

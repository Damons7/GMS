package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.impl.administratorServiceImpl;
import cn.jizhu.service.impl.sc_userServiceImpl;
import cn.jizhu.service.impl.EC_userServiceImpl;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class administrator_update_sdept extends HttpServlet {
    public administrator_update_sdept()  
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
			String sdept = request.getParameter("sdept");
			String student_sno = request.getParameter("student_sno");
			EC_user UpdateSdept = new EC_user();
			UpdateSdept.setSdept(sdept);
			UpdateSdept.setSno(student_sno);
			administratorService seService= new administratorServiceImpl();
			int a= seService.UpdateSdept(UpdateSdept);
	 
			if(a!=0) {
				response.getWriter().append("<script>alert('转专业成功！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
			}else {
				response.getWriter().append("<script>alert('转专业失败！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
			}

	    }        
	   
	    public void destroy()  
	    {  
	        super.destroy();  
	    }  

}
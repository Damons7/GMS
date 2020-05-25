package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.impl.administratorServiceImpl;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class administrator_select_sdept extends HttpServlet {
    public administrator_select_sdept()  
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
			String student_username = request.getParameter("student_username");
			administratorService seService= new administratorServiceImpl();
			EC_user UserSdept = seService.findBySdept(student_username);    
			request.setAttribute("UserSdept", UserSdept);
				request.getRequestDispatcher("/jsp/administrator_update_sdept.jsp").forward(request, response);

	    }        
	    public void destroy()  
	    {  
	        super.destroy();  
	    }  
}

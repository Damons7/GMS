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
import cn.jizhu.service.impl.sc_userServiceImpl;
import cn.jizhu.service.impl.EC_userServiceImpl;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class select_informationServlet extends HttpServlet {
    public select_informationServlet()  
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
			String now_name = (String) session.getAttribute("username");
			EC_user select = new EC_user();
			select.setLogin_name(now_name);
			
			String id=(String) session.getAttribute("iden");
			if(id.equals("student"))
			{
				EC_userService seService= new EC_userServiceImpl();
				EC_user rsUser = seService.findByUser_stu(now_name);
				request.setAttribute("rsUser", rsUser);	
			}
			else if(id.equals("teacher"))
			{
				EC_userService seService= new EC_userServiceImpl();
				EC_user rsUser = seService.findByUser_tea(now_name);
				request.setAttribute("rsUser", rsUser);	
			}
			else if(id.equals("administartor"))
			{
				EC_userService seService= new EC_userServiceImpl();
				EC_user rsUser = seService.findByUser_adm(now_name);
				request.setAttribute("rsUser", rsUser);	
		
			}
					        
				request.getRequestDispatcher("/jsp/information.jsp").forward(request, response);

	    }        	   
	    public void destroy()  
	    {  
	        super.destroy();  
	    }  

}

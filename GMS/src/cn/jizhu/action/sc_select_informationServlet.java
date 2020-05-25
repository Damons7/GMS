package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;
import java.util.ArrayList;
import java.util.List;
public class sc_select_informationServlet extends HttpServlet {

    public sc_select_informationServlet()  
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
			String now_sno = (String) session.getAttribute("sno");
			String term= request.getParameter("term");
			String school_year= request.getParameter("school_year");
		
			sc_user scuser=new sc_user();
			scuser.setSno(now_sno);
			sc_userService seService= new sc_userServiceImpl();//实例化service对象
			List<sc_user> sclist = seService.findscByuser(now_sno,school_year,term);
	
			request.setAttribute("list", sclist);


	    	request.getRequestDispatcher("/jsp/sc_information.jsp").forward(request, response);
	    }        
	 
	    public void destroy()  
	    {  
	        super.destroy();  
	    }  

}

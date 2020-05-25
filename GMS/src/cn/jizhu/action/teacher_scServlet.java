package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class teacher_scServlet extends HttpServlet {

    
 
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	    	
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");		
			HttpSession session = request.getSession();
			String tno = (String) session.getAttribute("tno");
		//	String scType= request.getParameter("scType");
			String school_year= request.getParameter("school_year");
	//		String category = request.getParameter("category");
			String pageStr = request.getParameter("page");
			String term  = request.getParameter("term");
			session.setAttribute("school_year",school_year );
			session.setAttribute("term",term );
		//	session.setAttribute("scType",scType );
			int page =1;
			if(pageStr!=null && !"".equals(pageStr))
			{
				page =  Integer.parseInt(pageStr);
			}	 
			String q = request.getParameter("q");
			sc_user scuser=new sc_user();
			
			scuser.setTno(tno);
		
			sc_userService seService= new sc_userServiceImpl();
			String is_open=seService.select_open_sc();
			request.setAttribute("is_open", is_open);
			request.setAttribute("school_year", school_year);
			request.setAttribute("term", term);
			pageResult<sc_user> sclist = null;
			try {		
				
				sclist = seService.find_sc_bypage(tno,school_year,page,term);		
			System.out.println(sclist);		
			request.setAttribute("list2", sclist);
			session.setAttribute("list2", sclist);
			if(q.equals("sc"))
				request.getRequestDispatcher("/jsp/teacher_sc.jsp").forward(request, response);
			else if(q.equals("re")&&is_open.equals("1"))
			
				request.getRequestDispatcher("/jsp/re_sc.jsp").forward(request, response);
			else if(q.equals("re")&&is_open.equals("0"))
			
				response.getWriter().append("<script>alert('系统未开放！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year=1&term=1'</script>");
			
				else if(is_open.equals("1"))
			
				request.getRequestDispatcher("/jsp/add_sc.jsp").forward(request, response);
				
				else if(is_open.equals("0"))
		
				response.getWriter().append("<script>alert('系统未开放！');window.location.href='/big_job/teacher_scServlet.do?q=sc&school_year=1&term=1'</script>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }        
	   
	
}

package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.pageResult;
import cn.jizhu.javabean.sc_user;
import cn.jizhu.service.sc_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;

public class select_sc_rankServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		
		HttpSession session = request.getSession();
		String tno = (String) session.getAttribute("tno");
		String school_year= request.getParameter("school_year");
		String pageStr = request.getParameter("page");
		String term  = request.getParameter("term");
		session.setAttribute("school_year",school_year );
		session.setAttribute("term",term );
		int page =1;
		if(pageStr!=null && !"".equals(pageStr))
		{
			page =  Integer.parseInt(pageStr);
		}	 
		String q = request.getParameter("q");
		sc_user scuser=new sc_user();	
		scuser.setTno(tno);	
		request.setAttribute("school_year", school_year);
		request.setAttribute("term", term);	
		sc_userService seService= new sc_userServiceImpl();	
		pageResult<sc_user> sclist = null;
		try {			
			sclist = seService.find_scrank_bypage(tno,school_year,page,term);		
		System.out.println(sclist);		
		request.setAttribute("list3", sclist);
		session.setAttribute("list3", sclist);
			request.getRequestDispatcher("/jsp/select_sc_rank.jsp").forward(request, response);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }        
   
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); 
	
	}



}

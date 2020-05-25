package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exitServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	        session.removeAttribute("username");
	        session.removeAttribute("password");
	        session.removeAttribute("name");
	        session.removeAttribute("sno");
	        session.removeAttribute("iden");
	        session.removeAttribute("te_name");
	        session.removeAttribute("tno");
	        session.removeAttribute("admin_sno");
	        response.sendRedirect("/big_job/jsp/login.jsp");
		} 



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}

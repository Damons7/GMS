package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.dao.impl.EC_userDaoImpl;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.impl.sc_userServiceImpl;
import cn.jizhu.service.impl.EC_userServiceImpl;

@WebServlet("/RegisterAjaxServlet")
public class RegisterAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("ajax-->"+username);
	//	HttpSession session = request.getSession();
//		String id=(String) session.getAttribute("iden");
	
			if(username.length()==8)
		{
				EC_user findByUser=new EC_user();
			EC_userService service = new EC_userServiceImpl();
			findByUser = service.findByUser_stu(username);	
			PrintWriter pw = response.getWriter();
			System.out.println("ajax--->"+findByUser);
			if(findByUser==null) {
				pw.write("false");
			}else {
				pw.write("true");
			}
		}
		else if(username.length()==3)
		{	
			EC_user findByUser=new EC_user();
			EC_userService service = new EC_userServiceImpl();
			findByUser = service.findByUser_tea(username);
			PrintWriter pw = response.getWriter();
			System.out.println("ajax--->"+findByUser);
			if(findByUser==null) {
				pw.write("false");
			}else {
				pw.write("true");
			}
		}
		else if(username.length()==4)
		{
			EC_user findByUser=new EC_user();
			EC_userService service = new EC_userServiceImpl();
			findByUser = service.findByUser_adm(username);	
			PrintWriter pw = response.getWriter();
			
			System.out.println("呜呜呜"+findByUser.getLogin_name());
			System.out.println("ajax--->"+findByUser);
			if(findByUser==null) {
				pw.write("false");
			}else {
				pw.write("true");
			}
		}
			
	
	/*	if(findByUser==null) {
			pw.write("false");
		}else {
			pw.write("true");
		}*/
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

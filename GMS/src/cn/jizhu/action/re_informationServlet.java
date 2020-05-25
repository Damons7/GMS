
package cn.jizhu.action;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

public class re_informationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		EC_user user = new EC_user();
		user.setLogin_name(username);
		user.setPhone(phone);
		user.setAddress(address);
		HttpSession session = request.getSession();
		String id=(String) session.getAttribute("iden");
		int a=0;
		if(id.equals("student"))
		{
			EC_userService service = new EC_userServiceImpl();
			 a = service.re_information_stu(user);
		}
		else if(id.equals("teacher"))
		{
			EC_userService service = new EC_userServiceImpl();
			
			 a = service.re_information_tea(user);
		}
		else if(id.equals("administartor"))
		{
			EC_userService service = new EC_userServiceImpl();
			
			 a = service.re_information_adm(user);
			 if(a!=0) {
					response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/administartor_information.do'</script>");
				}else {
					response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/re_password.do'</script>");
				}	
		}

	//	EC_userService service = new EC_userServiceImpl();
		
		//int a = service.re_information_stu(user);

		if(a!=0) {
			response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/select_informationServlet.do'</script>");
		}else {
			response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/re_password.do'</script>");
		}					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

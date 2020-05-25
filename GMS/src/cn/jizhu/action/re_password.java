package cn.jizhu.action;
import java.io.IOException;
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
import cn.jizhu.util.encryption;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class re_password extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				HttpSession session = request.getSession();
				String username = request.getParameter("username");
				String fir_password = request.getParameter("fir_password");
				String password3 = request.getParameter("password3");
				String password4 = request.getParameter("password4");	
				String id=(String) session.getAttribute("iden");
				EC_user rsUser =new EC_user();
				System.out.println("原始密码："+fir_password);
				rsUser=null;
				encryption encr=new encryption();
				fir_password =encr.encryptions(fir_password );
				if(id.equals("student"))
				{
					EC_userService seService= new EC_userServiceImpl();
					 rsUser = seService.findByUser_stu(username);
				}
				else if(id.equals("teacher"))
				{
					EC_userService seService= new EC_userServiceImpl();
					 rsUser = seService.findByUser_tea(username);
				}
				else if(id.equals("administartor"))
				{
					EC_userService seService= new EC_userServiceImpl();
					rsUser = seService.findByUser_adm(username);
				}
				System.out.println("原始密码222："+rsUser.getPassword());
			//	EC_userService seService= new EC_userServiceImpl();
			//	EC_user rsUser = seService.findByUser(username);
			
			if(fir_password.equals(rsUser.getPassword())==false)
				
			{
				System.out.println("原密码错误！");
				response.getWriter().append("<script>alert('原密码错误！');window.location.href='/big_job/re_informationServlet_test.do?idd=paw'</script>");
				
			}
			else
				if(password3.equals(password4)==false)
					
				{
					System.out.println("两次密码不一致！");
					response.getWriter().append("<script>alert('两次密码不一致！');window.location.href='/big_job/re_informationServlet_test.do?idd=paw'</script>");
					
				}
			else{

				EC_user user = new EC_user();
			
				password3=encr.encryptions(password3);
				user.setLogin_name(username);
				user.setPassword(password3);
				int a=0;
				if(id.equals("student"))
				{
					EC_userService service = new EC_userServiceImpl();
					 a = service.re_password_stu(user);

				}
				else if(id.equals("teacher"))
				{
					EC_userService service = new EC_userServiceImpl();
					a = service.re_password_tea(user);

				}
				else if(id.equals("administartor"))
				{
					EC_userService service = new EC_userServiceImpl();
					 a = service.re_password_adm(user);

				}
			//	EC_userService service = new EC_userServiceImpl();
			//	int a = service.re_password(user);

				if(a!=0) {
					response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/select_informationServlet.do'</script>");
				}else {
					response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/re_password.do'</script>");
				}					
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

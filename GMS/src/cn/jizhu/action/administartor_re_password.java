package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.impl.EC_userServiceImpl;

public class administartor_re_password extends HttpServlet {

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String fir_password = request.getParameter("fir_password");
		String password3 = request.getParameter("password3");
		String password4 = request.getParameter("password4");	
		EC_user rsUser =new EC_user();
		System.out.println("原始密码："+fir_password);
		rsUser=null;
		
			EC_userService seService= new EC_userServiceImpl();
			rsUser = seService.findByUser_adm(username);

	if(fir_password.equals(rsUser.getPassword())==false)
		
	{
		System.out.println("原密码错误！");
		response.getWriter().append("<script>alert('原密码错误！');window.location.href='/big_job/administartor_re_inforServlet.do?ad=adm_pwd'</script>");
		
	}
	else
		if(password3.equals(password4)==false)
			
		{
			System.out.println("两次密码不一致！");
			response.getWriter().append("<script>alert('两次密码不一致！');window.location.href='/big_job/administartor_re_inforServlet.do?ad=adm_pwd'</script>");
			
		}
	else{

		EC_user user = new EC_user();
		user.setLogin_name(username);
		user.setPassword(password3);
		int a=0;
		
			EC_userService service = new EC_userServiceImpl();
			 a = service.re_password_adm(user);
			 if(a!=0) {
					response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/administartor_information.do'</script>");
				}else {
					response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/administartor_re_inforServlet.do?ad=adm_pwd'</script>");
				}	
		
					
	}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);  
	}

	
}

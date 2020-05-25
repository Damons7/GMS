 package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.admin_user;
import cn.jizhu.service.administratorService;
import cn.jizhu.service.impl.administratorServiceImpl;

public class administrator_re_information extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("admin_username");
		String password = request.getParameter("admin_password");
		HttpSession session = request.getSession();	
		String te_cno =(String)session.getAttribute("sno");
		admin_user user = new admin_user();
		user.setLogin_name(username);
		user.setPassword(password);
		
		administratorService service1 = new administratorServiceImpl();
		int a = service1.re_information(user);

		if(a!=0) {
			response.getWriter().append("<script>alert('修改成功！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}else {
			response.getWriter().append("<script>alert('修改失败！');window.location.href='/big_job/jsp/index_administrator.jsp'</script>");
		}			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}

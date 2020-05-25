package cn.jizhu.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jizhu.javabean.EC_user;
import cn.jizhu.service.EC_userService;
import cn.jizhu.service.impl.EC_userServiceImpl;
import cn.jizhu.service.impl.sc_userServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ni_name = request.getParameter("ni_name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String sno = request.getParameter("sno");
		String sdept = request.getParameter("sdept");
		EC_user user = new EC_user();
		user.setLogin_name(username);
		user.setPassword(password);
		user.setName(ni_name);
		user.setPhone(phone);
		user.setAddress(address);
		user.setSex(sex);
		user.setSno(sno);
		user.setSdept(sdept);
		EC_userService service = new EC_userServiceImpl();
//		int a = service.register(user);
		int a=0;
		if (a != 0) {
			response.getWriter()
					.append("<script>alert('注册成功！');window.location.href='/big_job/jsp/login.jsp'</script>");
		} else {
			response.getWriter()
					.append("<script>alert('注册失败！');window.location.href='/big_job/jsp/register.jsp'</script>");
		}

	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

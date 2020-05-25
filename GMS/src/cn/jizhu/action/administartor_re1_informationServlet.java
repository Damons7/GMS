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

public class administartor_re1_informationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			EC_userService service = new EC_userServiceImpl();
		
		int a = service.re_information_adm(user);
	
			if (a != 0) {
				response.getWriter()
						.append("<script>alert('修改成功！');window.location.href='/big_job/administartor_information.do'</script>");
			} else {
				response.getWriter()
						.append("<script>alert('修改失败！');window.location.href='/big_job/administartor_re_inforServlet.do?ad=adm_infor'</script>");
			}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}

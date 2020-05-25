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
import cn.jizhu.service.impl.EC_userServiceImpl;
import cn.jizhu.util.encryption;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession sessions = request.getSession();
		String seecode = (String) sessions.getAttribute("sesscode");
		String inputcode = request.getParameter("checkCode");
		String username = request.getParameter("username");
		encryption encr=new encryption();
		String password =encr.encryptions(request.getParameter("password"));
		String iden=null;
		 iden = request.getParameter("iden");
			sessions.setAttribute("iden", iden);
			EC_user inputUser = new EC_user();
			inputUser.setLogin_name(username);
			inputUser.setPassword(password);
			EC_userService ecService = new EC_userServiceImpl();
			if(request.getParameter("iden")==null)
			{
				response.getWriter().append("<script>alert('请选择用户身份！');window.location.href='/big_job/jsp/login.jsp'</script>");
			}
		
			else 
			{

		if (iden.equals("student"))
		{
		EC_user rsUser = ecService.login_stu(inputUser);
		if (rsUser == null) {
			response.getWriter()
					.append("<script>alert('学生不存在！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(!rsUser.getIdentity().equals(iden))
		{
			response.getWriter()
			.append("<script>alert('身份错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (password==null) 
		{
			response.getWriter()
			.append("<script>alert('密码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (!password.equals(rsUser.getPassword())) 
		{
			response.getWriter()
			.append("<script>alert('密码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(inputcode.length()==0)
		{
			response.getWriter().append(
					"<script>alert('验证码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		
		else if(!inputcode.equalsIgnoreCase(seecode))
		{
			response.getWriter().append(
					"<script>alert('验证码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(inputcode.equalsIgnoreCase(seecode)){
		String loginName = rsUser.getLogin_name();
		HttpSession session = request.getSession();
		session.setAttribute("username", loginName);
		session.setAttribute("password", password);
		session.setAttribute("name", rsUser.getName());
		session.setAttribute("sno", rsUser.getSno());
		session.setAttribute("iden", iden);
		response.sendRedirect("/big_job/jsp/head.jsp");
		}
		}
		//判断教师
		else if (iden.equals("teacher"))
		{
			System.out.println("为222221");
		EC_user rsUser = ecService.login_tea(inputUser);
		if (rsUser == null) {
			response.getWriter()
					.append("<script>alert('教师不存在！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (password==null) 
		{
			response.getWriter()
			.append("<script>alert('密码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (!password.equals(rsUser.getPassword())) 
		{
			response.getWriter()
			.append("<script>alert('密码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(!rsUser.getIdentity().equals(iden))
		{
			response.getWriter()
			.append("<script>alert('身份错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(inputcode.length()==0)
		{
			response.getWriter().append(
					"<script>alert('验证码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		
		else if(!inputcode.equalsIgnoreCase(seecode))
		{
			response.getWriter().append(
					"<script>alert('验证码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(inputcode.equalsIgnoreCase(seecode))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", rsUser.getLogin_name());
			session.setAttribute("password", password);
			session.setAttribute("name", rsUser.getName());
			session.setAttribute("tno", rsUser.getTno());
			session.setAttribute("iden", iden);
			response.sendRedirect("/big_jo" +
					"b/jsp/teacher_head.jsp");
		}
		}
		//判断管理员
		else 
		{
		EC_user rsUser = ecService.login_adm(inputUser);
		if (rsUser == null) {
			response.getWriter()
					.append("<script>alert('管理员不存在！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (password==null) 
		{
			response.getWriter()
			.append("<script>alert('密码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if (!password.equals(rsUser.getPassword())) 
		{
			response.getWriter()
			.append("<script>alert('密码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(!rsUser.getIdentity().equals(iden))
		{
			response.getWriter()
			.append("<script>alert('身份错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}	
		else if(inputcode.length()==0)
		{
			response.getWriter().append(
					"<script>alert('验证码为空！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		
		else if(!inputcode.equalsIgnoreCase(seecode))
		{
			response.getWriter().append(
					"<script>alert('验证码错误！');window.location.href='/big_job/jsp/login.jsp'</script>");
		}
		else if(inputcode.equalsIgnoreCase(seecode))	
		{
			String loginName = rsUser.getLogin_name();
			HttpSession session = request.getSession();
			session.setAttribute("username", loginName);
			session.setAttribute("password", password);
			session.setAttribute("name", rsUser.getName());
			session.setAttribute("iden", iden);
			System.out.println("管理员登录");
			response.sendRedirect("/big_job/jsp/index_administrator.jsp");
		}
	

		
		}
			}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
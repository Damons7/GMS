package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jizhu.javabean.EC_user;
import cn.jizhu.javabean.courses_user;

import cn.jizhu.service.courses_userService;

import cn.jizhu.service.impl.courses_userServiceImpl;
import java.util.List;

public class courses_select extends HttpServlet {

    public courses_select()  
    {  
        super();  
    }  
 
    public void init() throws ServletException  
    {}  
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
    {  
        doPost(request, response);  
    }  
 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cno = request.getParameter("cno1");
		courses_user user1 = new courses_user();
		user1.setCno1(cno);
		courses_userService service1 = new courses_userServiceImpl();
		boolean p =service1.courses_max(cno);
		if(p)
		{
			response.getWriter().append("<script>alert('该课程人数已达上限，无法继续选课！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}
		else{
		HttpSession session1 = request.getSession();
		 int a1 = (Integer)session1.getAttribute("a");
		if(a1==6)
		{
			response.getWriter().append("<script>alert('您的课程已满。，无法继续选课！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}else{
		String cno1 = request.getParameter("cno1");
		String sno = request.getParameter("sno");
		String cname = request.getParameter("cname");		
		String cname1=new String(cname.getBytes("ISO-8859-1"),"UTF-8");	
		String te_name = request.getParameter("te_name");
		String tno = request.getParameter("tno");
		courses_user user = new courses_user();
		user.setCno1(cno1);
		user.setSno(sno);
		user.setCname(cname1);
		user.setTe_name(te_name);		
		courses_userService service = new courses_userServiceImpl();
		int a = service.courses_select(user);
		if(a!=0) {
			response.getWriter().append("<script>alert('选课成功！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}else {
			response.getWriter().append("<script>alert('选课失败！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}
    }
}}
    public void destroy()  
    {  
        super.destroy();  
    }  
}

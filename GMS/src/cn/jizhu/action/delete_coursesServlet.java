package cn.jizhu.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jizhu.javabean.courses_user;

import cn.jizhu.service.courses_userService;

import cn.jizhu.service.impl.courses_userServiceImpl;
import java.util.List;

public class delete_coursesServlet extends HttpServlet {

    public delete_coursesServlet()  
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
		String te_name = request.getParameter("te_name");
		String cno1 = request.getParameter("cno");
		HttpSession session2 = request.getSession();
		String sno = (String)session2.getAttribute("sno");	
		courses_user user = new courses_user();
		user.setCno1(cno1);
		user.setSno(sno);
		user.setTe_name(te_name);	
		courses_userService service1 = new courses_userServiceImpl();
		int a2 = service1.courses_delete(user);
		if(a2!=0) {
			response.getWriter().append("<script>alert('删除成功！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}else {
			response.getWriter().append("<script>alert('删除失败！');window.location.href='/big_job/courses_informationServlet.do?id=1'</script>");
		}
    }

    public void destroy()  
    {  
        super.destroy();  
    }  

}

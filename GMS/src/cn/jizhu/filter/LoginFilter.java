package cn.jizhu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest http_request = (HttpServletRequest)request;
		HttpServletResponse http_response = (HttpServletResponse)response;
		 
		 HttpSession session = http_request.getSession();
		 String username = (String)session.getAttribute("username");
		 
		 String path = http_request.getRequestURI();
		 if(path.indexOf("/index.jsp")!=-1){
		 
		 chain.doFilter(http_request, http_response);
		 return ;
		}
		
			 if(path.indexOf("/login.jsp")!=-1){
		 
		 chain.doFilter(http_request, http_response);
		 return ;
		}
			 if(path.indexOf("/register.jsp")!=-1){
		 
		 chain.doFilter(http_request, http_response);
		 return ;
		}
		if(username!=null){
		chain.doFilter(http_request, http_response);
		}else{
		http_response.sendRedirect("/big_job/jsp/login.jsp");
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	
		System.out.println("LoginFilter已被創建");
		
	}

}

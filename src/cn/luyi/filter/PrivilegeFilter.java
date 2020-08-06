package cn.luyi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.luyi.domain.User;

public class PrivilegeFilter implements Filter {


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断用户是否已经登录了，如果已经登录，则放行，如果没有登录，回到登录页面
		HttpServletRequest req = (HttpServletRequest)request;
		User existUser = (User) req.getSession().getAttribute("existUser");
		if(existUser == null){
			//登录失败
			req.setAttribute("msg", "您还没有登录，没有权限访问该路径");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}else{
			//登录成功
			chain.doFilter(req, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

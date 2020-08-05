package cn.luyi.controller;

/**
 * 负责资源的调度
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.luyi.domain.User;
import cn.luyi.model.UserModel;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			//接收数据
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//一次性验证码的校验
			//接收用户输入的验证码
			String randomCode1 = request.getParameter("randomCode").toLowerCase();
			//获取session里的验证码
			String randomCode2 = ((String) request.getSession().getAttribute("randomCode")).toLowerCase();
			//为了保证验证码只使用一次，应该把session中的验证码情况
			request.getSession().removeAttribute("randomCode");
			//比较两个验证码
			if(! randomCode1.equals(randomCode2)){
				request.setAttribute("msg", "验证码输入错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			
			//封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			//处理数据
			UserModel userModel = new UserModel();
			User exitUser = userModel.login(user);
			
			//记住用户名：
			
			//判断复选框是否已经勾选了：
			String rememberPassword = (String) request.getAttribute("rememberPassword");
			if("true".equals(rememberPassword)){
				//已经勾选
				Cookie cookie = new Cookie("remember", exitUser.getUsername());
				//设置有效路径：
				cookie.setPath("/jsp_mvc_demo");
				//设置有效时长
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			
			//页面跳转
			if(exitUser == null){
				//登录失败
				
				request.setAttribute("msg", "用户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//登录成功
				
				//把用户信息存入session中
				HttpSession session = request.getSession();
				session.setAttribute("exitUser", exitUser);
				//重定向到成功页面
				response.sendRedirect("/jsp_mvc_demo/success.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

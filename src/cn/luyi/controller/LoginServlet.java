package cn.luyi.controller;

/**
 * ������Դ�ĵ���
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
			//��������
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//һ������֤���У��
			//�����û��������֤��
			String randomCode1 = request.getParameter("randomCode").toLowerCase();
			//��ȡsession�����֤��
			String randomCode2 = ((String) request.getSession().getAttribute("randomCode")).toLowerCase();
			//Ϊ�˱�֤��֤��ֻʹ��һ�Σ�Ӧ�ð�session�е���֤�����
			request.getSession().removeAttribute("randomCode");
			//�Ƚ�������֤��
			if(! randomCode1.equals(randomCode2)){
				request.setAttribute("msg", "��֤���������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			
			//��װ����
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			//��������
			UserModel userModel = new UserModel();
			User exitUser = userModel.login(user);
			
			//��ס�û�����
			
			//�жϸ�ѡ���Ƿ��Ѿ���ѡ�ˣ�
			String rememberPassword = (String) request.getAttribute("rememberPassword");
			if("true".equals(rememberPassword)){
				//�Ѿ���ѡ
				Cookie cookie = new Cookie("remember", exitUser.getUsername());
				//������Ч·����
				cookie.setPath("/jsp_mvc_demo");
				//������Чʱ��
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			}
			
			//ҳ����ת
			if(exitUser == null){
				//��¼ʧ��
				
				request.setAttribute("msg", "�û������������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//��¼�ɹ�
				
				//���û���Ϣ����session��
				HttpSession session = request.getSession();
				session.setAttribute("exitUser", exitUser);
				//�ض��򵽳ɹ�ҳ��
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

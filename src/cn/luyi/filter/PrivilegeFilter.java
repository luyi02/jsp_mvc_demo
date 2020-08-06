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
		//�ж��û��Ƿ��Ѿ���¼�ˣ�����Ѿ���¼������У����û�е�¼���ص���¼ҳ��
		HttpServletRequest req = (HttpServletRequest)request;
		User existUser = (User) req.getSession().getAttribute("existUser");
		if(existUser == null){
			//��¼ʧ��
			req.setAttribute("msg", "����û�е�¼��û��Ȩ�޷��ʸ�·��");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
		}else{
			//��¼�ɹ�
			chain.doFilter(req, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

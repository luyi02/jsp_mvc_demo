package cn.luyi.filter;

/**
 * ͨ�õ��ַ�������������Ĵ���ʵ��
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class GenericEncodingFilter implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�ڹ���������ǿrequest���󣬲�����ǿ���request���󴫵ݸ�Servlet��
		HttpServletRequest req = (HttpServletRequest)request;
		MyHttpServletRequest myReq = new MyHttpServletRequest(req);
		chain.doFilter(myReq, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

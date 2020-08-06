package cn.luyi.filter;

/**
 * 通用的字符集编码过滤器的代码实现
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
		//在过滤器中增强request对象，并将增强后的request对象传递给Servlet：
		HttpServletRequest req = (HttpServletRequest)request;
		MyHttpServletRequest myReq = new MyHttpServletRequest(req);
		chain.doFilter(myReq, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package cn.luyi.filter;

import java.io.UnsupportedEncodingException;

/**
 * ��ǿ����
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String method = request.getMethod();
		if("GET".equalsIgnoreCase(method)){
			//get������ʽ
			String value = super.getParameter(name);
			
			try {
				value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return value;
		}else if("post".equalsIgnoreCase(method)){
			//post��ʽ������
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return super.getParameter(name);
	}
}

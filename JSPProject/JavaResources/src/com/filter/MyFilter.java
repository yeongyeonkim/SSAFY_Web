package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "/MyFilter", urlPatterns = {"/HelloServlet","/ByeServlet"})
public class MyFilter implements Filter {

	public void destroy() {
	}

	//doFilter() : 필터가 수행해야 되는 내용을 가지고 있는 메소드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전 처리 작업 내용
		System.out.println("MyFilter...before");
		
		chain.doFilter(request, response);//다음 필터나 서블릿으로 request, response 객체 전달
		
		System.out.println("MyFilter...after");
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

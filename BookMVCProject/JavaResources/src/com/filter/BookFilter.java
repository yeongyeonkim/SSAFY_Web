package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BookController;

// 클라이언트의 모든 요청이 들어오는 front controller
 @WebFilter(filterName="/BookFilter", urlPatterns ="*.book")
public class BookFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		req.setCharacterEncoding("euc-kr"); // 클라이언트로부터 들어오는 한글 안 깨지게 처리
		BookController cc = new BookController();
		
		/*getServletPath(): http://localhost:8080/customer(context-root)/list.cus(servletpath)*/
		String reqString = req.getServletPath();	
		System.out.println(reqString);
		if(reqString.equals("/list.book")) { // 초기화면
			cc.list(req, res);
		}else if(reqString.equals("/read.book")) { // 상세화면
			cc.read(req, res);
		}
		else if(reqString.equals("/login.book")) { // 상세화면
			cc.login(req, res);
		}
		else if(reqString.equals("/insert.book")) { // 상세화면
			cc.insert(req, res);
		}
		else if(reqString.equals("/insertProcess.book")) { // 상세화면
			cc.insertProcess(req, res);
		}
		else if(reqString.equals("/loginProcess.book")) { // 상세화면
			cc.loginProcess(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.CustomerController;

//클라이언트의  모든 요청이 들어오는 front controller
//@WebFilter(filterName="/CustomerFilter", urlPatterns={"*.cus"})
//@WebFilter("/CustomerFilter")
public class CustomerFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8");//클라이언트로부터 들어오는 한글 안깨지게 처리
		
		CustomerController cc = new CustomerController();
		//클라이언트로부터 들어오는 요청을 구분해서 Controller에게 작업 지시
		//http://localhost:port/context-root/list.cus
		//url 값에서 맨끝부분의 문자를 알아냄 : /list.cus, read.cus....
		String reqString = req.getServletPath();
		//System.out.println(reqString);
		
		if(reqString.equals("/list.cus")) {//초기화면
			cc.list(req, res);
		}else if(reqString.equals("/read.cus")) {//상세화면
			cc.read(req, res);
		}else if(reqString.equals("/insert.cus")) {//상세화면
			cc.insert(req, res);
			
		}else if(reqString.equals("/insertProcess.cus")) {//상세화면
			cc.insertProcess(req, res);
			
		}else if(reqString.equals("/delete.cus")) {//상세화면
			cc.delete(req, res);
			
		}else if(reqString.equals("/login.cus")) {//로그인화면
			cc.login(req, res);
			
		}else if(reqString.equals("/loginProcess.cus")) {//로그인처리
			cc.loginProcess(req, res);
			
		}else if(reqString.equals("/logout.cus")) {//로그아웃
			cc.logout(req, res);
			
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}



















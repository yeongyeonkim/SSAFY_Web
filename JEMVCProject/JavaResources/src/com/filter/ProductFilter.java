package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//클라이언트의 모든 요청이 들어오는 Front Controller
//@WebFilter("/CustomerFilter") 이렇게 해도 되고
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.ProductController;
@WebFilter(filterName="/ProductFilter",urlPatterns="*.pro")
public class ProductFilter implements Filter {

	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8"); //클라이언트로부터 들어오는 한글 안깨지게 처리
		
		ProductController cc= new ProductController();
		//클라이언트로부터 들어오는 오청을 구분해서 Controller에게 작업 지시
		//url 값에서 맨 끝부분의 문자를 알아냄 : /list.cus, read.cus ...
		String reqString = req.getServletPath(); //맨마지막 list.cus 를 알아내는 부분
		
		if(reqString.equals("/list.pro")) {	//초기화면
			cc.list(req,res); //컨트롤러한테 일을시키는데 걔중 list한테 시킴
			
		}else if(reqString.equals("/read.pro")) { //상세화면
			cc.read(req,res);
		}else if(reqString.equals("/delete.pro")) { 
			cc.delete(req,res);
		}else if(reqString.equals("/insert.pro")) { 
			cc.insert(req,res);
		}else if(reqString.equals("/search.pro")) { 
			cc.search(req,res);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

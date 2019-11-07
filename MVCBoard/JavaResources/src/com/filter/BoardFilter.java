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

import com.controller.BoardController;
@WebFilter(filterName="/BoardFilter",urlPatterns= {"*.bod"})
public class BoardFilter implements Filter {

	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		req.setCharacterEncoding("utf-8"); //클라이언트로부터 들어오는 한글 안깨지게 처리
		
		BoardController cc= new BoardController();
		
		//클라이언트로부터 들어오는 오청을 구분해서 Controller에게 작업 지시
		//http://localhost:port/context-root/list.cus
		//url 값에서 맨 끝부분의 문자를 알아냄 : /list.cus, read.cus ...
		String reqString = req.getServletPath(); //맨마지막 list.cus 를 알아내는 부분
		System.out.println(reqString);
		
		if(reqString.equals("/list.bod")) {	//초기화면
			try {
				cc.list(req,res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //컨트롤러한테 일을시키는데 걔중 list한테 시킴
			
		}else if(reqString.equals("/read.bod")) { //상세화면
			cc.read(req,res);
		}else if(reqString.equals("/read2.bod")) { //상세화면
			cc.read2(req,res);
		}else if(reqString.equals("/delete.bod")) { 
			cc.delete(req,res);
		}else if(reqString.equals("/insertForm.bod")) { 
			cc.insertForm(req,res);
		}else if(reqString.equals("/insertProcess.bod")) { //로그인 화면
			cc.insertProcess(req,res);
		} else if(reqString.equals("/logout.bod")) { //로그아웃
		//	cc.logout(req,res);
		}else if(reqString.equals("/login.bod")) { //로그아웃
		//	cc.login(req,res);
		}else if(reqString.equals("/loginProcess.bod")) { //로그아웃
		//	cc.loginProcess(req,res);
		}else if(reqString.equals("/search.bod")) { //검색요청
			cc.search(req,res);
		}else if(reqString.equals("/content.bod")) {
			cc.content(req,res);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

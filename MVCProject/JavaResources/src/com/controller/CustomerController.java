package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Customer;
import com.model.CustomerDAO;
import com.model.ICustomerDAO;

//Front Controller에서 넘어온 요청을 받아 처리(Model에게 넘겨서 처리)
//Model이 작업한 결과를 받아서 request에 저장시키고 view(jsp)로 넘어감(forward)

public class CustomerController {
	ICustomerDAO dao;//인터페이스안에 있는 메소드만 호출 가능
	
	public CustomerController() {
		dao = new CustomerDAO();
	}
	
	public void list(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList<Customer> list = dao.selectAll();//customer 테이블 안의 모든 데이터 검색
		req.setAttribute("list", list);//jsp 에서 꺼내 쓰도록 list 저장
		
		//jsp로 forward 해서 넘어가기
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		Customer c = dao.selectOne(num);
		req.setAttribute("c", c);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}			
	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		dao.delete(num);
		
		//초기화면으로 가기
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void insert(HttpServletRequest req, HttpServletResponse res) {
		//session check -> 로그인 했는지 확인해서
		//로그인 했으면 원래 내용 그대로 보내주면 되고
		//로그인 안했으면 로그인 화면 보내줘야 함
		
		HttpSession session = req.getSession();
		String login = (String)session.getAttribute("login");
		if(login != null) {//login한 경우
			//원래 내용
			RequestDispatcher dis = req.getRequestDispatcher("/view/insert.jsp");
			try {
				dis.forward(req, res);
			} catch (Exception e) {			
				e.printStackTrace();
			}	
		}else {//로그인 안한 경우
			RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
			try {
				dis.forward(req, res);
			} catch (Exception e) {			
				e.printStackTrace();
			}	
			
		}		
		
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {
		//사용자가 입력한 id, pass 받아와서 체크하기
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("login", id);//세션에 아이디 저장
		
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.setAttribute("login", null);//세션에 아이디 저장
		
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		Customer c = new Customer(num, name, address);
		dao.insert(c);
		req.setAttribute("c", c);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/insertSuccess.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}












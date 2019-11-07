package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		process(req, res);
	}

	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		req.setCharacterEncoding("EUC-KR");
		String action = req.getParameter("action");
		// dao 객체 생성
		ICustomer dao = new CustomerDAO();

		if (action == null) {// 초기요청 //localhost:8080/MyMVCDB/main.do?action = ~~~ 가 없을테니 처음엔

			// dao에 db 작업 지시 후 결과 받기
			List<Customer> list = dao.selectAll();
			// req에 데이터 저장
			req.setAttribute("list", list);

			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp");
			dis.forward(req, res);

		} else if (action.equals("read")) {// detail
			String num = req.getParameter("num");
			Customer c = dao.selectOne(num);
			req.setAttribute("c", c);
			RequestDispatcher dis = req.getRequestDispatcher("view/read.jsp");
			dis.forward(req, res);
		} else if (action.equals("insertForm")) {// 새 데이터 입력 화면

			RequestDispatcher dis = req.getRequestDispatcher("view/insert.jsp");
			dis.forward(req, res);

		} else if (action.equals("insertProcess")) {// db에 insert 하기
			String num = req.getParameter("num");
			String name = req.getParameter("name");
			System.out.println(name);
			String address = req.getParameter("address");
			Customer c = new Customer(num, name, address);
			dao.insert(c);
			req.setAttribute("c", c);
			RequestDispatcher dis = req.getRequestDispatcher("view/insertSuccess.jsp");
			dis.forward(req, res);

		} else if (action.equals("updateForm")) {// 수정 전 원래 데이터 보여주는 화면. 상세화면에 링크로 표시
			String num = req.getParameter("num");
			req.setAttribute("num", num);
			RequestDispatcher dis = req.getRequestDispatcher("view/update.jsp");
			dis.forward(req, res);
		} else if (action.equals("updateProcess")) {// db에 수정하기

			dao.update(req.getParameter("num"), req.getParameter("address"));
			Customer c = dao.selectOne(req.getParameter("num"));
			req.setAttribute("c", c);


			RequestDispatcher dis = req.getRequestDispatcher("view/read.jsp");
			dis.forward(req, res);
		} else if (action.equals("delete")) {// 삭제
			String num = req.getParameter("num");
			int r = dao.delete(num);
			if(r == 1) {
				req.setAttribute("result", "회원삭제성공");
			} else {
				
			}
			req.getRequestDispatcher("view/result.jsp").forward(req, res);
			res.sendRedirect("main.do");
		} else if (action.equals("findByAddress")) {// 주소로 검색. 초기화면에 form으로 추가
			String address = req.getParameter("address");
			List<Customer> list = dao.findByAddress(address);
			req.setAttribute("list", list);

			RequestDispatcher dis = req.getRequestDispatcher("view/search.jsp");
			dis.forward(req, res);
		} else if (action.equals("loginForm")) {//로그인 화면 요청
			RequestDispatcher dis = req.getRequestDispatcher("view/loginForm.jsp");
			dis.forward(req, res);
		} else if (action.equals("loginProcess")) {//로그인 정보 session에 저장 후 화면 redirect
			HttpSession session = req.getSession();
			session.setAttribute("id", req.getParameter("id"));

			res.sendRedirect("main.do");
			
		} else if (action.equals("logout")) {//session에 저장된 로그인 정보 삭제
			HttpSession session = req.getSession();
			session.setAttribute("id", null);
		}
	}

}
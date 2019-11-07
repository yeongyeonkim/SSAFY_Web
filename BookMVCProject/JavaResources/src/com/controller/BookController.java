package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Book;
import com.model.BookDAO;


// FrontController에게 넘어온 요청을 받아 처리(Model에게 넘겨서 처리)
// Model이 작업한 결과를 받아서 request에 저장시키고  view(jsp)로 넘어감(forward)

public class BookController {
	BookDAO dao; // 인터페이스 안에 있는 메소드만 호출 가능

	public BookController() {
		dao = new BookDAO();
	}

	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Book> list = dao.selectAll(); // customer 테이블 안의 모든 데이터 검색
		
		req.setAttribute("list", list); // jsp에서 꺼내 쓰도록 list 저장

		// jsp로 forward해서 넘어가기
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		try{
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		Book c = dao.selectOne(isbn);
		req.setAttribute("c", c);

		// jsp로 forward해서 넘어가기
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try{
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(HttpServletRequest req, HttpServletResponse res) {
		// session check -> 로그인했는지 확인
		// 로그인 했으면 원래 내용 그대로 보내주면 되고
		// 로그인 안했으면 로그인 화면 보내줘야함
		HttpSession session = req.getSession();
		String login = (String)session.getAttribute("login");
		if(login != null) { // 로그인한 경우
			// jsp로 forward해서 넘어가기
			RequestDispatcher dis = req.getRequestDispatcher("/view/insert.jsp");
			try{
				dis.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else { // 로그인 안한 경우

			// jsp로 forward해서 넘어가기
			RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
			try{
				dis.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}



	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String price = req.getParameter("price");
		Book c = new Book(isbn,title,author,price);

		req.setAttribute("c",c);
		int result = dao.insert(new Book(isbn,title,author,price));

		// jsp로 forward해서 넘어가기
		RequestDispatcher dis = req.getRequestDispatcher("/view/insertSuccess.jsp");
		try{
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		dao.delete(num);

		try{
			res.sendRedirect("list.cus");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) {
        RequestDispatcher dis=req.getRequestDispatcher("/view/login.jsp");
        try {
            dis.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 사용자가 입력한 id, pass 받아와서 체크하기
		String id = req.getParameter("id");
		
		HttpSession session = req.getSession();
		session.setAttribute("login", id); // 세션에 아이디 저장
	
		try {
			res.sendRedirect("list.book");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        session.setAttribute("login", null); //세션에 아이디 저장
        try {
            res.sendRedirect("list.book");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
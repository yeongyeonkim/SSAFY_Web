package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.dao.IBoard;
import com.vo.Board;

public class BoardController {
	IBoard dao;

	public BoardController() {
		dao = new BoardDAO();// DB 작업하는 객체
	}

	public void list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArrayList<Board> list = dao.selectAll();
		req.setAttribute("list", list);
		// view로 넘어감
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		dis.forward(req, res);
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		dao.countUp(num);
		Board c = dao.selectOne(num);
		req.setAttribute("c", c);

		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num=req.getParameter("num");
		dao.delete(num);
		
		try {
			res.sendRedirect("list.bod");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertForm(HttpServletRequest req, HttpServletResponse res) {

		RequestDispatcher dis = req.getRequestDispatcher("/view/insertForm.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse res)   {
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String content = req.getParameter("content");
		Board c = new Board(null, pass, name, null, title, content, 0);
		dao.insert(c);
		try {
			res.sendRedirect("list.bod");
		} catch (IOException e) {
 			e.printStackTrace();
		}

	}

	public void search(HttpServletRequest req, HttpServletResponse res) {

	}

	public void content(HttpServletRequest req, HttpServletResponse res) {
		String id=req.getParameter("id");
		Board b = dao.selectOne(id);
		req.setAttribute("result", b.getContent());
		
		RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
	}

	public void read2(HttpServletRequest req, HttpServletResponse res) {
		 String num = req.getParameter("num");
		 Board b = dao.selectOne(num);
		 req.setAttribute("b", b);
		 RequestDispatcher dis = req.getRequestDispatcher("/view/read2");
		 try {
			 dis.forward(req, res);
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	}


}

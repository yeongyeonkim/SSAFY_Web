package com.safe.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.safe.dao.IMember;
import com.safe.dao.MemberDAO;
import com.safe.vo.Member;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {

	IMember dao;

	public MemberController() {
		dao = new MemberDAO();
	}

	public void loginView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/view/login.html");
		dis.forward(req, res);
	}

	public void login(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("pw");


		System.out.println(id);
		System.out.println(password);
		Member mem = dao.search(id);

		try {
			String pass = mem.getPassword();
			System.out.println(pass + " " + password);
			if (pass.equals(password)) {

				// 세션등록하기!!
				HttpSession session = req.getSession(true);
				session.setAttribute("s_id", id); // session에 데이터 저장
				session.setAttribute("s_al", mem.getAllergy());
				////////////
				res.sendRedirect("index.food");
			} else {
				res.setCharacterEncoding("utf-8");
				System.out.println("로그인실패");
				res.sendRedirect("loginView.food");
			}
		} catch (Exception e) {
			res.setCharacterEncoding("utf-8");
			System.out.println("로그인실패");
			res.sendRedirect("loginView.food");
		}

	}

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();

		res.sendRedirect("index.food");

	}

	public void register(HttpServletRequest req, HttpServletResponse res) {

		String id = req.getParameter("id");
		System.out.println(id);
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String phone = req.getParameter("phone");
		String[] allergystr = req.getParameterValues("allergy");

		StringBuilder sb = new StringBuilder();

		if (allergystr != null)
			for (String a : allergystr) {
				sb.append(a + ", ");
			}
		String allergy = sb.toString();

		Member mem = new Member(id, pw, name, phone, addr, allergy);
		try {
			dao.add(mem);
			res.sendRedirect("index.food");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void memView(HttpServletRequest req, HttpServletResponse res)
			throws SQLException, ServletException, IOException {
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("s_id");
		Member mem = dao.search(id);
		req.setAttribute("mem", mem);
		RequestDispatcher dis = null;

		String action = req.getParameter("action");
		if (action.equals("info"))
			dis = req.getRequestDispatcher("/view/memInfo.jsp");
		else if (action.equals("edit"))
			dis = req.getRequestDispatcher("/view/memEdit.jsp");

		dis.forward(req, res);
	}

	public void memEdit(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String[] allergystr = req.getParameterValues("allergy");

		StringBuilder sb = new StringBuilder();

		if (allergystr != null)
			for (String a : allergystr) {
				sb.append(a + ", ");
			}
		String allergy = sb.toString();
		Member mem = new Member(id, "", name, phone, address, allergy);
		dao.update(mem);
		req.getSession().setAttribute("s_al", allergy);
		res.sendRedirect("memView.food?action=info");
	}

	public void memDel(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
		HttpSession session = req.getSession(true);
		String id = (String) session.getAttribute("s_id");
		dao.remove(id);
		session.invalidate();

		res.sendRedirect("index.food");
	}

	public void memList(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
		List<Member> list = dao.searchAll();
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("/view/memList.jsp");
		dis.forward(req, res);
		
	}
}

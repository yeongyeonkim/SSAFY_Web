package com.safe.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.safe.dao.ISafeFood;
import com.safe.dao.SafeFoodDAO;
import com.safe.vo.SafeFood;

/**
 * Servlet implementation class SafeFoodController
 */
@WebServlet("/SafeFoodController")
public class SafeFoodController extends HttpServlet {

	ISafeFood dao;

	public SafeFoodController() {
		dao = new SafeFoodDAO();
	}

	
	//////////////
	public void itemList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<SafeFood> list = dao.selectAll();
		req.setAttribute("list", list);

		boolean[] result = new boolean[list.size()];
		HttpSession session = req.getSession();
		if (session.getAttribute("s_al") != null) {
			String[] s_al = ((String) session.getAttribute("s_al")).split(", ");
			System.out.println(Arrays.toString(s_al));
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < s_al.length; j++) {
					if (list.get(i).getMaterial().contains(s_al[j])) {
						System.out.println(list.get(i).getName() + "안에 이게 들어있어서 알레르기! " + s_al[j]);
						result[i] = true;
						break;
					}
				}
			}
			System.out.println(Arrays.toString(result));
			req.setAttribute("result", result);
		}
		RequestDispatcher dis = req.getRequestDispatcher("/view/itemList.jsp");
		dis.forward(req, res);
	}

	public void itemInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int code = Integer.parseInt(req.getParameter("code"));
		SafeFood food = dao.selectOne(code);
		// 알레르기 유발 성분 표시 기능
		String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
				"계란흰자" };
		String al = "";
		for (int i = 0; i < allergys.length; i++) {
			if (food.getMaterial().contains(allergys[i])) {
				if (al == "" || al == null)
					al += allergys[i];
				else
					al += ", " + allergys[i];
			}
		}

		if (req.getSession().getAttribute("s_id") != null) {
			Queue<SafeFood> recent = new LinkedList<SafeFood>();
			if ((LinkedList<SafeFood>) req.getSession().getAttribute("recent") != null) {
				recent = (LinkedList<SafeFood>) req.getSession().getAttribute("recent");
				if (recent.size() == 4) {
					recent.poll();
				}
			}
				recent.add(food);
				req.getSession().setAttribute("recent", recent);
		}
		req.setAttribute("food", food);
		req.setAttribute("al", al);
		RequestDispatcher dis = req.getRequestDispatcher("/view/itemInfo.jsp");
		dis.forward(req, res);
	}

	public void searchItems(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String key1 = req.getParameter("key1");// 정렬 방법
		String key = req.getParameter("key");
		String word = req.getParameter("word");
		List<SafeFood> list = dao.search(key1, key, word);

		req.setAttribute("list", list);

		boolean[] result = new boolean[list.size()];
		HttpSession session = req.getSession();
		if (session.getAttribute("s_al") != null) {
			String[] s_al = ((String) session.getAttribute("s_al")).split(", ");
			System.out.println(Arrays.toString(s_al));
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < s_al.length; j++) {
					if (list.get(i).getMaterial().contains(s_al[j])) {
						System.out.println(list.get(i).getName() + "안에 이게 들어있어서 알레르기! " + s_al[j]);
						result[i] = true;
						break;
					}
				}
			}
			System.out.println(Arrays.toString(result));
			req.setAttribute("result", result);
		}

		RequestDispatcher dis = req.getRequestDispatcher("/view/itemList.jsp");
		dis.forward(req, res);
	}

}

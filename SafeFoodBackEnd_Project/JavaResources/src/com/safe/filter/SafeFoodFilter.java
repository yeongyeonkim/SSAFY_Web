package com.safe.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.safe.controller.MemberController;
import com.safe.controller.SafeFoodController;

@WebFilter(filterName = "/food", urlPatterns = "*.food")
public class SafeFoodFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		req.setCharacterEncoding("utf-8");
		String url = req.getServletPath();
		SafeFoodController sc = new SafeFoodController();
		MemberController mc = new MemberController();

		try {
			if (url.equals("/index.food")) {
				System.out.println("index");
				RequestDispatcher dis = req.getRequestDispatcher("/view/index.jsp");
				dis.forward(req, res);
			} else if(url.equals("/notice.food")) {
				System.out.println("notice");
				
			}
			else if (url.equals("/itemList.food")) {
				System.out.println("list");
				sc.itemList(req, res);
			} else if (url.equals("/itemInfo.food")) {
				System.out.println("info");
				sc.itemInfo(req, res);
			} else if (url.equals("/search.food")) {
				System.out.println("search");
				sc.searchItems(req, res);
			}else if (url.equals("/loginView.food")) {
				System.out.println("loginview");
				mc.loginView(req, res);
			} else if (url.equals("/login.food")) {
				System.out.println("login");
				mc.login(req, res);
			} else if (url.equals("/logout.food")) {
				System.out.println("logout");
				mc.logout(req, res);
			} else if (url.equals("/register.food")) {
				System.out.println("register");
				mc.register(req, res);
			} else if (url.equals("/memView.food")) {
				System.out.println("memView");
				mc.memView(req, res);
			} else if (url.equals("/memList.food")) {
				System.out.println("memList");
				mc.memList(req, res);
			} else if (url.equals("/memEdit.food")) {
				System.out.println("memEdit");
				mc.memEdit(req, res);
			} else if (url.equals("/memDel.food")) {
				System.out.println("memDel");
				mc.memDel(req, res);
			} else if (url.equals("/forgotpwView.food")) {
				System.out.println("memDel");
				mc.memDel(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

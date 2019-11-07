package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;
import com.model.ProductDAO;
import com.model.IProductDAO;
//FrontController에서 넘어온 요청을 받아 처리(Model에게 넘겨서 처리)
//Model이 작업한 결과를 받아서 request에 저장시키고 view(jsp)로 넘어감 (forward)

public class ProductController {
	IProductDAO dao;	//인터페이스안에 있는 메소드만 호출 가능
	
	public ProductController() {
		dao=new ProductDAO();
	}
	public void list(HttpServletRequest req, HttpServletResponse res) {
 		ArrayList<Product> list=dao.selectAll(); //Customer 테이블안의 모든 데이터 검색
 		req.setAttribute("list",list); // jsp에서 꺼내쓰도록 list 저장
 		
 		//jsp로 forward해서 넘어가기
 		RequestDispatcher dis=req.getRequestDispatcher("/view/list.jsp");
 		try {
			dis.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
	}
	
	public void read(HttpServletRequest req, HttpServletResponse res) {
 		String num=req.getParameter("num");
 		Product c= dao.selectOne(num);
 				req.setAttribute("c", c);
 		
 		RequestDispatcher dis=req.getRequestDispatcher("/view/read.jsp");
 		try {
			dis.forward(req, res);
		} catch ( Exception e) {
 			e.printStackTrace();
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num=req.getParameter("num");
		dao.delete(num);

 		 //초기화면으로가기
 		try {
			res.sendRedirect("list.pro");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        
        Product p = new Product(num, name, price);
        dao.insert(p);

		try {
            res.sendRedirect("view/main.jsp");
        } catch ( Exception e) {
            e.printStackTrace();
        }
	}
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String num=req.getParameter("num");
 		Product c= dao.selectOne(num);
 				req.setAttribute("c", c);
 		
 		RequestDispatcher dis=req.getRequestDispatcher("/view/read.jsp");
 		try {
			dis.forward(req, res);
		} catch ( Exception e) {
 			e.printStackTrace();
		}	
	}
  

}

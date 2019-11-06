package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.book.Book;
import com.ssafy.book.BookMgr;
import com.ssafy.book.IBookMgr;

public class BookController {
	IBookMgr mgr;
	
	public BookController() {
		mgr = new BookMgr();
	}
	

}

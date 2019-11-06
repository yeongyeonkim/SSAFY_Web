package com.ssafy.book;

import java.util.ArrayList;

public interface IBookMgr {
	void InsertBook(Book book);
	ArrayList<Book> search();
	ArrayList<Book> searchByTitle(String title);
	ArrayList<Book> searchByPublish(String publisher);
	ArrayList<Book> searchByPrice(int price);
	Book search(String isbn);
	void update(Book b);
	void delete(String isbn);
}

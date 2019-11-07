 package com.model;
// 1. vo(Value Object: customer 테이블 안의 레코드 한 개의 값을 저장하기 위한 객체) 작성
public class Book {
	// field: 테이블 안의 컬럼과 동일하게 추출
	private String isbn;
	private String title;
	private String author;
	private String price;
	
	public Book() {};
	
	public Book(String isbn, String title, String author, String price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", author=").append(author)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	

	
}
package com.ssafy.model.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private String title;
	private String author;
	
	public Book() {}

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
}

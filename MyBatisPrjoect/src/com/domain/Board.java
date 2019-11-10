package com.domain;

public class Board {
	//field 7개
	private String num,pass,name,wdate,title,content;
	private	int count;
	
	//getter,setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
		System.out.println("setNum");
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
		System.out.println("setPass");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setName");
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
		System.out.println("setWdate");
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		System.out.println("setTitle");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		System.out.println("setContent");
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		System.out.println("setCount");
	}
	
	//생성자 2개(default 생성자, parameter 7개짜리 생성자)
	Board(){
		System.out.println("기본생성자");
	}
	public Board(String num, String pass, String name, String wdate, String title, String content, int count) {
		super();
		this.num = num;
		this.pass = pass;
		this.name = name;
		this.wdate = wdate;
		this.title = title;
		this.content = content;
		this.count = count;
	}
	
	//toString
	@Override
	public String toString() {
		return "Board [num=" + num + ", pass=" + pass + ", name=" + name + ", wdate=" + wdate + ", title=" + title
				+ ", content=" + content + ", count=" + count + "]";
	}
	
	
	
}

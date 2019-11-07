package com.model;

//vo (value object : customer 테이블 안의 레코드 한개의 값을 저장하기 위한 객체)
public class Product {
	
	//field 테이블안의 컬럼과 동일하게 추출
	private String num;
	private String name;
	private String price;
	
	//constructor
	public Product() {
	}
	
	public Product(String num, String name, String price) {
		this.num = num;
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "num=" + num + ", name=" + name + ", price=" + price;
	}

	//getter setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

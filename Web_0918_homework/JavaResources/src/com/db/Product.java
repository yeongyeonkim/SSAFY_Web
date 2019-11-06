package com.db;

public class Product {
	int pid;
	String pname, price, description;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product(int pid, String pname, String price, String description) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.description = description;
	}
}

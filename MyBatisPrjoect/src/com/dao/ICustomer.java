package com.dao;

import java.util.List;

import com.domain.Customer;

//client를 위한 서비스 메소드를 가지고 있는 인터페이스
public interface ICustomer {
	List<Customer> selectAll();
	Customer selectOne(String num);
	int insert(Customer c);
	int delete(String num);
	int update(String num, String address);
	List<Customer> findByAddress(String address);
}

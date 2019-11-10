package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MyBatisUtil;
import com.domain.Customer;
//mybatis를 이용해서 CRUD 작업하는 객체
public class CustomerDAO implements ICustomer{

//	public void hello() {
//		System.out.println("hello");
//	}
	@Override
	public List<Customer> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Customer.selectAll");//selectAll이라는 id를 가진 쿼리 실행 후 결과 리턴
	}
	
	@Override
	public Customer selectOne(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("Customer.selectOne", num);
	}

	@Override
	public int insert(Customer c) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int flag = session.insert("Customer.insert", c);
		session.commit();
		return flag;
	}

	@Override
	public int delete(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int flag = session.delete("Customer.delete", num);
		session.commit();
		return flag;
	}

	@Override
	public int update(String num, String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("num", num);
		map.put("address", address);
		int flag = session.update("Customer.update", map);
		//Customer c = new Customer(num, null, address);
		//int flag = session.update("Csutomer.update", c); 처럼 할 수 있다.
		session.commit();
		return flag;
	}
//	public List<Customer> searchAll(String condition, String word){
//		SqlSession session = MyBatisUtil.getSqlSession();
//		HashMap<String, String> map = new HashMap<>();
//		map.put("key", condition); //검색 기준
//		map.put("word", word); //검색어
//		return session.selectList("searchAll", map);
//	}

	@Override
	public List<Customer> findByAddress(String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Customer.findByAddress", address);
	}
	
}

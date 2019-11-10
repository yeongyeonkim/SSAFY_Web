package com.app;

import java.util.List;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;

//client program
public class CustomerTest {

    public static void main(String[] args) {
    	//dao 객체 생성 후에 메소드 호출
    	ICustomer dao = new CustomerDAO();
    	List<Customer> list = dao.selectAll();
    	
    	for(Customer c : list) {
    		System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
    	}
//    	dao.hello 출력이 불가능 interface라서 CustomerDAO안의 hello 메소드에 직접 접근 불가
    	System.out.println("<------------------- Select One -------------------->");
    	Customer tmp = dao.selectOne("20");
    	System.out.println(tmp.getNum() + " : " + tmp.getName() + " : " + tmp.getAddress());
    	
    	System.out.println("<------------------- delete -------------------->");
    	dao.delete("20"); //삭제
    	list = dao.selectAll();
    	for(Customer c : list) {
    		System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
    	}
    	
    	System.out.println("<------------------- insert -------------------->");
    	dao.insert(new Customer("20", "harry", "la"));
    	list = dao.selectAll();
    	for(Customer c : list) {
    		System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
    	}
    	
    	System.out.println("<------------------- update -------------------->");
    	dao.update("20", "seoul");
    	list = dao.selectAll();
    	for(Customer c : list) {
    		System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
    	}
    	
    	System.out.println("<------------------- findByAddress -------------------->");
    	List<Customer> add_list = dao.findByAddress("seoul");
    	for(Customer c : add_list) {
    		System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
    	}
    }
}

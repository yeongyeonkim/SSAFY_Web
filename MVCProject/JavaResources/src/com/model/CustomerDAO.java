package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 3. dao(data access object) 작성 -> CRUD(Create Read Update Delete)
//								   => DB에 접근해서 CRUD 작업 수행
public class CustomerDAO implements ICustomerDAO{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	
	// 생성자
	public CustomerDAO() { // client에 의해 호출됨
		try {
			Class.forName(driver); //1. Driver 등록 (로딩) : 사용할 db driver 등록
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password); //2. Connection 생성 (Network 연결)
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		String query = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();
		
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 2
			stat = con.createStatement(); // 3
			rs = stat.executeQuery(query); // 4
			
			while(rs.next()) { // 5
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				
				Customer c = new Customer(num, name, address); // vo로 포장
				list.add(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close(rs, stat, null, con);
		
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		String query = "select * from customer where num = ?";
		Customer c = null;
		
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			pstat.setString(1, num);
			rs = pstat.executeQuery(); // 4
			
			if(rs.next()) {
				String cnum = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				c = new Customer(cnum, name, address); // vo로 포장
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close(rs, null, pstat, con);
		
		return c;
	}

	@Override
	public int insert(Customer c) {
		String query =  "insert into customer values(?,?,?)";
		
		Connection con = null;
		PreparedStatement pstat = null;
		int i = 0;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1, c.getNum());
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getAddress());
			
			i = pstat.executeUpdate();
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("중복된 값이 있습니다");
		}
		
		close(null, null, pstat, con);
		
		return i;
	}

	@Override
	public int delete(String num) {
		String query =  "delete from customer where num = ?";
		
		Connection con = null;
		PreparedStatement pstat = null;
		int i = 0;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1, num);
			
			i = pstat.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close(null, null, pstat, con);
		
		return i;
	}

	@Override
	public int update(String num, String address) {
		String query =  "update customer set address = ? where num = ?";
		
		Connection con = null;
		PreparedStatement pstat = null;
		int i = 0;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1, address);
			pstat.setString(2, num);
			
			i = pstat.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close(null, null, pstat, con);
		
		return i;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		String query = "select * from customer where address = ? order by num";
		ArrayList<Customer> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			pstat.setString(1, address);
			rs = pstat.executeQuery(); // 4
			
			while(rs.next()) { // 5
				String num = rs.getString(1);
				String name = rs.getString(2);
				String caddress = rs.getString(3);
				
				Customer c = new Customer(num, name, caddress); // vo로 포장
				list.add(c);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		close(rs, null, pstat, con);
		
		return list;
	}
	
	public void close(ResultSet rs, Statement stat, PreparedStatement pstat, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stat != null) stat.close();
			if(pstat != null) pstat.close();
			if(con != null) con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

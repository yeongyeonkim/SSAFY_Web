package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.Customer;

public class CustomerDAO implements ICustomer {
	// FIELD
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";

	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		String q = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();

		try {
			Connection con = getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				Customer c = new Customer(num, name, address);
				list.add(c);
			}

			close(stat, rs, con, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		String q = "select * from customer where num = ?";
		Customer c = null;
		try {
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			ResultSet rs = pstat.executeQuery();
			
			if(rs.next()) {
				String cnum = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				c = new Customer(cnum, name, address);
			}			
			close(null, rs, con, pstat);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		String q = "select * from customer where address = '" + address + "'";
		ArrayList<Customer> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String caddress = rs.getString(3);
				
				list.add(new Customer(num, name, caddress));
			}
			close(stat, rs, con, null);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(Customer c) {
		String q = "insert into customer values(?,?,?)";
		int i=0;
		try {
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, c.getNum());
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getAddress());
			
			i = pstat.executeUpdate();
			
			close(null, null, con, pstat);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int update(String num, String address) {
		String q = "update customer set address = ? where num = ?";
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, address);
			pstat.setString(2, num);
			i = pstat.executeUpdate();
			
			close(null, null, con, pstat);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delete(String num) {
		String q = "delete from customer where num = ?";
		int i = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			i=pstat.executeUpdate();
			
			close(null, null, con, pstat);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat) {
		try {
			if (stat != null)
				stat.close();			
			if (pstat != null)
				pstat.close();
			
			if (rs != null)
				rs.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



}

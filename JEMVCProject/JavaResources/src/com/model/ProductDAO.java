package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO implements IProductDAO {
	
	public String dirver = "com.mysql.cj.jdbc.Driver"; 
	public String url = "jdbc:mysql://localhost:3306/tommy?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public String user = "tommy";
	public String password = "lion";
	
	public ProductDAO() {
		try {
			Class.forName(dirver);
			
		}catch(Exception e) {
		
		}
		
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user, password);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Product> selectAll() {
		String query = "select * from product order by num";
		ArrayList<Product> c = new ArrayList<>();
		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeQuery(query);//4
			
			while(rs.next()) {//5
				String num = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				
				c.add(new Product(num, name, price));
			}
			close(rs,stat,null,con);
			return c;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(rs,stat,null,con);
		return c;
	}

	@Override
	public Product selectOne(String num) {
		String query = "select * from product where num = "+num;
		Product c=null;
		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeQuery(query);//4
			
			while(rs.next()) {//5
				String n = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				
				c = new Product(n, name, price);
			}
			close(rs,stat,null,con);
			return c;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(rs,stat,null,con);
		return c;
	}

	@Override
	public int insert(Product c) {
		String query = "insert into product values(?,?,?)";
		Connection con=null;
		PreparedStatement pstat=null;
		int rs=-1;
		try {
			con = getConnection();//2
			pstat = con.prepareStatement(query);//3
			
			pstat.setString(1, c.getNum());
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getPrice());
			
			rs = pstat.executeUpdate();//4
			
			close(null,null,pstat,con);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		close(null,null,pstat,con);
		
		return rs;
	}

	@Override
	public int delete(String num) {
		String query = "delete from product where num = "+num;
		Connection con=null;
		Statement stat=null;
		int rs=-1;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeUpdate(query);//4
			
			close(null,stat,null,con);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(null,stat,null,con);
		return rs;
	}

	@Override
	public int update(String num, String price) {
		String query = "update product set price = '"+price+"' where num = "+num;
		Connection con=null;
		Statement stat=null;
		int rs=-1;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeUpdate(query);//4
			
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(null,stat,null,con);
		return rs;
	}


	
	public void close(ResultSet rs, Statement stat, PreparedStatement pstat, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(stat!=null)stat.close();
			if(pstat!=null)pstat.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

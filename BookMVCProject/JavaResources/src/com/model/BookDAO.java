package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 3. dao(Data Access Object: Create(=insert) Read(=select) Update Delete)
// DAO: DB에 접근해서 CRUD 작업을 수행하는 객체
public class BookDAO implements IBookDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tommy?serverTimezone=UTC&useUnicode=yes&characterEncoing=UTF-8";
	String user = "tommy";
	String password = "lion";
	
	// constructor //
	public BookDAO() { // client에 의해 호출됨
		try {
			Class.forName(driver); // 1
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	// END: constructor //
	
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
	public ArrayList<Book> selectAll() {
		String query = "select * from books order by isbn";
		ArrayList<Book> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 2
			stat = con.createStatement(); // 3
			rs = stat.executeQuery(query); // 4
			
			while(rs.next()) { // 5
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String price = rs.getString(4);
				
				Book c = new Book(isbn,title,author,price); // VO로 포장
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(rs, stat, null, con);
		return list;
	}

	@Override
	public Book selectOne(String isbn) {
		String query = "select * from books where isbn=?";
		Book c = new Book();
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			pstat.setString(1,  isbn);
			rs = pstat.executeQuery(); // 4
			
			rs.next();
			String isbnn = rs.getString(1);
			String title = rs.getString(2);
			String author = rs.getString(3);
			String price = rs.getString(4);
			
			c = new Book(isbnn,title,author,price); // VO로 포장
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(rs, null, pstat, con);
		return c;
	}

	@Override
	public int insert(Book c) {
		String query = "insert into books values(?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstat = null;
		int res = 0;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1,  c.getIsbn());
			pstat.setString(2,  c.getTitle());
			pstat.setString(3,  c.getAuthor());
			pstat.setString(4,  c.getPrice());
			pstat.setString(5, null);
			res = pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(null, pstat, null, con);
		return res;
	}

	@Override
	public int delete(String isbn) {
		String query = "delete from books where isbn=?";
		Connection con = null;
		PreparedStatement pstat = null;
		int res = 0;
		
		try {
			con = getConnection(); // 2
			pstat = con.prepareStatement(query); // 3
			
			pstat.setString(1, isbn);
			res = pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(null, pstat, null, con);
		return res;
	}



	
	public void close(ResultSet rs, Statement stat, PreparedStatement pstat, Connection con) {
		try {
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(pstat!=null) pstat.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
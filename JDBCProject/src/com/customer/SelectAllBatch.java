package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllBatch {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		String query = "select num, name, address from customer order by num";
		Connection con = null;
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
			Statement stat = con.createStatement();

			//3-1. batch에 query 추가
			stat.addBatch("insert into customer values(23, 'harry', 'la')");
			stat.addBatch("insert into customer values(24, 'jerry', 'la')");
			stat.addBatch("insert into customer values(22, 'marry', 'la')");
			
			con.setAutoCommit(false);
			int[] a = stat.executeBatch();
			con.commit();
			
			System.out.println("commit all...");
			
			//6. 마무리
			stat.close();
			con.close();
			
		}catch(Exception e) {
			try {
				con.rollback();
				System.out.println("rollback all...");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}

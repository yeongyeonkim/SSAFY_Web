package com.jdbc;

import java.sql.*;

public class JdbcExecute {

	public static void main(String args[]) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		
		String str1 = "select * from customer";
		String str2 = "insert into customer values(987,'hee','la')";

		Connection conn;
		Statement stat;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection (url, user, password);
			
			stat = conn.createStatement();

			boolean flag = stat.execute(str1); 
//			boolean flag = stat.execute(str2); 

			if(flag == true){ //select인 경우
				ResultSet rs = stat.getResultSet();

				while(rs.next()) {
					String num  = rs.getString(1);
					String name  = rs.getString(2);
					String address   = rs.getString(3);
					System.out.println(num + "-- " +name + "-- " + address );
				}
			}			
			else{//select가 아닌경우
				int rows = stat.getUpdateCount();
				if (rows != 0)
					System.out.println("operation ok....!!!");
				else 
					System.out.println("no changes made...!!!");
			}
			stat.close();
			conn.close();
		} catch ( Exception e ) {
			System.out.println(" error sql");
			e.printStackTrace();
		}
	}
}
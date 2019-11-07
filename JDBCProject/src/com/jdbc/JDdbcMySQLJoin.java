package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDdbcMySQLJoin {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		//jdbc url
		//jdbc:protocol 이름 / mysql:db / localhost:db server 주소 / 3306:port / scott:schema 이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding-UTF-8";
		String user = "scott";
		String password = "tiger";
		
		//empid, fname, deptname, city
		String query = "select e.empid, e.fname, d.deptname, l.city "
					 + "from emp e left join dept d on e.deptid = d.deptid "
					 			+ "left join loc l on d.locid = l.locid";
		
		try {
			//1. Driver 등록 : 사용할 db driver 등록
			Class.forName(driver);
			
			//2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3. Statement 생성(Query 한개를 담는 그릇)
			Statement stat = con.createStatement();
			
			//4. Query 실행
			ResultSet rs = stat.executeQuery(query);//select
			
			//5. 결과처리
			while(rs.next()) { // re.next() == boolean 가리킨 레코드에 데이터가 있는지.
				String empid = rs.getString(1);
				String fname = rs.getString(2);
				String deptname = rs.getString(3);
				String city = rs.getString(4);
				
				System.out.println(empid + "--" + fname + "--" + deptname + "--" + city);
			}
			
			//6. 마무리
			rs.close();
			stat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

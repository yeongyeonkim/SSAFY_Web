package com.db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/JdbcServlet")
public class JdbcServlet extends HttpServlet {
    String driver = "com.mysql.cj.jdbc.Driver";
    // jdbc url
    // jdbc는 protocol 이름, 의사소통할때 사용하는 도구, mysql은 db, localhost : db서버 주소, 3306 포트,
    // scott : 스키마이름
    String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
    String user = "scott";
    String password = "tiger";
    String Query = "select empid, fname from emp order by empid";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(111);
        
        
        try {
            // 1. Driver 등록(로딩) -> 사용할 DB 등록
            Class.forName(driver); // Class.forName(args[0]) 이런식으로 다른 종류의 객체를 가져오는게 편리하다. new Car() 이런식으로 하면 가져오는게
                                    // 불편함
            // 2. Connection 생성(Network 연결)
            Connection con = DriverManager.getConnection(url, user, password);
            // 3. Statement 생성([Q:쿼리] 한개를 담을 수 있는 그릇
            Statement stat = con.createStatement();
            // 4. 쿼리 실행
            ResultSet rs = stat.executeQuery(Query);
            out.println("<h1>Employee Data</h1>");
            out.println("<table border=1>");
            
            // 5. 결과처리
            while (rs.next()) {
                String empid = rs.getString(1);
                String fname = rs.getString(2);
                out.println("<tr><td>"+empid+"</td><td><a href=Detail?empid="+empid+">"+fname+"</a></td></tr>");
            }
            out.println("</table>");
            // 6.마무리
            rs.close();
            stat.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
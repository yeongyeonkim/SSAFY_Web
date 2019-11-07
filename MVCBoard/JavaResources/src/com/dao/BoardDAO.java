package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vo.Board;

public class BoardDAO implements IBoard {
	
	public String dirver = "com.mysql.cj.jdbc.Driver"; 
	public String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public String user = "scott";
	public String password = "tiger";
	
	public BoardDAO() {
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
	public ArrayList<Board> selectAll() {
		String query = "select num,name,title,wdate,count from board order by num desc";
		ArrayList<Board> list = new ArrayList<>();
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
				String title = rs.getString(3);
				String wdate = rs.getString(4);
				int count = rs.getInt(5);
				Board c = new Board(num, null,name,wdate, title,null,count); 
				list.add(c);
			}
			close(rs,stat,null,con);
 		}catch(Exception e) {
			e.printStackTrace();
		}
		close(rs,stat,null,con);
		return list;
 	}

	@Override
	public Board selectOne(String num) {
		String query = "select num,name,title,wdate,content,count from board where num = "+num;
		Board c=null;
		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeQuery(query);//4
			
			while(rs.next()) {//5
				String bnum = rs.getString(1);
				String name = rs.getString(2);
				String title = rs.getString(3);
				String wdate = rs.getString(4);
				int count = rs.getInt(6);
				String content = rs.getString(5);
				
				c = new Board(bnum, null,name,wdate, title,content,count); 
			}
			close(rs,stat,null,con);
			return c;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(rs,stat,null,con);
		return c;
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

 
	@Override
	public void insert(Board b) {
		String query = "insert into board(title,name,pass,content,wdate) values(?,?,?,?,SYSDATE())";
		Connection con=null;
		PreparedStatement pstat=null;
		int rs=-1;
		try {
			con = getConnection();//2
			pstat = con.prepareStatement(query);//3
			
			pstat.setString(1, b.getTitle());
			pstat.setString(2, b.getName());
			pstat.setString(3, b.getPass());
			pstat.setString(4, b.getContent());
			
			rs = pstat.executeUpdate();//4
			
			close(null,null,pstat,con);
 		}catch(Exception e) {
			e.printStackTrace();
		}
		
		close(null,null,pstat,con);
		
 	}

	@Override
	public void delete(String num) {
		String query = "delete from board where num = "+num;
		Connection con=null;
		Statement stat=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			stat.executeUpdate(query);//4
			
			close(null,stat,null,con);
 		}catch(Exception e) {
			e.printStackTrace();
		}
		close(null,stat,null,con);
 	}

	@Override
	public ArrayList<Board> search(String condition, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countUp(String num) {
		String query = "update board set count = count + 1 where num = ?";
		
		Connection con=null;
		PreparedStatement pstat=null;
		try {
			con = getConnection();//2
			pstat = con.prepareStatement(query);//3
			pstat.setString(1, num);
			pstat.executeUpdate();
			
 		}catch(Exception e) {
			e.printStackTrace();
		}
		close(null,null,pstat,con);
	}
/*
	@Override
	public String content(String id) {
		String query="select content from board where num="+id;
		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			stat.executeUpdate(query);//4
			
			close(null,stat,null,con);
 		}catch(Exception e) {
			e.printStackTrace();
		}
		close(null,stat,null,con);

		Connection con=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			con = getConnection();//2
			stat = con.createStatement();//3
			rs = stat.executeQuery(query);//4
			
			while(rs.next()) {//5
		
				String content = rs.getString(1);
				
				c = new Board(bnum, null,name,wdate, title,content,count); 
			}
			close(rs,stat,null,con);
			return c;
		}catch(Exception e) {
			e.printStackTrace();
		}
		close(rs,stat,null,con);
		return c;	
	}
	*/
}

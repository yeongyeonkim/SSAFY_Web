package com.safe.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.safe.config.MyBatisUtil;
import com.safe.vo.Member;

public class MemberDAO implements IMember {

	
	public Member search(String id) throws SQLException {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("Member.search", id);
	}

	public List<Member> searchAll() throws SQLException {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<Member> list = session.selectList("Member.selectAll");// selectAll 이라는 id 를 가진 쿼리 실행 후 결과 리턴
		return list;
	}
	public void add(Member member) throws SQLException {
		SqlSession session = MyBatisUtil.getSqlSession();
		session.insert("Member.add", member);
		session.commit();
	}
	public void update(Member member) throws SQLException {
		SqlSession session = MyBatisUtil.getSqlSession();
		session.insert("Member.update", member);
		session.commit();
	}
	public void remove(String id) throws SQLException {
		SqlSession session = MyBatisUtil.getSqlSession();
		session.insert("Member.remove", id);
		session.commit();
	}
}
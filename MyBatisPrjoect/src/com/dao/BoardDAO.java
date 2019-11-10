package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MyBatisUtil;
import com.domain.Board;

//mybatis를 이용해서 CRUD 작업하는 객체
public class BoardDAO implements IBoard{

	@Override
	public List<Board> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Board.selectAll");//selectAll이라는 id를 가진 쿼리 실행 후 결과 리턴
	}
	
	@Override
	public Board selectOne(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("Board.selectOne", num);
	}

	@Override
	public int insert(Board b) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int flag = session.insert("Board.insert", b);
		session.commit();
		return flag;
	}

	@Override
	public int delete(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int flag = session.delete("Board.delete", num);
		session.commit();
		return flag;
	}

	@Override
	public List<Board> search(String title) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Board.search", title);
	}
	
}

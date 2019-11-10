package com.dao;

import java.util.List;

import com.domain.Board;

public interface IBoard {
	List<Board> selectAll();
	Board selectOne(String num);
	int insert(Board b);//새글등록
	int delete(String num);//글삭제
	List<Board> search(String title);//검색
}

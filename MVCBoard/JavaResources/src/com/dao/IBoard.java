package com.dao;

import java.util.ArrayList;

import com.vo.Board;

public interface IBoard {
	public ArrayList<Board> selectAll();//목록화면에서 모든 글 검색 /// 선택하느거(이름, 제목...(like로 하기)), 검색창 , ok 버튼
	public Board selectOne(String num);//글읽기화면에서 해당글 검색
	public void insert(Board b);//새글등록
	public void delete(String num);//글삭제
	public ArrayList<Board> search(String condition, String word);//검색
	public void countUp(String num);//조회수 증가
	//public void content(String id);
}

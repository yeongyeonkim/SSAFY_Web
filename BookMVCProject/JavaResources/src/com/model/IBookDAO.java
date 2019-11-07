package com.model;

import java.util.ArrayList;

// 2. interface 작성(dao가 구현해야 하는 메소드 목록). dao: 직접 DB 작성함
public interface IBookDAO {
	ArrayList<Book> selectAll(); // 테이블 안의 모든 레코드 검색
	Book selectOne(String isbn); // num 기준으로 레코드 검색
	int insert(Book b); // 새 레코드 추가
	int delete(String isbn); // num 기준으로 레코드 삭제
}
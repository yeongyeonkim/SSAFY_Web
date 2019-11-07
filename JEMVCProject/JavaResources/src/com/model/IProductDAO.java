package com.model;

import java.util.ArrayList;

//dao가 구현해야하는 메소드 목록
public interface IProductDAO {
	ArrayList<Product> selectAll();//테이블 안의 모든 레코드 검색
	Product selectOne(String num);//num기준으로 레코드 검색
	int insert(Product c);//새 레코드 추가
	int delete(String num);	//num기준으로 레코드 삭제
	int update(String num,String price);//num기준으로 주소수정
}


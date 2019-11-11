package com.safe.dao;

import java.util.List;

import com.safe.vo.SafeFood;


public interface ISafeFood {
	
	public List<SafeFood> selectAll();
	public SafeFood selectOne(int code);
	public List<SafeFood> search(String key1,String key, String word);
}

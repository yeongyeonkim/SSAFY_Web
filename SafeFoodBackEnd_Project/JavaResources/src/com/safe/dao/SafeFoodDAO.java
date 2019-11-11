package com.safe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.safe.config.MyBatisUtil;
import com.safe.vo.SafeFood;

public class SafeFoodDAO implements ISafeFood {

	@Override
	public List<SafeFood> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("SafeFood.selectAll");
	}

	public SafeFood selectOne(int code) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("SafeFood.selectOne", code);
	}
	
	public List<SafeFood> search(String key1, String key, String word) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<SafeFood> list = null;
		if (!key.equals("all") && word != null && !word.trim().equals("")) {
			word = "%" + word + "%";
			if (key.equals("name")) {
				list = session.selectList("SafeFood.selectName", word);
			} else if (key.equals("maker")) {
				list = session.selectList("SafeFood.selectMaker", word);
			} else if (key.equals("material")) {
				list = session.selectList("SafeFood.selectMaterial", word);
			} 
		} else
			list = session.selectList("SafeFood.selectAll");
		
		return list;
	}

}
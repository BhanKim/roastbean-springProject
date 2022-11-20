package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BoardcommentDto;

public class BoardcommentDaoImpl implements BoardcommentDao {
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.BoardcommentDao";
	

	@Override
	public List<BoardcommentDto> cList(int community_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(sqlSession.selectList(nameSpace + ".cList"));
		return sqlSession.selectList(nameSpace + ".cList");
	}

}

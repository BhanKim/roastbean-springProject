package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BoardDto;

public class BoardDaoImpl implements BoardDao {
	
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.BoardDao";

	// all select list
	@Override
	public List<BoardDto> boardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".boardList");
	}
	
	// content view 
	@Override
	public BoardDto contentView(int community_id) throws Exception {
		// TODO Auto-generated method stub
		return (BoardDto) sqlSession.selectList(nameSpace + ".contentView");
	}

}

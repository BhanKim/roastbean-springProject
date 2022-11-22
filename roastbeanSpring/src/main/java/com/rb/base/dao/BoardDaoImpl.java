package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BoardDto;

public class BoardDaoImpl implements BoardDao {
	
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.BoardDao";
	
	@Override
	public int boardlistrow()throws Exception{
		return sqlSession.selectOne(nameSpace + ".boardlistrow");
	}

	// all select list
	@Override
	public List<BoardDto> boardList(int cPage, int start, int rowCount) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".boardList");
	}
	
	// content view 
	@Override
	public BoardDto contentView(int community_id) throws Exception {
		// TODO Auto-generated method stub
		return (BoardDto) sqlSession.selectList(nameSpace + ".contentView");
	}

	@Override
	public void boardwrite(String community_name, String community_title, String community_content) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".boardwrite");
	}

	@Override
	public void communitydelete(int community_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".communitydelete");
	}

	@Override
	public BoardDto modify_view(int community_id) throws Exception {
		// TODO Auto-generated method stub
		return (BoardDto) sqlSession.selectList(nameSpace+ ".modify_view");
	}

	@Override
	public void modify(String community_title, String community_content, int community_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".modify"); 
		
	}

	@Override
	public void upHit(int community_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".upHit");
	}

	@Override
	public void like(int community_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".like");
	}


}

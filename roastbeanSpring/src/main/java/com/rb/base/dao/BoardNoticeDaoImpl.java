package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.BoardDto;

public class BoardNoticeDaoImpl implements BoardNoticeDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.BoardNoticeDao";
	
	@Override
	public List<BoardDto> BoardNoticeList() throws Exception {
		
		return sqlSession.selectList(nameSpace+".cboardnotice.do");
	}

}

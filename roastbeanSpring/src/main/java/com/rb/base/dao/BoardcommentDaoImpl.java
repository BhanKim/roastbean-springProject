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


	@Override
	public void coWrite(String community_id, String community_comment_name, String community_comment_content)
			throws Exception {
		sqlSession.insert(nameSpace+".coWrite");
	}


	@Override
	public void coModify(String community_comment_content, String community_comment_cono) throws Exception {
		sqlSession.update(nameSpace+".coModify");
		
	}


	@Override
	public void coDelete(String community_comment_cono) throws Exception {
		sqlSession.delete(nameSpace+".coDelete");
		
	}

}

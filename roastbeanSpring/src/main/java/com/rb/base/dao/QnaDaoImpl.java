package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.rb.base.model.QnaDto;

public class QnaDaoImpl implements QnaDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.QnaDao";
	
	@Override
	public List<QnaDto> qnaList(String user_id) throws Exception {
		return sqlSession.selectList(nameSpace + ".qnaList");
	}

	@Override
	public void userQuestionInsert(String user_id, String qna_write_category, String qna_write_title,
			String qna_write_content) throws Exception {
		sqlSession.insert(nameSpace + ".userQuestionUpdate");
		
	}

	@Override
	public void userQuestionUpdate(String qna_write_seq, String qna_write_title, String qna_write_content)
			throws Exception {
		sqlSession.update(nameSpace + ".userQuestionUpdate");
	}

	@Override
	public List<QnaDto> qnaListAdmin() throws Exception {
		return sqlSession.selectList(nameSpace + ".qnaListAdmin");
	}

	@Override
	public void adminAnswerInsert(String admin_id, String qna_write_seq, String qna_write_comment_content)
			throws Exception {
		sqlSession.insert(nameSpace + ".adminAnswerInsert");
	}

	@Override
	public void adminAnswerUpdate(String qna_write_seq, String qna_write_comment_content) throws Exception {
		sqlSession.update(nameSpace + ".adminAnswerUpdate");
	}

}

package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.QnaDto;

public interface QnaDao {

	public List<QnaDto> qnaList(String user_id) throws Exception;

	public void userQuestionInsert(String user_id, String qna_write_category, String qna_write_title, String qna_write_content) throws Exception;
	
	public void userQuestionUpdate(String qna_write_seq, String qna_write_title, String qna_write_content) throws Exception;
	
	//////////////////////
	
	public int qnaListAdminRow(String query, String content) throws Exception;

	public List<QnaDto> qnaListAdmin(int cPage, int start, int rowCount, String query, String content) throws Exception;
	
	//////////////////////

	public void adminAnswerInsert(String admin_id, String qna_write_seq, String qna_write_comment_content) throws Exception;
	
	public void adminAnswerUpdate(String qna_write_seq, String qna_write_comment_content) throws Exception;
	
}

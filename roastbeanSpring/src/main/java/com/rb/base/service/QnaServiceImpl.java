package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.QnaDao;
import com.rb.base.model.QnaDto;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDao dao;
	
	@Override
	public List<QnaDto> qnaList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		return dao.qnaList(user_id);
	}

	@Override
	public void userQuestionInsert(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		String user_id = (String) session.getAttribute("ID");
		String qna_write_category = request.getParameter("qna_write_category");
		String qna_write_title = request.getParameter("qna_write_title");
		String qna_write_content = request.getParameter("qna_write_content");

		dao.userQuestionInsert(user_id, qna_write_category, qna_write_title, qna_write_content);
	}
	
	@Override
	public void userQuestionUpdate(HttpServletRequest request) throws Exception {
		String qna_write_seq = request.getParameter("qna_write_seq");
		String qna_write_title = request.getParameter("qna_write_title");
		String qna_write_content = request.getParameter("qna_write_content");
		
		dao.userQuestionUpdate(qna_write_seq, qna_write_title, qna_write_content);
	}

	@Override
	public List<QnaDto> qnaListAdmin(HttpServletRequest request) throws Exception {
		return dao.qnaListAdmin();
	}

	@Override
	public void adminAnswerInsert(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		String admin_id = (String) session.getAttribute("ADMIN");
		String submit_type = request.getParameter("submit_type");
		String qna_write_seq = request.getParameter("qna_write_seq");
		String qna_write_comment_content = request.getParameter("qna_write_comment_content");
		
		if(submit_type.equals("insert")) {
			dao.adminAnswerInsert(admin_id, qna_write_seq, qna_write_comment_content);
		}else {
			dao.adminAnswerUpdate(qna_write_seq, qna_write_comment_content);
		}
	}

}

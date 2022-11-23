package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.QnaDao;
import com.rb.base.model.PageInfo;
import com.rb.base.model.QnaDto;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	QnaDao dao;
	
	@Override
	public void qnaList(HttpServletRequest request, Model model) throws Exception {

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		List<QnaDto> dtos =  dao.qnaList(user_id);
		model.addAttribute("myQnaList", dtos);
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
	public void qnaListAdmin(HttpServletRequest request, Model model) throws Exception {
		
		///////
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		
		if(query == null || query.length() == 0) {
			query = "qna_write_seq";
		}else if(query.equals("qna_write_seq") || query.equals("noncomment")) {
			content = "";
		}
		if(content == null || content.length() == 0) {
			content = "";
		}
		content = '%' + content + '%';
		
		////////
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수
		int totalCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		
		if(tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}

		///////
		totalCount = dao.qnaListAdminRow(query, content);
		PageInfo dto = new PageInfo(cPage, totalCount, listCount, pageLength);
		
		rowCount = (totalCount -((cPage-1)*10));
		int start = rowCount - 9;
		
		///////
		List<QnaDto> dtos = dao.qnaListAdmin(cPage, start, rowCount, query, content);
		model.addAttribute("page", dto);
		model.addAttribute("adminQnaList", dtos);
		request.setAttribute("query", query);
		request.setAttribute("content", content.replace("%", ""));
		
	}
	
	@Override
	public void adminAnswerInsert(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		String page = request.getParameter("page");
		String query = request.getParameter("query");
		String content = request.getParameter("content");
		
		System.out.println(query);
		System.out.println(content);
		
		request.setAttribute("page", page);
		request.setAttribute("query", query);
		request.setAttribute("content", content);

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

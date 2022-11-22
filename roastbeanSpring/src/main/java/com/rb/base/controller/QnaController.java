package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.QnaDto;
import com.rb.base.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	QnaService service;
	
	// 마이페이지/MyQnaList 가져오기 / 완료 22-11-22 SangwonKim
	@RequestMapping("/mypage_qna_list_")
	public String mypage_qna_list_(HttpServletRequest request, Model model) throws Exception {
		List<QnaDto> dtos = service.qnaList(request);
		model.addAttribute("myQnaList", dtos);
		return "mypage_qna_list";
	}
	
	@RequestMapping("/cs_qna")
	public String cs_qna() throws Exception{
		return "cs_qna";
	}
	
	// Cs/QnA/유저:질문하기 Insert / 완료 22-11-22 SangwonKim
	@RequestMapping("/qna_question_by_user")
	public String qna_question_by_user(HttpServletRequest request) throws Exception{
		service.userQuestionInsert(request);
		return "cs_qna";
	}

	// 마이페이지/MyQnA 수정 / 완료 22-11-22 SangwonKim
	@RequestMapping("/qna_update_by_user")
	public String qna_update_by_user(HttpServletRequest request) throws Exception {
		service.userQuestionUpdate(request);
		return "redirect:mypage_qna_list_";
	}
	
	// Cs/QnA/관리자:전체리스트 불러오기 Select / 완료 22-11-22 SangwonKim
	@RequestMapping("/qna_list_by_admin")
	public String qna_list_by_admin(HttpServletRequest request, Model model) throws Exception{
		List<QnaDto> dtos = service.qnaListAdmin(request);
		model.addAttribute("adminQnaList", dtos);
		return "cs_qna_admin";
	}
	
	// Cs/QnA/관리자:질문에 답변하기,수정하기 Insert&Update / 완료 22-11-22 SangwonKim
	@RequestMapping("/qna_answer_by_admin")
	public String qna_answer_by_admin(HttpServletRequest request) throws Exception {
		service.adminAnswerInsert(request);
		return "redirect:qna_list_by_admin";
	}
	
	@RequestMapping("/cs_faq")
	public String cs_faq() throws Exception{
		return "cs_faq";
	}

}

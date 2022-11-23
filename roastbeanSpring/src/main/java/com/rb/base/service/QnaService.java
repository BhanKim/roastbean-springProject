package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface QnaService {

	public void qnaList(HttpServletRequest request, Model model) throws Exception;
	
	public void userQuestionInsert(HttpServletRequest request) throws Exception;

	public void userQuestionUpdate(HttpServletRequest request) throws Exception;

	//////////////////////
	
	public void qnaListAdmin(HttpServletRequest request, Model model) throws Exception;
	
	public void adminAnswerInsert(HttpServletRequest request) throws Exception;

	
}

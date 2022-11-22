package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rb.base.model.QnaDto;

public interface QnaService {

	public List<QnaDto> qnaList(HttpServletRequest request) throws Exception;
	
	public void userQuestionInsert(HttpServletRequest request) throws Exception;

	public void userQuestionUpdate(HttpServletRequest request) throws Exception;

	public List<QnaDto> qnaListAdmin(HttpServletRequest request) throws Exception;
	
	public void adminAnswerInsert(HttpServletRequest request) throws Exception;
	
}

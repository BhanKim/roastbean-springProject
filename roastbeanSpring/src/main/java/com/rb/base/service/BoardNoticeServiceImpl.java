package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.BoardNoticeDao;
import com.rb.base.model.BoardDto;
@Service
public class BoardNoticeServiceImpl implements BoardNoticeService {
	@Autowired
	BoardNoticeDao dao;
	
	@Override
	public void boardnList(HttpServletRequest request, Model model) throws Exception {
		List<BoardDto> boardnList=dao.boardnList();
		model.addAttribute("boardnList",boardnList);
	}

	@Override
	public void bSearch(HttpServletRequest request, Model model) throws Exception {
		
		String option=request.getParameter("b_opt");
		String keyword=request.getParameter("keyword");
		keyword='%'+keyword+'%';
		
		List<BoardDto> boardsearch=dao.bSearch(option,keyword);
		model.addAttribute("boardlistsearch",boardsearch);
	}



}
package com.rb.base.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.BoardDto;
import com.rb.base.service.BoardNoticeService;

@Controller
public class BoardNoticeController {

	
	@Autowired
	BoardNoticeService service;
	
	@RequestMapping("/boardnList")
	public String boardnList(Model model)throws Exception{
		List<BoardDto> boardnList=service.boardnList();
		model.addAttribute("boardnList",boardnList);
		return "cboardnotice";
		
	}
	
	@RequestMapping("/bSearch")
	public String bSearch(HttpServletRequest request, Model model)throws Exception{
		List<BoardDto> boardsearch=service.bSearch(request.getParameter("b_opt"), request.getParameter("keyword"));
		model.addAttribute("boardList",boardsearch);
		return "cboardlist";
	}
}

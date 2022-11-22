package com.rb.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.service.BoardNoticeService;

@Controller
public class BoardNoticeController {

	
	@Autowired
	BoardNoticeService service;
	
	@RequestMapping("/boardnList")
	public String boardnList(HttpServletRequest request, Model model)throws Exception{
		service.boardnList(request, model);
		return "cboardnotice";
	}
	
	@RequestMapping("/bSearch")
	public String bSearch(HttpServletRequest request, Model model)throws Exception{
		service.bSearch(request, model);
		return "cboardsearch";
	}
}

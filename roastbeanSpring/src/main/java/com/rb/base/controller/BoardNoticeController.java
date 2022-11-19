package com.rb.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.BoardDto;
import com.rb.base.service.BoardNoticeDaoService;

@Controller
public class BoardNoticeController {

	
	@Autowired
	BoardNoticeDaoService service;
	
	@RequestMapping("/cboardnotice.do")
	public String BoardNoticeList(Model model)throws Exception{
		List<BoardDto>BoardNoticeDao=service.BoardNoticeList();
		model.addAttribute("nList",BoardNoticeDao);
		return "cboardnotice";
		
	}
}

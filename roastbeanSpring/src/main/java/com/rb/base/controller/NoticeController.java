package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.NoticeDto;
import com.rb.base.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service;
	
	@RequestMapping("/notice_list")
	public String notice_list(HttpServletRequest request, Model model) throws Exception{
		List<NoticeDto> dtos = service.noticeList(request);
		model.addAttribute("userNoticeList", dtos);
		return "cs_notice";
	}
	
	@RequestMapping("/notice_insert_by_admin")
	public String notice_insert_by_admin(HttpServletRequest request) throws Exception{
		service.insertAction(request);
		return "redirect:notice_list";
	}
	
	@RequestMapping("/notice_update_by_admin")
	public String notice_update_by_admin(HttpServletRequest request) throws Exception{
		service.updateAction(request);
		return "redirect:notice_list";
	}

}

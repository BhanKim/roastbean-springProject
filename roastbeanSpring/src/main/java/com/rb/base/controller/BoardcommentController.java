package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rb.base.service.BoardcommentService;

@Controller
public class BoardcommentController {
	
	@Autowired
	BoardcommentService service;

	
	@RequestMapping("/coWrite")
	public String coWrite(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.coWrite(request,attributes);
		return "redirect:content_view";
	}//댓글 작성하기 controller
	
	@RequestMapping("/coModify")
	public String coModify(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.coModify(request, attributes);
		return "redirect:content_view";
	}//댓글 수정하기 controller
	
	@RequestMapping("/coDelete")
	public String coDelete(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.coDelete(request, attributes);
		return "redirect:content_view";
	}//댓글 삭제하기
	
}

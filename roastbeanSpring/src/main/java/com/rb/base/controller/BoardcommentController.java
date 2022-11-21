package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.BoardcommentDto;
import com.rb.base.service.BoardcommentService;

@Controller
public class BoardcommentController {
	
	@Autowired
	BoardcommentService service;
	
	// 자유게시판 리스트
//	@RequestMapping("/cList")
//	public String commentList(HttpServletRequest request, Model model)throws Exception{
//		System.out.println("community_id"+Integer.parseInt(request.getParameter("community_id")));
//		List<BoardcommentDto> commentList = service.cList(Integer.parseInt(request.getParameter("community_id")));
//		model.addAttribute("cList", commentList);
//		return "content_view";
//	}
	
}

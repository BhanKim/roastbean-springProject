package com.rb.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.BoardDto;
import com.rb.base.model.BoardcommentDto;
import com.rb.base.service.BoardService;
import com.rb.base.service.BoardcommentService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	
	// 자유게시판 리스트
	@RequestMapping("/boardList")
	public String boardList(Model model)throws Exception{
		List<BoardDto> boardList = service.boardList();
		model.addAttribute("boardList", boardList);
		return "cboardlist";
	}
	
	// 게시글 보기
	@RequestMapping("/content_view")
	public String boardView(HttpServletRequest request, Model model) throws Exception{
		BoardDto contentDto = service.contentView(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("content_view", contentDto);
		String re = "forward:/cList";
		return re;
	}
}

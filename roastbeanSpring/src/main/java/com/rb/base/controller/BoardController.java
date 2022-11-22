package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rb.base.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	HttpSession session;
	
	
	// 자유게시판 리스트
	@RequestMapping("/boardList")
	public String boardList(HttpServletRequest request, Model model)throws Exception{
		service.boardList(request, model);
		return "cboardlist";
	}
	
	// 게시글 보기
	@RequestMapping("/content_view")
	public String boardView(HttpServletRequest request, Model model) throws Exception{
		service.contentView(request, model);
		service.cList(model, request);
		service.upHit(request);
		return "cboardcontent_view";
	}
	
	// 글쓰기 보기
	@RequestMapping("boardwrite_view")
	public String write_view()throws Exception{
		return "cboardwrite_view";
	}
	
	// 글작성
	@RequestMapping("/boardwrite")
	public String boardwrtie(HttpServletRequest request)throws Exception{
		service.boardwrite(request);
		return "redirect:boardList";
	}
	
	// 글수정페이지 보기
	@RequestMapping("modify_view")
	public String modify_view(HttpServletRequest request, Model model)throws Exception{
		service.modify_view(request, model);
		return "cboardupdate";
	}
	
	// 글삭제
	@RequestMapping("/communitydelete")
	public String communitydelete(HttpServletRequest request)throws Exception{
		service.communitydelete(request);
		return "redirect:boardList";
	}
	
	// 글수정
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.modify(request, attributes);
		return "redirect:content_view";
	}
	
	// 좋아요
	@RequestMapping("/boardlike")
	public String like(HttpServletRequest request, RedirectAttributes attributes)throws Exception{
		service.like(request, attributes);
		return "redirect:content_view";
	}
	
	// 답글작성페이지
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model)throws Exception{
		service.reply_view(request, model);
		return "cboardreply_view";
	}
	
	// 답글기능
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request) throws Exception{
		service.reply(request);
//		service.replyshape(request);
		return "redirect:boardList";
	}

	
} // End

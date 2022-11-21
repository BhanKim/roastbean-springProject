package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.rb.base.dao.BoardDao;
import com.rb.base.dao.BoardcommentDao;
import com.rb.base.model.BoardDto;
import com.rb.base.model.BoardcommentDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boarddao;
	
	@Autowired
	BoardcommentDao boardcommentdao;
	
	@Autowired
	HttpSession session;

	// boardlist
	@Override
	public void boardList(Model model) throws Exception {
		// TODO Auto-generated method stub
		List<BoardDto> boardList = boarddao.boardList();
		model.addAttribute("boardList", boardList);
	}

	// content view
	@Override
	public void contentView(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		BoardDto contentDto = boarddao.contentView(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("content_view", contentDto);
	}

	@Override
	public void boardwrite(HttpSession session, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String community_name = (String) session.getAttribute("ID");
		String community_title =  request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		boarddao.boardwrite(community_name, community_title, community_content);
	}

	@Override
	public void cList(Model model, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		List<BoardcommentDto> clist = boardcommentdao.cList(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("cList", clist);
	}

	@Override
	public void communitydelete(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		int community_id =Integer.parseInt(request.getParameter("community_id"));
		boarddao.communitydelete(community_id);
	}

	@Override
	public void modify_view(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		BoardDto modifyview = boarddao.modify_view(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("modify_view", modifyview);
		
	}

	@Override
	public void modify(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String community_title = request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		int community_id = Integer.parseInt(request.getParameter("community_id"));
		boarddao.modify(community_title, community_content, community_id);
		
	}






}

package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rb.base.dao.BoardDao;
import com.rb.base.dao.BoardcommentDao;
import com.rb.base.model.BoardDto;
import com.rb.base.model.BoardcommentDto;
import com.rb.base.model.PageInfo;

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
	public void boardList(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수
		int totalCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		
		if(tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}
		
		totalCount = boarddao.boardlistrow();
		PageInfo dto = new PageInfo(cPage, totalCount, listCount, pageLength);
		
		rowCount = (totalCount -((cPage-1)*10));
		int start = rowCount - 9;
		List<BoardDto> boardList = boarddao.boardList(cPage, start, rowCount);
		model.addAttribute("page", dto);
		model.addAttribute("boardList", boardList);
	}

	// content view
	@Override
	public void contentView(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		BoardDto contentDto = boarddao.contentView(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("content_view", contentDto);
	}
	
	// 글쓰기
	@Override
	public void boardwrite(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String community_name = (String) session.getAttribute("ID");
		String community_title =  request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		boarddao.boardwrite(community_name, community_title, community_content);
	}

	// 댓글 list
	@Override
	public void cList(Model model, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		List<BoardcommentDto> clist = boardcommentdao.cList(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("cList", clist);
	}

	// 글삭제
	@Override
	public void communitydelete(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		int community_id =Integer.parseInt(request.getParameter("community_id"));
		boarddao.communitydelete(community_id);
	}

	// 글수정창보기
	@Override
	public void modify_view(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		BoardDto modifyview = boarddao.modify_view(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("modify_view", modifyview);
		
	}

	// 글수정
	@Override
	public void modify(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		// TODO Auto-generated method stub
		String community_title = request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		int community_id = Integer.parseInt(request.getParameter("community_id"));
		attributes.addAttribute("community_id", community_id);
		boarddao.modify(community_title, community_content, community_id);
		
	}

	// 조회수 증가
	@Override
	public void upHit(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		int community_id = Integer.parseInt(request.getParameter("community_id"));
		boarddao.upHit(community_id);
	}
	
	// 좋아요
	@Override
	public void like(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		// TODO Auto-generated method stub
		int community_id = Integer.parseInt(request.getParameter("community_id"));
		attributes.addAttribute("community_id", community_id);
		boarddao.like(community_id);
		
	}

	// 답글작성페이지
	@Override
	public void reply_view(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		BoardDto reply_view = boarddao.reply_view(Integer.parseInt(request.getParameter("community_id")));
		model.addAttribute("reply_view",reply_view);
	}
	
	// 답글작성
	@Override
	public void reply(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String community_name = (String) session.getAttribute("ID");
		String community_title = request.getParameter("community_title");
		String community_content = request.getParameter("community_content");
		int community_group = Integer.parseInt(request.getParameter("community_group"));
		int community_step = Integer.parseInt(request.getParameter("community_step"));
		int community_indent = Integer.parseInt(request.getParameter("community_indent"));
		boarddao.reply(community_name, community_title, community_content, community_group, community_step, community_indent);
		
		int community_step1 = Integer.parseInt(request.getParameter("community_step"));
		int community_indent1 = Integer.parseInt(request.getParameter("community_indent"));
		boarddao.replyshape(community_indent1, community_step1);
	}

	@Override
	public void nList(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		List<BoardDto> nList = boarddao.nList();
		model.addAttribute("nList", nList);
	}

	@Override
	public void myboardlist(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		int cPage = 0; // 시작페이지
		int pageLength = 5; // 페이징에 표시될 개수
		int totalCount = 0; // 총 페이징 수
		int listCount = 10; // 보여지는 게시글 수 페이지에
		int rowCount = 0; // 총 게시글 갯수
		String tempPage = request.getParameter("page"); // JSP 페이지 값 넣어주는 것
		String community_name = (String) session.getAttribute("ID");
		
		if(tempPage == null || tempPage.length() == 0) {
			cPage = 1;
		}
		try {
			cPage = Integer.parseInt(tempPage);
		}catch(Exception e) {
			cPage = 1;
		}
		
		totalCount = boarddao.myboardlistrow(community_name);
		PageInfo dto = new PageInfo(cPage, totalCount, listCount, pageLength);
		
		rowCount = (totalCount -((cPage-1)*10));
		int start = rowCount - 9;
		List<BoardDto> myboardList = boarddao.myboardlist(cPage, start, rowCount, community_name);
		model.addAttribute("page", dto);
		model.addAttribute("myboardlist", myboardList);
	}

	// 답글정렬구분메소드
//	@Override
//	public void replyshape(HttpServletRequest request) throws Exception {
//		// TODO Auto-generated method stub
//
//		
//	}






}

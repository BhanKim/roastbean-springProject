package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rb.base.dao.BoardcommentDao;

@Service
public class BoardcommentServiceImpl implements BoardcommentService {

	@Autowired
	BoardcommentDao boardcommentdao;
	
	@Autowired
	HttpSession session;//session값을 가져오기 위한 선언
	
	

	@Override
	public void coWrite(HttpServletRequest request,RedirectAttributes attributes) throws Exception {
		String community_id=request.getParameter("community_id");
		String community_comment_name=(String)session.getAttribute("ID");
		String community_comment_content=request.getParameter("community_comment_content");
		attributes.addAttribute("community_id",community_id);
		boardcommentdao.coWrite(community_id,community_comment_name,community_comment_content);
		//controller에서 redirect를 사용하기 위해서 기존에 view page에서 전달 받은 값을 그대로 받아야 되기 때문에 addattribute를 해준다.
		//serviceㅇ 부분에서
	}



	@Override
	public void coModify(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		String community_comment_content=request.getParameter("community_comment_content");
		String community_comment_cono=request.getParameter("community_comment_cono");
		String community_id=request.getParameter("community_id");
		
		attributes.addAttribute("community_id",community_id);
		boardcommentdao.coModify(community_comment_content, community_comment_cono);
		
		
	}



	@Override
	public void coDelete(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		String community_id=request.getParameter("community_id");
		String community_comment_cono=request.getParameter("community_comment_cono");
		
		attributes.addAttribute("community_id",community_id);
		boardcommentdao.coDelete(community_comment_cono);
	}

	

}

package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BoardcommentService {
	
	public void coWrite(HttpServletRequest request, RedirectAttributes attributes) throws Exception;//댓글 작성
	public void coModify(HttpServletRequest request,RedirectAttributes attributes) throws Exception;//댓글 수정 반환할 값 없기때문에 void
	public void coDelete(HttpServletRequest request, RedirectAttributes attributes)throws Exception;
	
	//댓글 등록,수정및 삭제를 하고 난뒤에 redirectAttrubutes로 해당되는 게시글의 페이지를 보여줘야되기 때문에 attributes를 선언

}

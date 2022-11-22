package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface BoardService {
	public void boardList(HttpServletRequest request, Model model) throws Exception;
	public void contentView(HttpServletRequest request, Model model) throws Exception;
	public void boardwrite(HttpServletRequest request) throws Exception;
	public void cList(Model model, HttpServletRequest request)throws Exception;
	public void communitydelete(HttpServletRequest request)throws Exception;
	public void modify_view(HttpServletRequest request, Model model)throws Exception;
	public void modify(HttpServletRequest request, RedirectAttributes attributes)throws Exception;
	public void upHit(HttpServletRequest request)throws Exception;
	public void like(HttpServletRequest request, RedirectAttributes attributes)throws Exception;
	public void reply_view(HttpServletRequest request, Model model)throws Exception;
	public void reply(HttpServletRequest request) throws Exception;
//	public void replyshape(HttpServletRequest request) throws Exception;
}

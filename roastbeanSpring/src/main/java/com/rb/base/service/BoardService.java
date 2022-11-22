package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface BoardService {
	public void boardList(Model model) throws Exception;
	public void contentView(HttpServletRequest request, Model model) throws Exception;
	void boardwrite(HttpSession session, HttpServletRequest request) throws Exception;
	public void cList(Model model, HttpServletRequest request)throws Exception;
	public void communitydelete(HttpServletRequest request)throws Exception;
	public void modify_view(HttpServletRequest request, Model model)throws Exception;
	public void modify(HttpServletRequest request)throws Exception;

}

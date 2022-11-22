package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardNoticeService {
	public void boardnList(HttpServletRequest request, Model model) throws Exception;
	public void bSearch(HttpServletRequest request, Model model) throws Exception;
}

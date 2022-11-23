package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MProductService {
	public void mpList(HttpServletRequest request, Model model) throws Exception;

}

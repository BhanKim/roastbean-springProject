package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ChartDaoService {

	public void ordercount(HttpServletRequest request, Model model)throws Exception;
	
}

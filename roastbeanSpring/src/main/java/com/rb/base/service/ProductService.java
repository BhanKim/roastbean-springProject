package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface ProductService {
	
	public void productList(HttpServletRequest request, Model model) throws Exception;
	
}

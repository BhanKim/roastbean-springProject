package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface FindPasswordService {

	public int findPwUserCheck(HttpServletRequest request) throws Exception;
	public String FindPw(HttpServletRequest request) throws Exception;
	
}

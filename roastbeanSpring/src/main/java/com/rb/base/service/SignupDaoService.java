package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

public interface SignupDaoService {

	public void checkId(HttpServletRequest request) throws Exception;
	public void checkNick(HttpServletRequest request) throws Exception;
	
	public void signupAction(HttpServletRequest request) throws Exception;
	public void signupApiAction(HttpServletRequest request) throws Exception;
	
}

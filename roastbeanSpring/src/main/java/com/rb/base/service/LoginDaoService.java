package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import com.rb.base.model.UserDto;

public interface LoginDaoService {

	public UserDto loginCheck(HttpServletRequest request) throws Exception;

	public UserDto loginCheckApi(String user_id) throws Exception;
	
	public int loginCheckAdmin(String admin_id, String _pw) throws Exception;
	
	public UserDto cartCount(String user_id) throws Exception;

}

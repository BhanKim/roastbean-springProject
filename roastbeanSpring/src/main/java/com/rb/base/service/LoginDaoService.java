package com.rb.base.service;

import com.rb.base.model.LoginDto;

public interface LoginDaoService {

	public LoginDto loginCheck(String user_id, String user_pw) throws Exception;
	public int loginCheck2(String user_id, String user_pw) throws Exception;
	public int loginCheckAdmin(String admin_id, String _pw) throws Exception;
	
}

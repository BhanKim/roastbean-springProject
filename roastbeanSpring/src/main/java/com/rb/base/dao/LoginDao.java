package com.rb.base.dao;

import com.rb.base.model.LoginDto;

public interface LoginDao {
	
	public LoginDto loginCheck(String user_id, String user_pw) throws Exception;
	public int loginCheck2(String user_id, String user_pw) throws Exception;
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception;

}

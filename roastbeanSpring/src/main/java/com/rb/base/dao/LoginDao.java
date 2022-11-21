package com.rb.base.dao;

import com.rb.base.model.UserDto;

public interface LoginDao {
	
	public UserDto loginCheck(String user_id, String user_pw) throws Exception;
	
	public UserDto loginCheckApi(String user_id) throws Exception;
	
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception;

	public UserDto cartCount(String user_id) throws Exception;

}

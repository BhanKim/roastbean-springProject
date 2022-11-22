package com.rb.base.dao;

import com.rb.base.model.UserDto;

public interface UserInfoDao {
	
	public UserDto userInfoList(String user_id) throws Exception;
	
	public int userPwCheck(String user_id, String user_pw) throws Exception;
	
	public void userInfoUpdate(String user_id, String user_nick, String user_telno, String user_email, String user_addresszipcode, String user_address1, String user_address2, String user_address3) throws Exception;

}

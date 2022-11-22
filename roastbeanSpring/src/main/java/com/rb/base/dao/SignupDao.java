package com.rb.base.dao;

public interface SignupDao {
	
	public int checkId(String user_id) throws Exception;
	public int checkNick(String user_nick) throws Exception;
	
	public void signupAction(String user_id, String user_name, String user_nick, String user_pw, String user_telno, String user_email, String user_birthday, String user_gender, String user_addresszipcode, String user_address1, String user_address2, String user_address3) throws Exception;
	public void signupApiAction(String user_id, String user_name, String user_nick, String user_telno, String user_email, String user_birthday, String user_gender, String user_addresszipcode, String user_address1, String user_address2, String user_address3) throws Exception;
	
}

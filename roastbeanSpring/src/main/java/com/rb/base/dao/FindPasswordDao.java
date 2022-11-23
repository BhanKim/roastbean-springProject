package com.rb.base.dao;

public interface FindPasswordDao {

	public int findPwUserCheck(String user_id, String user_name, String user_email) throws Exception;
	public String findPassword(String user_id, String user_name, String user_email) throws Exception;

}

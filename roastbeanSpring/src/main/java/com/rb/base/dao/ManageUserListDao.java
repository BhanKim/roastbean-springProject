package com.rb.base.dao;

import java.util.List;

import com.rb.base.model.UserDto;

public interface ManageUserListDao {// service가 아는 녀석
	
	public int userListRow(String query, String content) throws Exception;
	public List<UserDto> userList(int cPage , int start, int rowCount, String query, String content) throws Exception;
	
}//END 

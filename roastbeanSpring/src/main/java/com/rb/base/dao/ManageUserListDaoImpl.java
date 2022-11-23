package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.UserDto;

public class ManageUserListDaoImpl implements ManageUserListDao {
	// xml query와 connect
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ManageUserListDao";
	
	@Override
	public int userListRow() throws Exception {
		return sqlSession.selectOne(nameSpace + ".userListRow");
	}
	@Override
	public List<UserDto> userList(int cPage , int start, int rowCount, String query, String content) throws Exception{
		return sqlSession.selectList(nameSpace + ".userList");
	}

}//class end 

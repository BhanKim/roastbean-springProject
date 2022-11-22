package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.UserDto;

public class ManageUserListDaoImpl implements ManageUserListDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.ManageUserListDao";
	
	@Override
	public int userListRow(String query, String category) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userListRow");
	}

	@Override
	public List<UserDto> userList(int cPage,String category, String query, int start, int rowCount) throws Exception {
		return sqlSession.selectList(nameSpace + ".userList");
	}
	

}//class end 

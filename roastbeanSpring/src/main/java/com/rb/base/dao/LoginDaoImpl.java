package com.rb.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.UserDto;

public class LoginDaoImpl implements LoginDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.LoginDao";

	@Override
	public UserDto loginCheck(String user_id, String user_pw) throws Exception {
		return (UserDto) sqlSession.selectList(nameSpace + ".loginCheck");
	}
	
	@Override
	public UserDto loginCheckApi(String user_id) throws Exception {
		return (UserDto) sqlSession.selectList(nameSpace + ".loginCheckApi");
	}
	
	@Override
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".loginCheckAdmin");
	}
	
	@Override
	public UserDto cartCount(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".cartCount");
	}

}

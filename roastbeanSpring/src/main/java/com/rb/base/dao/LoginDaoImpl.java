package com.rb.base.dao;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.LoginDto;

public class LoginDaoImpl implements LoginDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.LoginDao";

	@Override
	public LoginDto loginCheck(String user_id, String user_pw) throws Exception {
		return (LoginDto) sqlSession.selectList(nameSpace + ".loginCheck");
	}

	@Override
	public int loginCheck2(String user_id, String user_pw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".loginCheck2");
	}

	@Override
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".loginCheckAdmin");
	}

}

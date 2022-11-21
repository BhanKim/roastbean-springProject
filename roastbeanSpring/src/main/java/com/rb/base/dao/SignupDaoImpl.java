package com.rb.base.dao;

import org.apache.ibatis.session.SqlSession;

public class SignupDaoImpl implements SignupDao {

	SqlSession sqlSession;

	public static String nameSpace = "com.rb.base.dao.SignupDao";

	@Override
	public int checkId(String user_id) throws Exception {
		return sqlSession.selectOne(nameSpace + ".checkId");
	}

	@Override
	public int checkNick(String user_nick) throws Exception {
		return sqlSession.selectOne(nameSpace + ".checkNick");
	}

	
	@Override
	public void signupAction(String user_id, String user_name, String user_nick, String user_pw, String user_telno,
			String user_email, String user_birthday, String user_gender, String user_addresszipcode,
			String user_address1, String user_address2, String user_address3) throws Exception {
		sqlSession.insert(nameSpace + "signupAction");
	}

	@Override
	public void signupApiAction(String user_id, String user_name, String user_nick, String user_telno,
			String user_email, String user_birthday, String user_gender, String user_addresszipcode,
			String user_address1, String user_address2, String user_address3) throws Exception {
		sqlSession.insert(nameSpace + "signupApiAction");
	}

}

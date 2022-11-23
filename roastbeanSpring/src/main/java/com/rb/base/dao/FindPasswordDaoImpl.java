package com.rb.base.dao;

import org.apache.ibatis.session.SqlSession;

public class FindPasswordDaoImpl implements FindPasswordDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.rb.base.dao.FindPasswordDao";

	@Override
	public int findPwUserCheck(String user_id, String user_name, String user_email) throws Exception {
		
		return sqlSession.selectOne(nameSpace + ".findPwUserCheck");
		
	}
	
	@Override
	public String findPassword(String user_id, String user_name, String user_email) throws Exception {
		
		return sqlSession.selectOne(nameSpace + ".findPassword");
	}
}

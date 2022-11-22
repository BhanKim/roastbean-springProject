package com.rb.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rb.base.model.MyOrderListDto;
import com.rb.base.model.QnaDto;
import com.rb.base.model.UserDto;

public class UserInfoDaoImpl implements UserInfoDao {

	SqlSession sqlSession;

	public static String nameSpace = "com.rb.base.dao.UserInfoDao";

	@Override
	public UserDto userInfoList(String user_id) throws Exception {
		return (UserDto) sqlSession.selectList(nameSpace + ".userInfoList");
	}

	@Override
	public int userPwCheck(String user_id, String user_pw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userPwCheck");
	}

	@Override
	public void userInfoUpdate(String user_id, String user_nick, String user_telno, String user_email,
			String user_addresszipcode, String user_address1, String user_address2, String user_address3)
			throws Exception {
		sqlSession.update(nameSpace + ".userInfoUpdate");
	}

	@Override
	public List<MyOrderListDto> myOrderList(String user_id) throws Exception {
		return sqlSession.selectList(nameSpace + ".myOrderList");
	}

}

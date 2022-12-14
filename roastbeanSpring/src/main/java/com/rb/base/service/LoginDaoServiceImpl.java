package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.LoginDao;
import com.rb.base.model.UserDto;

@Service
public class LoginDaoServiceImpl implements LoginDaoService {

	@Autowired
	LoginDao dao;
	
	@Override
	public UserDto loginCheck(HttpServletRequest request) throws Exception {
	    String user_id = request.getParameter("user_id");
	    String user_pw = request.getParameter("user_pw");

		return dao.loginCheck(user_id, user_pw);
	}

	@Override
	public UserDto loginCheckApi(String user_id) throws Exception {
		return dao.loginCheckApi(user_id);
	}

	@Override
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception {
		return dao.loginCheckAdmin(admin_id, admin_pw);
	}
	
	@Override
	public UserDto cartCount(String user_id) throws Exception {
		return dao.cartCount(user_id);
	}

}

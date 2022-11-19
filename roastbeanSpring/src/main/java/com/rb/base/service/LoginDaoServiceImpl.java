package com.rb.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.LoginDao;
import com.rb.base.model.LoginDto;

@Service
public class LoginDaoServiceImpl implements LoginDaoService {

	@Autowired
	LoginDao dao;
	
	@Override
	public LoginDto loginCheck(String user_id, String user_pw) throws Exception {
		return dao.loginCheck(user_id, user_pw);
	}

	@Override
	public int loginCheck2(String user_id, String user_pw) throws Exception {
		// TODO Auto-generated method stub
		return dao.loginCheck2(user_id, user_pw);
	}

	@Override
	public int loginCheckAdmin(String admin_id, String admin_pw) throws Exception {
		// TODO Auto-generated method stub
		return dao.loginCheckAdmin(admin_id, admin_pw);
	}
	
	
	
	
//	HttpSession session = request.getSession(); // *******session
////	String user_id = request.getParameter("user_id");
////	String user_pw = request.getParameter("user_pw");
//
//	DaoUserLogin dao = new DaoUserLogin();
//	DtoUserLogin dto = dao.loginCheck(user_id, user_pw);
//	int checkLogin = dto.getCheck();
//
//	if (checkLogin == 1) {
//		session.setAttribute("ID", user_id);
//		session.setAttribute("NICK", dto.getUser_nick());
//		checkLogin = 1;
//	} else {
//		checkLogin = 0;
//	}
//	request.setAttribute("checkLogin", checkLogin);
//	
//	DtoUser dtos = dao.cartCount(user_id);
//	session.setAttribute("CARTCOUNT", dtos);
//}

}

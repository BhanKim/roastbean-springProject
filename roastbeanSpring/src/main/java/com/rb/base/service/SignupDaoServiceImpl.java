package com.rb.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.LoginDao;
import com.rb.base.dao.SignupDao;

@Service
public class SignupDaoServiceImpl implements SignupDaoService {

	@Autowired
	SignupDao dao;
	LoginDao loginDao;

	@Override
	public void checkId(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_pw_check = request.getParameter("user_pw_check");
		String user_telno = request.getParameter("user_telno");
		String user_telno1 = request.getParameter("user_telno1");
		String user_telno2 = request.getParameter("user_telno2");
		String user_telno3 = request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		String user_birthday = request.getParameter("user_birthday");
		String user_gender = request.getParameter("user_gender");
		String user_initdate = request.getParameter("user_initdate");
		String checkNickDuplication = request.getParameter("checkNickDuplication");
		
		int checkIdDuplication = dao.checkId(user_id);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("user_pw_check", user_pw_check);
		request.setAttribute("user_pw_telno", user_telno);
		request.setAttribute("user_pw_telno1", user_telno1);
		request.setAttribute("user_pw_telno2", user_telno2);
		request.setAttribute("user_pw_telno3", user_telno3);
		request.setAttribute("user_email", user_email);
		request.setAttribute("user_addresszipcode", user_addresszipcode);
		request.setAttribute("user_address1", user_address1);
		request.setAttribute("user_address2", user_address2);
		request.setAttribute("user_address3", user_address3);
		request.setAttribute("user_birthday", user_birthday);
		request.setAttribute("user_gender", user_gender);
		request.setAttribute("user_initdate", user_initdate);
		request.setAttribute("checkIdDuplication", checkIdDuplication);
		request.setAttribute("checkNickDuplication", checkNickDuplication);

	}

	@Override
	public void checkNick(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_pw_check = request.getParameter("user_pw_check");
		String user_telno = request.getParameter("user_telno");
		String user_telno1 = request.getParameter("user_telno1");
		String user_telno2 = request.getParameter("user_telno2");
		String user_telno3 = request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		String user_birthday1 = request.getParameter("user_birthday1");
		String user_birthday2 = request.getParameter("user_birthday2");
		String user_birthday3 = request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_initdate = request.getParameter("user_initdate");
		String checkIdDuplication = request.getParameter("checkIdDuplication");
		
		int checkNickDuplication = dao.checkNick(user_nick);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_nick", user_nick);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("user_pw_check", user_pw_check);
		request.setAttribute("user_telno", user_telno);
		request.setAttribute("user_telno1", user_telno1);
		request.setAttribute("user_telno2", user_telno2);
		request.setAttribute("user_telno3", user_telno3);
		request.setAttribute("user_email", user_email);
		request.setAttribute("user_addresszipcode", user_addresszipcode);
		request.setAttribute("user_address1", user_address1);
		request.setAttribute("user_address2", user_address2);
		request.setAttribute("user_address3", user_address3);
		request.setAttribute("user_birthday1", user_birthday1);
		request.setAttribute("user_birthday2", user_birthday2);
		request.setAttribute("user_birthday3", user_birthday3);
		request.setAttribute("user_gender", user_gender);
		request.setAttribute("user_initdate", user_initdate);
		request.setAttribute("checkIdDuplication", checkIdDuplication);
		request.setAttribute("checkNickDuplication", checkNickDuplication);
	}

	@Override
	public void signupAction(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_pw = request.getParameter("user_pw");
		String user_telno = request.getParameter("user_telno");
		String user_email = request.getParameter("user_email");
		String user_birthday = request.getParameter("user_birthday1") +"-"+ request.getParameter("user_birthday2") +"-"+ request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		dao.signupAction(user_id, user_name, user_nick, user_pw, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3);
	}

	@Override
	public void signupApiAction(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_email");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String user_telno = request.getParameter("user_telno");
		String user_email = request.getParameter("user_email");
		String user_birthday = request.getParameter("user_birthday1") +"-"+ request.getParameter("user_birthday2") +"-"+ request.getParameter("user_birthday3");
		String user_gender = request.getParameter("user_gender");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		dao.signupApiAction(user_id, user_name, user_nick, user_telno, user_email, user_birthday, user_gender, user_addresszipcode, user_address1, user_address2, user_address3);
	}
	

}

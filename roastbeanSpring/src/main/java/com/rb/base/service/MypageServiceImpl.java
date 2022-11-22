package com.rb.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.base.dao.MypageDao;
import com.rb.base.model.MyOrderListDto;
import com.rb.base.model.QnaDto;
import com.rb.base.model.UserDto;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	MypageDao dao;

	@Override
	public UserDto userInfoList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		return dao.userInfoList(user_id);
	}

	@Override
	public int userPwCheck(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("ID");
		String user_pw = request.getParameter("user_pw");
		
		int userPwCheck = dao.userPwCheck(user_id, user_pw);
		request.setAttribute("userPwCheck", userPwCheck);
		
		return userPwCheck;
	}

	@Override
	public void userInfoUpdate(HttpServletRequest request) throws Exception {
		String user_id = request.getParameter("user_id");
		String user_nick = request.getParameter("user_nick");
		String user_telno = request.getParameter("user_telno1")+request.getParameter("user_telno2")+request.getParameter("user_telno3");
		String user_email = request.getParameter("user_email");
		String user_addresszipcode = request.getParameter("user_addresszipcode");
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_address3 = request.getParameter("user_address3");
		System.out.println(user_telno);
		
		dao.userInfoUpdate(user_id, user_nick, user_telno, user_email, user_addresszipcode, user_address1, user_address2, user_address3);
		
		HttpSession session = request.getSession();
		session.setAttribute("NICK", user_nick);
	}

	@Override
	public List<MyOrderListDto> myOrderList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		return dao.myOrderList(user_id);
	}

	@Override
	public List<QnaDto> qnaList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("ID");
		
		return dao.qnaList(user_id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

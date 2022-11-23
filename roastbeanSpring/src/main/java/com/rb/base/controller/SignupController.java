package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rb.base.service.LoginDaoService;
import com.rb.base.service.SignupDaoService;

@Controller
public class SignupController {
	
	@Autowired
	SignupDaoService service;
	LoginDaoService loginDaoService;
	
	@RequestMapping("/signup")
	public String signup(HttpServletRequest request) throws Exception{
		return "signup";
	}
	
	@RequestMapping("/signup_api")
	public String signupApi(HttpServletRequest request) throws Exception{
		return "signup_api";
	}
	
	// *** 아이디 중복 체크하기 // 2022-11-21 완료 SangwonKim
	@RequestMapping("/check_id")
	public String checkId(HttpServletRequest request, Model model) throws Exception{
		service.checkId(request);
		String page = request.getParameter("page"); 
		return page;
	}

	// *** 닉네임 중복 체크하기 // 2022-11-21 완료 SangwonKim
	@RequestMapping("/check_nick")
	public String checkNick(HttpServletRequest request) throws Exception{
		service.checkNick(request);
		String page = request.getParameter("page");
		return page;
	}
	
	// *** 일반 회원가입하기 / 2022-11-21 완료 SangwonKim
	@RequestMapping("/signup_action") 
	public String signupAction(HttpServletRequest request) throws Exception{
		service.signupAction(request);
		HttpSession session = request.getSession();
		session.setAttribute("ID", request.getParameter("user_id"));
		session.setAttribute("NICK", request.getParameter("user_nick"));
		session.setAttribute("CARTCOUNT", 0);
		return "index";
	}

	// *** Api를 통한 회원가입하기 / 2022-11-21 완료 SangwonKim
	@RequestMapping("/signup_api_action")
	public String signupApiAction(HttpServletRequest request) throws Exception{
		service.signupApiAction(request);
		HttpSession session = request.getSession();
		session.setAttribute("ID", request.getParameter("user_email"));
		session.setAttribute("NICK", request.getParameter("user_nick"));
		session.setAttribute("API", "1");
		session.setAttribute("CARTCOUNT", 0);
		return "index";
	}
	
	// *** Email 체크하기 / 2022-11-22 완료 YunHyeonJeong
	@RequestMapping("/EmailCheck")
	@ResponseBody
	public String emailCheck(HttpServletRequest request) throws Exception {
		return service.sendEmail(request) + "";
	}

}

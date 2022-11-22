package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.UserDto;
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
	
	
	@RequestMapping("/check_id")
	public String checkId(HttpServletRequest request, Model model) throws Exception{
		
		service.checkId(request);
		
		String page = request.getParameter("page"); 
		return page;
	}

	@RequestMapping("/check_nick")
	public String checkNick(HttpServletRequest request) throws Exception{
		
		service.checkNick(request);
		
		String page = request.getParameter("page");
		return page;
	}
	
	// *** 2022-11-19 / 2022-11-21 완료 SangwonKim
	@RequestMapping("/signup_action") 
	public String signupAction(HttpServletRequest request) throws Exception{
		service.signupAction(request);
		HttpSession session = request.getSession();
		System.out.println(">>>>1");
		session.setAttribute("ID", request.getParameter("user_id"));
		session.setAttribute("NICK", request.getParameter("user_nick"));
		
		session.setAttribute("CARTCOUNT", 0);
		
		return "index";
		
	}

	// *** 2022-11-19 / 2022-11-21 완료 SangwonKim
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

}

package com.rb.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.base.model.UserDto;
import com.rb.base.service.LoginDaoService;

@Controller
public class LoginController {
	
	@Autowired
	LoginDaoService service;
	
	// 로그인 화면 *** 2022-11-21 완료 SangwonKim
	@RequestMapping("/login")
	public String login()throws Exception{
		return "login";
	}
	
	// 로그인 실행 *** 2022-11-19 SangwonKim
	@RequestMapping("/login_action")
	public String login_action(HttpServletRequest request) throws Exception{
	    HttpSession session = request.getSession();
	    UserDto dto = service.loginCheck(request);
	    int count = dto.getCount();
	    
		if(count == 1) {
			session.setAttribute("ID", request.getParameter("user_id"));
			session.setAttribute("NICK", dto.getUser_nick());
			
			String uuser_id = (String) session.getAttribute("ID");
			UserDto dtos = service.cartCount(uuser_id);
			session.setAttribute("CARTCOUNT", dtos);

			return "index";
		}else {
			return "login";
		}
	}

	// API 로그인 실행 *** 2022-11-21 SangwonKim
	@RequestMapping("/login_api_action")
	public String login_api_action(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String api_email = request.getParameter("api_email");
		UserDto dto = service.loginCheckApi(api_email);
	    int count = dto.getCount();
		
		if(count == 1) {
			session.setAttribute("ID", api_email);
			session.setAttribute("NICK", dto.getUser_nick());
			
			String uuser_id = (String) session.getAttribute("ID");
			UserDto dtos = service.cartCount(uuser_id);
			session.setAttribute("CARTCOUNT", dtos);
			
			return "index";
		}else {
			request.setAttribute("api_email", request.getParameter("api_email"));
			return "signup_api";
		}
	}
	
	// Admin 로그인 화면 *** 2022-11-19 SangwonKim
	@RequestMapping("/login_admin")
	public String login_admin()throws Exception{
		return "login_admin";
	}
	
	// 관리자 로그인 실행 *** 2022-11-19 SangwonKim
	@RequestMapping("/login_admin_action")
	public String login_admindo(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
	    String admin_id = request.getParameter("admin_id");
	    String admin_pw = request.getParameter("admin_pw");
	    int count = service.loginCheckAdmin(admin_id, admin_pw);
	
	    if(count == 1) {
			session.setAttribute("ID", admin_id);
			session.setAttribute("ADMIN", admin_id);
			session.setAttribute("NICK", "관리자");
			return "index";
		}else {
			return "login_admin";
		}
	}
	
	// Logout 실행 *** 2022-11-20 SangwonKim
	@RequestMapping("/logout_action")
	public String logoutdo(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:";
	}
	

}
